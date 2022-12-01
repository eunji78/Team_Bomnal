package com.jobfinder.controller;

import com.jobfinder.domain.Recruit;
import com.jobfinder.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecruitController {

    @Autowired
    RecruitService recruitService;

    @RequestMapping("/noticeDetail/{r_seq}")
    public String noticeDetail(@PathVariable int r_seq, Model model){

        Recruit notice = recruitService.notice(r_seq);
        model.addAttribute("notice",notice);

        return "noticeDetail";
    }
}
