package com.jobfinder.service;


import com.jobfinder.domain.Company_info;
import com.jobfinder.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public ArrayList<Company_info> list() {
        ArrayList<Company_info> list = companyRepository.list();
        return list;
    }

    @Override
    public List<Company_info> detail(int company_id) {
        return companyRepository.detail(company_id);
    }


}
