package com.jobfinder.controller;

import com.google.gson.JsonObject;
import com.jobfinder.domain.Recruit;
import com.jobfinder.service.RecruitService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

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

    public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile) {

        JsonObject jsonObject = recruitService.uploadSummernoteImageFile(multipartFile);

        return jsonObject;
    }
}
