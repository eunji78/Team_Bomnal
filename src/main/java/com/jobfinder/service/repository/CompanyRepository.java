package com.jobfinder.service.repository;

import com.jobfinder.domain.Company_info;
import com.jobfinder.domain.Reviews;
import com.jobfinder.persistence.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRepository {

    @Autowired
    CompanyMapper companyMapper;

    public ArrayList<Company_info> list() {
        ArrayList<Company_info> list = companyMapper.list();
        return list;
    }
    public Company_info detail(String company_id) {
        Company_info detail = companyMapper.detail(company_id);
        return detail;
    }

    public Reviews review(String company_id) {
        Reviews review = companyMapper.review(company_id);
        return review;
    }
}
