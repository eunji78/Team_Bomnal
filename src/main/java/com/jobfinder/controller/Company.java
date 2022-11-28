package com.jobfinder.controller;

import com.jobfinder.domain.Company_info;
import com.jobfinder.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Company {
	@Autowired
	CompanyService companyService;

	@GetMapping("/companyList")
	public String CompanyList(Model model){
		List<Company_info> list = companyService.list();
		model.addAttribute("list",list);
		return "CompanyList";
	}
	
	@GetMapping("/companyDetail/{company_id}")
	public String CompanyDetail(Company_info c, Model model) {
		List<Company_info> detail = companyService.detail(c.getCompany_id());
		model.addAttribute("detail",detail);

		return "CompanyDetail";
	}

	@GetMapping("/CompanyReview")
	public String CompanyReview() {
		return "CompanyReview";
	}

	@GetMapping("/Recruit")
	public String Recruit(){
		return "Recruit";
	}

}
