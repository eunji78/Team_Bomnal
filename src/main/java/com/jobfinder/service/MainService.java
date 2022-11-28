package com.jobfinder.service;

import com.jobfinder.domain.Job;
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

    public String test() {
        return "test중";
    }

    public List<Job> getJobDetail(int super_seq) {
        List<Job> getJobDetail = mainRepository.getJobDetail(super_seq);
        return getJobDetail;
    }
}
