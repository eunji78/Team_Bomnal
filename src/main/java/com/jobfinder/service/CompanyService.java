package com.jobfinder.service;


import com.jobfinder.domain.Company_info;
import com.jobfinder.domain.Criteria;
import com.jobfinder.domain.Recruit;
import com.jobfinder.domain.Reviews;
import com.jobfinder.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CompanyService{

    @Autowired
    CompanyRepository companyRepository;

    public ArrayList<Company_info> list(Criteria cri) {
        ArrayList<Company_info> list = companyRepository.list(cri);
        return list;
    }

    public int count(String industry_class) {
        int counting = companyRepository.count(industry_class);
        return counting;
    }

    public Company_info detail(String company_id) {
        Company_info detail = companyRepository.detail(company_id);
        return detail;
    }

    public ArrayList<Reviews> review(String company_id) {
        ArrayList<Reviews> review = companyRepository.review(company_id);
        return  review;
    }

    public void save(Reviews reviews) {
        companyRepository.save(reviews);
    }

    public Reviews avg(String company_id){
        Reviews avg = companyRepository.avg(company_id);
        return avg;
    }

    public ArrayList<Recruit> gongo(String company_id) {
        ArrayList<Recruit> gongo = companyRepository.gongo(company_id);
        return gongo;
    }

    public int countgongo(String company_id) {
        int countgongo = companyRepository.countgongo(company_id);
        return countgongo;
    }
}
