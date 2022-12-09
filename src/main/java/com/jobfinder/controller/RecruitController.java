package com.jobfinder.controller;

import com.google.gson.JsonObject;
import com.jobfinder.domain.Criteria;
import com.jobfinder.domain.Job;
import com.jobfinder.domain.Recruit;
import com.jobfinder.domain.RegionVO;
import com.jobfinder.service.MainService;
import com.jobfinder.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RecruitController {
    @Autowired
    MainService mainService;
    @Autowired
    RecruitService recruitService;

    @RequestMapping("/noticeDetail/{r_seq}")
    public String noticeDetail(@PathVariable int r_seq, Model model){

        Recruit notice = recruitService.notice(r_seq);
        model.addAttribute("notice",notice);

        return "noticeDetail";
    }

    @RequestMapping("/noticeList")
    public String allList(Model model, Criteria cri) {
        List<Job> job_list = mainService.jobList();
        model.addAttribute("job_list", job_list);
        List<RegionVO> region_list = mainService.regionList();
        model.addAttribute("region_list", region_list);
        ArrayList<Recruit> noticeList = recruitService.allList(cri);
        model.addAttribute("noticeList", noticeList);

        return "noticeList";
    }

    @RequestMapping("/noticeList/{super_job_seq}")
    public String noticeList(@PathVariable int super_job_seq, Model model){
        List<Job> job_list = mainService.jobList();
        model.addAttribute("job_list",job_list);
        List<RegionVO> region_list = mainService.regionList();
        model.addAttribute("region_list",region_list);
        ArrayList<Recruit> noticeList = recruitService.noticeList(super_job_seq);
        model.addAttribute("noticeList", noticeList);

        return "noticeList";
    }



    public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile) {

        JsonObject jsonObject = recruitService.uploadSummernoteImageFile(multipartFile);

        return jsonObject;
    }



}
