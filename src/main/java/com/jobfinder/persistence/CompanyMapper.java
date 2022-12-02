package com.jobfinder.persistence;

import com.jobfinder.domain.Company_info;
import com.jobfinder.domain.Criteria;
import com.jobfinder.domain.Reviews;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface CompanyMapper {

    public ArrayList<Company_info> list (Criteria cri);
    public Company_info detail(String company_id);

    public ArrayList<Reviews> review(String company_id);

    public int count(String industry_class);

    public void save(Reviews reviews);

    public Reviews avg(String company_id);
}
