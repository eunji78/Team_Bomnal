package com.jobfinder.repository;

import com.jobfinder.domain.Company_info;
import com.jobfinder.persistence.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyRepository{

    @Autowired
    CompanyMapper companyMapper;

    public List<Company_info> list() {
        return null;
    }

    public List<Company_info> detail(int company_id) {
        List<Company_info> detail = companyMapper.detail(company_id);
        return null;
    }
}
