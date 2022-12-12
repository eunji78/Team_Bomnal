package com.jobfinder.controller;

import com.google.gson.JsonObject;
import com.jobfinder.domain.*;
import com.jobfinder.service.MainService;
import com.jobfinder.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(recruitService.countNotice(cri));
        model.addAttribute("pageMaker",pageMaker);

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


    @ResponseBody
    @RequestMapping("/uploadSummernoteImageFile")
    public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile) {

        JsonObject jsonObject = recruitService.uploadSummernoteImageFile(multipartFile);

        return jsonObject;
    }

    @RequestMapping("/updateJobPostingForm/{r_seq}")
    public String updateJobPostingForm(@PathVariable int r_seq, Model model){
        List<Job> job_list = mainService.jobList();
        model.addAttribute("job_list",job_list);
        Recruit recruit = recruitService.getRecruit(r_seq);
        model.addAttribute("recruit", recruit);
        return "/job_posting_edit";
    }

    @RequestMapping("/updateJobPosting")
    public String updateJobPosting(Recruit recruit){
        System.out.println(recruit);
        recruitService.updateJobPosting(recruit);
        System.out.println("수정완료!");
        return "redirect:/noticeDetail/"+recruit.getR_seq();
    }
}
