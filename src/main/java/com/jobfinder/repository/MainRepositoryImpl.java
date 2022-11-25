package com.jobfinder.repository;

import com.jobfinder.domain.Job;
import com.jobfinder.persistence.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MainRepositoryImpl implements MainRepository {

    @Autowired
    MainMapper mainMapper;


    @Override
    public List<Job> getList() {
        List<Job> job_list = mainMapper.getList();
        return job_list;
    }

    @Override
    public List<Job> getJobDetail(int super_seq) {
        List<Job> getJobDetail = mainMapper.getJobDetail(super_seq);
        return getJobDetail;
    }
}
