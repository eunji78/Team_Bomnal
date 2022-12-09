package com.jobfinder.service;


import com.jobfinder.domain.*;
import com.jobfinder.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService{

    @Autowired
    CompanyRepository companyRepository;

    public ArrayList<CompanyList> listmain(Criteria cri) {
        ArrayList<CompanyList> listmain = companyRepository.listmain(cri);
        return listmain;
    }

    public ArrayList<CompanyList> listsearch(Criteria cri) {
        ArrayList<CompanyList> listsearch = companyRepository.listsearch(cri);
        return listsearch;
    }

    public ArrayList<Company_info> list(Criteria cri) {
        ArrayList<Company_info> list = companyRepository.list(cri);
        return list;
    }

    public int countmain() {
        int countmain = companyRepository.countmain();
        return countmain;
    }

    public int countsearch(String keyword) {
        int countsearch = companyRepository.countsearch(keyword);
        return countsearch;
    }

    public int count(String industry_class) {
        int counting = companyRepository.count(industry_class);
        return counting;
    }

    public Company_info detail(String company_id) {
        Company_info detail = companyRepository.detail(company_id);
        return detail;
    }

    public ArrayList<Reviews> review(Reviews reviews) {
        ArrayList<Reviews> review = companyRepository.review(reviews);
        return  review;
    }

    public void save(Reviews reviews) {
        companyRepository.save(reviews);
    }

    public Reviews avg(String company_id){
        Reviews avg = companyRepository.avg(company_id);
        return avg;
    }

    public ArrayList<Recruit> gongo(String company_id) {
        ArrayList<Recruit> gongo = companyRepository.gongo(company_id);
        return gongo;
    }

    public int countgongo(String company_id) {
        int countgongo = companyRepository.countgongo(company_id);
        return countgongo;
    }

    public int countreview(String company_id) {
        int countreview = companyRepository.countreview(company_id);
        return countreview;
    }


    public int likecheck(Review_like like){
        return companyRepository.likecheck(like);
    }
    public void likeinsert(Review_like like){
        companyRepository.likeinsert(like);
    }

    public void likedelete(Review_like like){
        companyRepository.likedelete(like);
    }





}
