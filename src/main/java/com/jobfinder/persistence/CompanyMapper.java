package com.jobfinder.persistence;

import com.jobfinder.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface CompanyMapper {

    public ArrayList<CompanyList> listmain(Criteria cri);

    public ArrayList<CompanyList> listsearch(Criteria cri);
    public ArrayList<Company_info> list (Criteria cri);
    public Company_info detail(String company_id);

    public ArrayList<Reviews> review(Reviews reviews);

    public int countmain();

    public int countsearch(String keyword);

    public int count(String industry_class);

    public void save(Reviews reviews);

    public Reviews avg(String company_id);

    public ArrayList<Recruit> gongo(String company_id);

    public int countgongo(String company_id);

    public int countreview(String company_id);

    public int likecheck(Review_like like);
    public void likeinsert(Review_like like);

    public void likedelete(Review_like like);
}
