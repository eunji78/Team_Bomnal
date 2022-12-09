package com.jobfinder.controller;

import com.jobfinder.domain.FileDto;
import com.jobfinder.domain.LoginVO;
import com.jobfinder.domain.Login_ComVO;
import com.jobfinder.domain.Recruit;
import com.jobfinder.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;





    @PostMapping(value = "/upload")
    // 업로드하는 파일들을 MultipartFile 형태의 파라미터로 전달된다.
    @ResponseBody
    public String upload(@RequestParam(value = "uploadfile", required = false) MultipartFile file, Model model, HttpSession session)
            throws IllegalStateException, IOException {

        System.out.println("file : " + file);

        List<FileDto> list = new ArrayList<>();
        FileDto dto = new FileDto(UUID.randomUUID().toString(),
                file.getOriginalFilename(),
                file.getContentType());
        list.add(dto);

//        System.out.println(dto.getFileName());
//         System.out.println(dto.getUuid());

        File newFileName = new File(dto.getUuid() + "_" + dto.getFileName());
        // 전달된 내용을 실제 물리적인 파일로 저장해준다.
        file.transferTo(newFileName);

        model.addAttribute("files", list);

        String fname = "/upload/" + dto.getUuid() + "_" + dto.getFileName();
        String type = (String) session.getAttribute("type");
//        System.out.println(type);
        if (type == "P") {
            LoginVO vo = (LoginVO) session.getAttribute("VO");
            session.removeAttribute("VO");
//            System.out.println(vo.getMem_id());
            vo.setMem_img(fname);
            int res = loginService.set_img_per(vo);
//            System.out.println(res);
            LoginVO rvo = loginService.login_per(vo);
            session.setAttribute("VO", rvo);
            System.out.println("session 가져옴 : " + rvo);
        } else if (type == "C") {
            Login_ComVO cvo = (Login_ComVO) session.getAttribute("VO");
            session.removeAttribute("VO");
//            System.out.println(cvo.getCompany_id());
            cvo.setCompany_img(fname);
            int res = loginService.set_img_com(cvo);
//            System.out.println(res);
            Login_ComVO rcvo = loginService.login_com(cvo);
            session.setAttribute("VO", rcvo);
            System.out.println("session 가져옴 : " + rcvo);
        }

        return fname;
    }









    @RequestMapping(value = "/all_delete_data")
    @ResponseBody
    public int all_delete_data(HttpSession session, Model model){
        System.out.println("회원탈퇴진행!");
        int res = 0;
        String type = (String) session.getAttribute("type");
        if (type == "P"){
            LoginVO vo = (LoginVO)session.getAttribute("VO");
            String mem_id = vo.getMem_id();
            res = loginService.all_delete_data_per(mem_id);
        } else if(type == "C"){
            Login_ComVO cvo = (Login_ComVO)session.getAttribute("VO");
            String company_id = cvo.getCompany_id();
            res = loginService.all_delete_data_com(company_id);
        }
        return res;
    }









    @RequestMapping(value = "/Com_gonggo_list")
    public String Com_gonggo_list(HttpSession session, Model model){

        Login_ComVO cvo = (Login_ComVO) session.getAttribute("VO");
        List<Recruit> rec_list = loginService.rec_list(cvo.getCompany_name());
        model.addAttribute("rec_list", rec_list);
        return "Com_gonggo_list";
    }

    @RequestMapping(value = "/Com_emp_list")
    public String Com_emp_list(HttpSession session, Model model){

        /*Login_ComVO cvo = (Login_ComVO) session.getAttribute("VO");
        List<resume> resume_list = loginService.resume_list(cvo.getCompany_id());
        model.addAttribute("resume_list", resume_list);*/
        return "Com_emp_list";
    }








    @RequestMapping(value = "/ump")
    public String ump(Model model, LoginVO loginVO){
        model.addAttribute("loginVO", loginVO);
        return "update_mypage";
    }
    @RequestMapping(value = "/umpc")
    public String umpc(Model model, Login_ComVO login_comVO){
        model.addAttribute("login_comVO", login_comVO);
        return "update_mypage_com";
    }


    @RequestMapping(value = "/update_my_page")
    public String update_my_page(@ModelAttribute("umpform_per") LoginVO vo, HttpSession session){
        System.out.println("session : " + session.getAttribute("VO"));
        System.out.println("update : " + vo);

        LoginVO sessionVO = (LoginVO) session.getAttribute("VO");

        if (vo.getMem_pw() == "" || vo.getMem_pw() == null || vo.getMem_pw().length() == 0) {
            vo.setMem_pw(sessionVO.getMem_pw());
        }
        if (vo.getMem_phone() == "" || vo.getMem_phone() == null || vo.getMem_phone().length() == 0) {
            vo.setMem_phone(sessionVO.getMem_phone());
        } else {
            StringBuffer sb = new StringBuffer();
            sb.append(vo.getMem_phone());
            if (sb.substring(0,1) == "02"){
                sb.insert(2,"-");
            } else {
                sb.insert(3,"-");
            }
            sb.insert(vo.getMem_phone().length()-3,"-");
            vo.setMem_phone(sb.toString());
        }
        if (vo.getMem_email() == "" || vo.getMem_email() == null || vo.getMem_email().length() == 0) {
            vo.setMem_email(sessionVO.getMem_email());
        }
        if (vo.getMem_addr() == "" || vo.getMem_addr() == null || vo.getMem_addr().length() == 0) {
            vo.setMem_addr(sessionVO.getMem_addr());
        }
        System.out.println("update : " + vo);
        loginService.update_vo(vo);

        return "redirect:/";
    }

    @RequestMapping(value = "/update_my_page_com")
    public String update_my_page_com(@ModelAttribute("umpform_com") Login_ComVO cvo, HttpSession session, @RequestParam(value = "file", required = false) MultipartFile file) {

        System.out.println("file : " + file);

        System.out.println("session : " + session.getAttribute("VO"));
        System.out.println("update : " + cvo);

        Login_ComVO sessionVO = (Login_ComVO) session.getAttribute("VO");

        if (cvo.getCompany_pw() == "" || cvo.getCompany_pw() == null || cvo.getCompany_pw().length() == 0) {
            cvo.setCompany_pw(sessionVO.getCompany_pw());
        }
        if (cvo.getCompany_phone() == "" || cvo.getCompany_phone() == null || cvo.getCompany_phone().length() == 0) {
            cvo.setCompany_phone(sessionVO.getCompany_pw());
        } else {
            StringBuffer sb = new StringBuffer();
            sb.append(cvo.getCompany_phone());
            if (sb.substring(0,1) == "02"){
                sb.insert(2,"-");
            } else {
                sb.insert(3,"-");
            }
            sb.insert(cvo.getCompany_phone().length()-3,"-");
            cvo.setCompany_phone(sb.toString());
        }
        if (cvo.getCompany_email() == "" || cvo.getCompany_email() == null || cvo.getCompany_email().length() == 0) {
            cvo.setCompany_email(sessionVO.getCompany_email());
        }
        if (cvo.getCompany_addrcompany() == "" || cvo.getCompany_addrcompany() == null || cvo.getCompany_addrcompany().length() == 0) {
            cvo.setCompany_addrcompany(sessionVO.getCompany_addrcompany());
        }

        loginService.update_cvo(cvo);

        return "redirect:/";
    }







    @RequestMapping(value = "/loginform")
    public String loginform() {
        return "loginform";
    }

    @RequestMapping(value = "/login_per")
    public String login_per(@RequestParam(value = "mem_id", required=false) String id, @RequestParam(value = "mem_pw", required=false) String pw, HttpSession session){
//        System.out.println("개인로그인시도");
//        System.out.println(id);
//        System.out.println(pw);
        LoginVO vo = new LoginVO();
        vo.setMem_id(id);
        vo.setMem_pw(pw);
        LoginVO rvo = loginService.login_per(vo);
        session.setAttribute("type","P");
        session.setAttribute("VO", rvo);
        System.out.println("로그인 세션 저장 : " + session.getAttribute("VO"));
//        System.out.println("개인로그인완료");
        return "redirect:/";
    };

    @RequestMapping(value = "/login_com")
    public String login_com(@ModelAttribute("loginform_com") Login_ComVO cvo, HttpSession session){
//        System.out.println("기업로그인시도");
//        System.out.println(cvo);
        Login_ComVO rcvo = loginService.login_com(cvo);
        session.setAttribute("type","C");
        session.setAttribute("VO", rcvo);
        System.out.println("로그인 세션 저장 : " + session.getAttribute("VO"));
//        System.out.println("기업로그인완료");
        return "redirect:/";
    };

    @RequestMapping(value = "/signup_local")
    public String signup_local(Model model, LoginVO loginVO) {
        model.addAttribute("LoginVO", loginVO);
        return "signup_local";
    }

    @RequestMapping(value = "/signup_company")
    public String signup_company(Model model, Login_ComVO login_comVO) {
        model.addAttribute("Login_ComVO",login_comVO);
        return "signup_company";
    }

    @RequestMapping(value = "/signup_com")
    public String signup_com(@ModelAttribute Login_ComVO cvo) {
        System.out.println("signup_com");
        System.out.println(cvo);

        StringBuffer sb = new StringBuffer();
        sb.append(cvo.getCompany_phone());
        if (sb.substring(0,1) == "02"){
            sb.insert(2,"-");
        } else {
            sb.insert(3,"-");
        }
        sb.insert(cvo.getCompany_phone().length()-3,"-");
        cvo.setCompany_phone(sb.toString());

        if (cvo.getC_agreement4() == "" || cvo.getC_agreement4() == null || cvo.getC_agreement4().length() == 0) {
            cvo.setC_agreement4("N");
        }
        if (cvo.getC_agreement5() == "" || cvo.getC_agreement5() == null || cvo.getC_agreement5().length() == 0) {
            cvo.setC_agreement5("N");
        }

        int res = loginService.set_signup_com(cvo);
        System.out.println(res);
        return "redirect:/";
    };

    @RequestMapping(value = "/signup_per")
    public String signup_per(@ModelAttribute LoginVO vo) {
        System.out.println("signup_per");
        System.out.println(vo);

        StringBuffer sb = new StringBuffer();
        sb.append(vo.getMem_phone());
        if (sb.substring(0,1) == "02"){
            sb.insert(2,"-");
        } else {
            sb.insert(3,"-");
        }
        sb.insert(vo.getMem_phone().length()-3,"-");
        vo.setMem_phone(sb.toString());

        if (vo.getM_agreement3() == "" || vo.getM_agreement3() == null || vo.getM_agreement3().length() == 0) {
            vo.setM_agreement3("N");
        }
        if (vo.getM_agreement4() == "" || vo.getM_agreement4() == null || vo.getM_agreement4().length() == 0) {
            vo.setM_agreement4("N");
        }
        if (vo.getM_agreement5() == "" || vo.getM_agreement5() == null || vo.getM_agreement5().length() == 0) {
            vo.setM_agreement5("N");
        }

        int res = loginService.set_signup_per(vo);
        System.out.println(res);
        return "redirect:/";
    };

    @RequestMapping(value = "/get_loginVO")
    @ResponseBody
    public String get_loginVO(@ModelAttribute("loginform_per") LoginVO vo) {

//        System.out.println("per 넘어오는 vo값 : " + vo);
        LoginVO rvo = loginService.login_per(vo);
//        System.out.println("per 받는 vo값 : " + rvo);
        String res = "";
        if (rvo == null){ res = "";}
        else { res = "exist";}
        return res;
    }

    @RequestMapping(value = "/get_login_ComVO")
    @ResponseBody
    public String get_login_ComVO(@ModelAttribute("loginform_com") Login_ComVO cvo) {

//        System.out.println("com 넘어오는 cvo값 : " + cvo);
        Login_ComVO rcvo = loginService.login_com(cvo);
//        System.out.println("com 받는 cvo값 : " + rcvo);
        String res = "";
        if (rcvo == null){ res = "";}
        else { res = "exist";}
        return res;
    }


    @RequestMapping(value = "/login_id_check_per")
    @ResponseBody
    public String login_id_check_per(@RequestParam("insert_id") String insert_id) {

//        System.out.println("per 넘어오는 id값 : " + insert_id);
        String mem_id = loginService.id_check_per(insert_id);
//        System.out.println("per 받는 id값 : " + mem_id);
        return mem_id;
    }

    @RequestMapping(value = "/login_id_check_com")
    @ResponseBody
    public String login_id_check_com(@RequestParam("insert_id") String insert_id) {

//        System.out.println("com 넘어오는 id값 : " + insert_id);
        String com_id = loginService.id_check_com(insert_id);
//        System.out.println("com 받는 id값 : " + com_id);
        return com_id;
    }

    @RequestMapping(value = "/kakaologin")
    public String login(@RequestParam(value = "code", required = false) String code, HttpSession session, HttpServletResponse response) throws Exception{

        System.out.println("loginController!!");

        System.out.println("####code#####" + code);

        String access_Token = loginService.getAccessToken(code);
        System.out.println("###access_Token#### : " + access_Token);

        Cookie token = new Cookie("authorize-access-token", access_Token);
        token.setPath("/");
        response.addCookie(token);

        //*
        HashMap<String, String> userInfo = loginService.getUserInfo(access_Token);
        System.out.println("###user_info### : " + userInfo);

        String mem_id = userInfo.get("id");
        String mem_pw = userInfo.get("id");
        String mem_name = userInfo.get("nickname");
        String mem_email = userInfo.get("email");

        String check = loginService.id_check_per(mem_id);

        if ( check == null ){
            System.out.println(mem_id);
            System.out.println(mem_name);
            System.out.println(mem_email);

            LoginVO vo = new LoginVO();
            vo.setMem_id(mem_id);
            vo.setMem_pw(mem_pw);
            vo.setMem_name(mem_name);
            vo.setMem_email(mem_email);
            vo.setMem_phone("");
            vo.setM_agreement1("Y");
            vo.setM_agreement2("Y");
            vo.setM_agreement3("");
            vo.setM_agreement4("");
            vo.setM_agreement5("");
            vo.setM_agreement6("3");

            int res = loginService.set_signup_kko(vo);

            LoginVO rvo = loginService.login_per(vo);

            session.setAttribute("type","P");
            session.setAttribute("VO", rvo);

            return "redirect:/loginform";
        } else {
            LoginVO vo = new LoginVO();
            vo.setMem_id(mem_id);
            vo.setMem_pw(mem_pw);

            LoginVO rvo = loginService.login_per(vo);

            session.setAttribute("type","P");
            session.setAttribute("VO", rvo);
            return "redirect:/loginform";
        }
    }

    @RequestMapping(value = "/v1/user/unlink")
    public String reset(HttpServletResponse response, HttpSession session) throws Exception {

        System.out.println("Reset code");

        Cookie token = new Cookie("authorize-access-token", null);
        token.setPath("/");
        token.setMaxAge(0);
        response.addCookie(token);

        session.removeAttribute("type");
        session.removeAttribute("VO");

        return "loginform";
    }
}
