package com.jobfinder.service;

import com.jobfinder.domain.Company_info;
import com.jobfinder.domain.Job;
import com.jobfinder.domain.RegionVO;
import com.jobfinder.domain.Reviews;
import com.jobfinder.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService{

    @Autowired
    MainRepository mainRepository;

    public List<Job> jobList() {
        List<Job> job_list = mainRepository.jobList();
        return job_list;
    }

    public List<RegionVO> regionList(){
        List<RegionVO> region_list = mainRepository.regionList();
        return region_list;
    }


    public List<Job> getJobDetail(int super_seq) {
        List<Job> getJobDetail = mainRepository.getJobDetail(super_seq);
        return getJobDetail;
    }

    public List<RegionVO> getRegionDetail(int super_seq) {
        List<RegionVO> getRegionDetail = mainRepository.getRegionDetail(super_seq);
        return getRegionDetail;
    }

    public List<Company_info> getBestCompanies(){
        List<Company_info> company_info = mainRepository.getBestCompanies();
        return company_info;
    }

    public List<Reviews> getBestCompaniesReview() {
        List<Reviews> reviews = mainRepository.getBestCompaniesReview();
        return reviews;
    }
}
