package com.jobfinder.service;

import com.jobfinder.domain.Job;

import java.util.List;

public interface MainService {
    public List<Job> getList();

    public List<Job> getJobDetail(int super_seq);
}
