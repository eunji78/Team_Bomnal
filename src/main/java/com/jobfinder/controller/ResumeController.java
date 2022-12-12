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

    //이력서 삭제
    @PostMapping("/delete_resume/{seq}")
    public void delete_resume(@PathVariable int seq){
        resumeService.delete_resume(seq);
    }

    /**
     *  이력서 등록
     */
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


    /**
     *  이력서 수정
     */
    @PostMapping("/resume_edit")
    @ResponseBody
    public void resume_edit(@RequestBody Resume resume){
        resumeService.resume_edit(resume);
    }

    @PostMapping("/resume/lang_edit")
    @ResponseBody
    public void lang_edit(@RequestBody Language language){
        resumeService.lang_edit(language);
    }

    @PostMapping("/resume/career_edit")
    @ResponseBody
    public void career_edit(@RequestBody Career career){
        resumeService.career_edit(career);
    }

    @PostMapping("/resume/cert_edit")
    @ResponseBody
    public void cert_edit(@RequestBody Certificate certificate){
        resumeService.cert_edit(certificate);
    }

    @PostMapping("/resume/awards_edit")
    @ResponseBody
    public void awards_edit(@RequestBody Awards awards){
        resumeService.awards_edit(awards);
    }
}
