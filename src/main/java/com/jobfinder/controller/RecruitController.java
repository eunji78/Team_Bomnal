package com.jobfinder.controller;

import com.jobfinder.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecruitController {

    @Autowired
    RecruitService recruitService;

    @GetMapping("/noticeDetail")
    public String noticeDetail(){
        return "noticeDetail";
    }
}
