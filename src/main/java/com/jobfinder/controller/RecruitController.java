package com.jobfinder.controller;

import com.jobfinder.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecruitController {

    @Autowired
    RecruitService recruitService;

    @RequestMapping("/noticeDetail")
    public String noticeDetail(Model model){
        return "noticeDetail";
    }
}
