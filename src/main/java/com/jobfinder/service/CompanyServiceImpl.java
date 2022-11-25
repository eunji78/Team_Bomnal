package com.jobfinder.service;


import com.jobfinder.domain.Company_info;
import com.jobfinder.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<Company_info> detail(int company_id) {
        List<Company_info> c_list = companyRepository.detail(company_id);
        return c_list;
    }

    @Override
    public List<Company_info> list() {
        return null;
    }
}
