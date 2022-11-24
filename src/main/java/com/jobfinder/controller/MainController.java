package com.jobfinder.controller;

import com.jobfinder.domain.Job;
import com.jobfinder.persistence.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    MainService mainService;

    public String main(Model model){
        List<Job> job_list = mainService.getList();
        model.addAttribute("job_list",job_list);
        return "main";
    }
}
