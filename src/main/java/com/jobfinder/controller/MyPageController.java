package com.jobfinder.controller;

import com.jobfinder.domain.*;
import com.jobfinder.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final ResumeService resumeService;

    @GetMapping("/resume_form")
    public String resume_form(){
        return "resume_form";
    }

    @GetMapping("/resume_edit/{seq}")
    public String resume_edit(@PathVariable int seq, Model model){

        Resume resume = resumeService.get_resume(seq);
        Certificate certificate = resumeService.get_cert(seq);
        Career career = resumeService.get_career(seq);
        Language lang = resumeService.get_lang(seq);
        Awards awards = resumeService.get_awards(seq);

        model.addAttribute("resume", resume);
        model.addAttribute("cert", certificate);
        model.addAttribute("career", career);
        model.addAttribute("lang", lang);
        model.addAttribute("awards", awards);

        return "resume_edit";
    }


    @GetMapping("/resume_manage")
    public String resumeMange(HttpSession session, Model model){
        LoginVO VO = (LoginVO) session.getAttribute("VO");
        String mem_id = VO.getMem_id();
        List<Resume> resumes = resumeService.resume_list(mem_id);
        model.addAttribute("resume", resumes);
        return "resume_manage";
    }
}
