package com.jobfinder.controller;

import com.jobfinder.domain.*;
import com.jobfinder.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping("/resume")
    @ResponseBody
    public int resume_add(@RequestBody Resume resume){
        int num = resumeService.resume_add(resume);
        return num ;
    }

    @PostMapping("/resume/lang")
    @ResponseBody
    public String lang_add(@RequestBody Language language){
        resumeService.lang_add(language);
        return null;
    }

    @PostMapping("/resume/career")
    @ResponseBody
    public String career_add(@RequestBody Career career){
        System.out.println( "career = " + career);
        resumeService.career_add(career);
        return null;
    }

    @PostMapping("/resume/cert")
    @ResponseBody
    public String cert_add(@RequestBody Certificate certificate){
        resumeService.cert_add(certificate);
        return null;
    }

    @PostMapping("/resume/awards")
    @ResponseBody
    public String awards_add(@RequestBody Awards awards){
        resumeService.awards_add(awards);
        return null;
    }
}
