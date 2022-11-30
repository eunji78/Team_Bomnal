package com.jobfinder.controller;

import com.jobfinder.domain.Company_info;
import com.jobfinder.domain.Reviews;
import com.jobfinder.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.SortedMap;

@Controller
public class Company {
	@Autowired
	CompanyService companyService;

	@GetMapping("/CompanyList")
	public String CompanyList(Model model){
		List<Company_info> list = companyService.list();
		model.addAttribute("list",list);
		return "CompanyList";
	}
	
	@GetMapping("/companyDetail/{company_id}")
	public String CompanyDetail(@PathVariable String company_id, Model model) {
		Company_info detail = companyService.detail(company_id);
		model.addAttribute("detail",detail);
		return "CompanyDetail";
	}

	@GetMapping("/companyReview/{company_id}")
	public String CompanyReview(@PathVariable String company_id, Model model) {
		Reviews review = companyService.review(company_id);
		model.addAttribute("review",review);
		return "CompanyReview";
	}

	@GetMapping("/recruit")
	public String Recruit(){
		return "Recruit";
	}

}
