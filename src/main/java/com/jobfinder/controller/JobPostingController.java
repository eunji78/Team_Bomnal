package com.jobfinder.controller;

import com.google.gson.JsonObject;
import com.jobfinder.domain.Job;
import com.jobfinder.domain.Recruit;
import com.jobfinder.service.MainService;
import com.jobfinder.service.RecruitService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Controller
public class JobPostingController {
    @Autowired
    MainService mainService;

    @Autowired
    RecruitService recruitService;

    @RequestMapping("/jobPostingForm")
    public String jobPosting(Model model){
        List<Job> job_list = mainService.jobList();
        model.addAttribute("job_list",job_list);
        return "job_posting";
    }

    @RequestMapping("/testSummerNote")
    public String jobPostring(String test){
        System.out.println(test);
        return "/";
    }

    @PostMapping(value="/uploadSummernoteImageFile", produces = "application/json")
    @ResponseBody
    public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile) {

        JsonObject jsonObject = recruitService.uploadSummernoteImageFile(multipartFile);

        return jsonObject;
    }

    @RequestMapping("/insertJobPosting")
    public String jobPosting(@ModelAttribute Recruit recruit){
        System.out.println(recruit);
        recruitService.insertJobPosting(recruit);
        System.out.println("입력 완료!");
        return "redirect:/";
    }


}
