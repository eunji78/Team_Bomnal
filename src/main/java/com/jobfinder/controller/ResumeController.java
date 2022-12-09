package com.jobfinder.controller;

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
    public int resume_add(@RequestBody Map<String, String> param){

        int num = resumeService.resume_add(param);

        return num ;
    }

    @PostMapping("/resume/lang")
    @ResponseBody
    public void lang_add(@RequestBody Map<String, String> param){

        resumeService.lang_add(param);

    }

    @PostMapping("/resume/career")
    @ResponseBody
    public void career_add(@RequestBody Map<String, String> param){

        resumeService.career_add(param);

    }

    @PostMapping("/resume/cert")
    @ResponseBody
    public void cert_add(@RequestBody Map<String, String> param){

        resumeService.cert_add(param);

    }

    @PostMapping("/resume/awards")
    @ResponseBody
    public void awards_add(@RequestBody Map<String, String> param){

        resumeService.awards_add(param);

    }
}
