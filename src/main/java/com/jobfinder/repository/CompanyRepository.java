package com.jobfinder.repository;

import com.jobfinder.domain.*;
import com.jobfinder.persistence.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CompanyRepository {

    @Autowired
    CompanyMapper companyMapper;

    public ArrayList listmain(Criteria cri) {
        ArrayList<CompanyList> listmain = companyMapper.listmain(cri);
        return listmain;
    }

    public ArrayList<Company_info> list(Criteria cri) {
        ArrayList<Company_info> list = companyMapper.list(cri);
        return list;
    }
    public Company_info detail(String company_id) {
        Company_info detail = companyMapper.detail(company_id);
        return detail;
    }

    public ArrayList<Reviews> review(String company_id) {
        ArrayList<Reviews> review = companyMapper.review(company_id);
        return review;
    }

    public int countmain() {
        int countmain = companyMapper.countmain();
        return countmain;
    }

    public int count(String industry_class) {
        int counting = companyMapper.count(industry_class);
        return counting;
    }

    public void save(Reviews reviews) {
        companyMapper.save(reviews);
    }

    public Reviews avg(String company_id) {
        Reviews avg = companyMapper.avg(company_id);
        return avg;
    }

    public ArrayList<Recruit> gongo(String company_id) {
        ArrayList<Recruit> gongo = companyMapper.gongo(company_id);
        return gongo;
    }

    public int countgongo(String company_id) {
        int countgongo = companyMapper.countgongo(company_id);
        return countgongo;
    }

    public int countreview(String company_id) {
        int countreview = companyMapper.countreview(company_id);
        return countreview;
    }



}
