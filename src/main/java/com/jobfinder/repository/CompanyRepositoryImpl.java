package com.jobfinder.repository;

import com.jobfinder.domain.Company_info;
import com.jobfinder.persistence.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CompanyRepositoryImpl implements CompanyRepository {

    @Autowired
    CompanyMapper companyMapper;


    @Override
    public List<Company_info> list() {
        return null;
    }

    @Override
    public List<Company_info> detail(int company_id) {
        List<Company_info> detail = companyMapper.detail(company_id);
        return null;
    }
}
