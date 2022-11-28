package com.jobfinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecruitController {

    @GetMapping("/noticeDetail")
    public String noticeDetail(){
        return "noticeDetail";
    }
}
