package com.jobfinder.persistence;

import com.jobfinder.domain.Company_info;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface CompanyMapper {

    public ArrayList<Company_info> list ();
    public List<Company_info> detail(int company_id);

}
