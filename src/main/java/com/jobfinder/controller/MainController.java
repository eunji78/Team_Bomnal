package com.jobfinder.controller;

import com.jobfinder.domain.Job;
import com.jobfinder.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    MainService mainService;

    @RequestMapping("main")
    public String main(Model model){
        List<Job> job_list = mainService.getList();
        model.addAttribute("job_list",job_list);
        return "main";
    }

    @RequestMapping("get_job_detail")
    @ResponseBody
    public List<Job> get_job_detail(@RequestParam("super_seq") int super_seq){

        List<Job> jobDetail = mainService.getJobDetail(super_seq);
        System.out.println("jobDetail = " + jobDetail);
        return jobDetail;
    }
}
