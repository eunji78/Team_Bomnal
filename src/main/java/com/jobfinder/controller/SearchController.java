package com.jobfinder.controller;

import com.jobfinder.domain.Job;
import com.jobfinder.domain.Recruit;
import com.jobfinder.domain.RegionVO;
import com.jobfinder.service.MainService;
import com.jobfinder.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SearchController {

    private final MainService mainService;
    private final SearchService searchService;

    @GetMapping(path = "/search")
    public String list(@RequestParam(value = "search[]") List<String> keywords , Model model){

        System.out.println("keywords = " + keywords);

//        List<Recruit> recruits = searchService.search(keywords);
//
//        List<Job> job_list = mainService.jobList();
//        model.addAttribute("job_list",job_list);
//        List<RegionVO> region_list = mainService.regionList();
//        model.addAttribute("region_list",region_list);
        return "searchList";

    }

}
