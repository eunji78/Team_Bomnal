package com.jobfinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageController {

    @GetMapping("/resume_form")
    public String resume_form(){
        return "resume_form";
    }

    @GetMapping("/resume_manage")
    public String resumeMange(){

        return "resume_manage";
    }
}
