package com.jobfinder.controller;

import com.jobfinder.domain.*;
import com.jobfinder.service.MainService;
import com.jobfinder.service.RecruitService;
import com.jobfinder.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SearchController {

    private final MainService mainService;
    private final SearchService searchService;

    @GetMapping(path = "/search")
    public String list(Criteria cri, HttpSession session, Model model){

        cri.setKeyword(cri.getKeyword());
        int counting = searchService.count_search(cri.getKeyword());

        List<Recruit> noticeList = searchService.search(cri);

        List<RegionVO> region_list = mainService.regionList();
        List<Job> job_list = mainService.jobList();

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(counting);

        session.setAttribute("pageMaker",pageMaker);
        model.addAttribute("job_list",job_list);
        model.addAttribute("region_list",region_list);
        model.addAttribute("noticeList", noticeList);
        return "searchList";

    }

}
