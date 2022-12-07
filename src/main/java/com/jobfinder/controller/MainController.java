package com.jobfinder.controller;

import com.jobfinder.domain.Company_info;
import com.jobfinder.domain.Job;
import com.jobfinder.domain.Recruit;
import com.jobfinder.domain.RegionVO;
import com.jobfinder.service.MainService;
import com.jobfinder.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    MainService mainService;

    @Autowired
    RecruitService recruitService;

    @RequestMapping
    public String main(Model model){
        List<Job> job_list = mainService.jobList();
        model.addAttribute("job_list",job_list);
        List<RegionVO> region_list = mainService.regionList();
        model.addAttribute("region_list",region_list);
        List<Company_info> company_info = mainService.getBestCompanies();
        model.addAttribute("company_info_list", company_info);
        List<Recruit> recruits = recruitService.getLatestRecruits();
        model.addAttribute("recruit_list", recruits);
        System.out.println("recruit list의 개수"+recruits.size());
        System.out.println(recruits.get(1));
        return "main";
    }

    @RequestMapping("get_job_detail")
    @ResponseBody
    public List<Job> get_job_detail(@RequestParam("super_seq") int super_seq){
        List<Job> jobDetail = mainService.getJobDetail(super_seq);
        return jobDetail;
    }

    @RequestMapping("get_region_detail")
    @ResponseBody
    public List<RegionVO> get_region_detail(@RequestParam("super_seq") int super_seq){
        List<RegionVO> regionDetail = mainService.getRegionDetail(super_seq);
        return regionDetail;
    }

}
