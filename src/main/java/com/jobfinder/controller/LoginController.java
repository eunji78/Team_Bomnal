package com.jobfinder.controller;

import com.jobfinder.domain.LoginVO;
import com.jobfinder.domain.Login_ComVO;
import com.jobfinder.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/loginform")
    public String loginform() { return "loginform"; }

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
        int res = loginService.set_signup_com(cvo);
        System.out.println(res);
        return "redirect:/loginform";
    };

    @RequestMapping(value = "/signup_per")
    public String signup_per(@ModelAttribute LoginVO vo) {
        System.out.println("signup_per");
        System.out.println(vo);
        int res = loginService.set_signup_per(vo);
        System.out.println(res);
        return "redirect:/loginform";
    };

    @RequestMapping(value = "/login_id_check_per")
    @ResponseBody
    public String login_id_check_per(@RequestParam("insert_id") String insert_id) {

        System.out.println("per 넘어오는 id값 : " + insert_id);
        String mem_id = loginService.id_check_per(insert_id);
        System.out.println("per 받는 id값 : " + mem_id);
        return mem_id;
    }

    @RequestMapping(value = "/login_id_check_com")
    @ResponseBody
    public String login_id_check_com(@RequestParam("insert_id") String insert_id) {

        System.out.println("com 넘어오는 id값 : " + insert_id);
        String com_id = loginService.id_check_com(insert_id);
        System.out.println("com 받는 id값 : " + com_id);
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

        String id = userInfo.get("id");
        String name = userInfo.get("nickname");
        String email = userInfo.get("email");

        String check = loginService.id_check_per(id);

        if ( check == null ){
            //System.out.println(id);
            //System.out.println(name);
            //System.out.println(email);

            LoginVO vo = new LoginVO();
            vo.setMem_id(id);
            vo.setMem_pw(id);
            vo.setMem_name(name);
            vo.setMem_email(email);
            vo.setMem_phone("");
            vo.setM_agreement1("Y");
            vo.setM_agreement2("Y");
            vo.setM_agreement3("");
            vo.setM_agreement4("");
            vo.setM_agreement5("");
            vo.setM_agreement6("3");
            int res = loginService.set_signup_kko(vo);
            //System.out.println(res);
            session.setAttribute("id", userInfo.get("id"));
            session.setAttribute("name", userInfo.get("name"));
//        session.setAttribute("nickname", userInfo.get("nickname"));
//        session.setAttribute("email", userInfo.get("email"));
//        session.setAttribute("profile_image", userInfo.get("profile_image"));
//        session.setAttribute("birthday", userInfo.get("birthday"));
//        session.setAttribute("gender", userInfo.get("gender"));

            return "redirect:/";
        } else {
            session.setAttribute("id", userInfo.get("id"));
            session.setAttribute("name", userInfo.get("name"));
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/v1/user/unlink")
    public String reset(HttpServletResponse response, HttpServletRequest request) throws Exception {

        System.out.println("Reset code");

        Cookie token = new Cookie("authorize-access-token", null);
        token.setPath("/");
        token.setMaxAge(0);
        response.addCookie(token);

        return "loginform";
    }
}
