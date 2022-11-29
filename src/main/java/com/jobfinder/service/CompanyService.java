package com.jobfinder.service;


import com.jobfinder.domain.Company_info;
import com.jobfinder.domain.Reviews;
import com.jobfinder.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService{

    @Autowired
    CompanyRepository companyRepository;

    public ArrayList<Company_info> list() {
        ArrayList<Company_info> list = companyRepository.list();
        return list;
    }

    public Company_info detail(String company_id) {
        Company_info detail = companyRepository.detail(company_id);
        return detail;
    }


    public Reviews review(String company_id) {
        Reviews review = companyRepository.review(company_id);
        return  review;
    }
}
