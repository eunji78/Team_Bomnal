package com.jobfinder.persistence;

import com.jobfinder.domain.Company_info;
import com.jobfinder.domain.Reviews;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface CompanyMapper {

    public ArrayList<Company_info> list ();
    public Company_info detail(String company_id);

    public Reviews review(String company_id);
}
