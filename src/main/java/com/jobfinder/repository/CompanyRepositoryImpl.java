package com.jobfinder.repository;

import com.jobfinder.domain.Company_info;
import com.jobfinder.persistence.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepositoryImpl implements CompanyRepository {

    @Autowired
    CompanyMapper companyMapper;

    @Override
    public ArrayList<Company_info> list() {
        ArrayList<Company_info> list = companyMapper.list();
        return list;
    }

    @Override
    public List<Company_info> detail(int company_id) {
        List<Company_info> detail = companyMapper.detail(company_id);
        return null;
    }
}
