package com.jobfinder.controller;

import com.jobfinder.domain.*;
import com.jobfinder.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final ResumeService resumeService;

    @GetMapping("/resume_form")
    public String resume_form(){
        return "resume_form";
    }

    @GetMapping("/resume_edit/{seq}")
    public String resume_edit(@RequestParam int seq , Resume resume, Awards awards, Language language,
                              Career career, Certificate certificate, HttpSession session){

        return "resume_edit";
    }


    @GetMapping("/resume_manage")
    public String resumeMange(){

        return "resume_manage";
    }
}
