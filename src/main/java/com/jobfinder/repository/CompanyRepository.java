package com.jobfinder.repository;

import com.jobfinder.domain.Company_info;

import java.util.List;

public interface CompanyRepository {

    public List<Company_info> list();
    public List<Company_info> detail(int company_id);

}
