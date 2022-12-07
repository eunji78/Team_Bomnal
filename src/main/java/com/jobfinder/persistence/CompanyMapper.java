package com.jobfinder.persistence;

import com.jobfinder.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface CompanyMapper {

    public ArrayList<CompanyList> listmain(Criteria cri);

    public ArrayList<Company_info> list (Criteria cri);
    public Company_info detail(String company_id);

    public ArrayList<Reviews> review(String company_id);

    public int countmain();

    public int count(String industry_class);

    public void save(Reviews reviews);

    public Reviews avg(String company_id);

    ArrayList<Recruit> gongo(String company_id);

    int countgongo(String company_id);

    int countreview(String company_id);




}
