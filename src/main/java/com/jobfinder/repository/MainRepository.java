package com.jobfinder.repository;

import com.jobfinder.domain.Job;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MainRepository {
    public List<Job> getList();

    public List<Job> getJobDetail(int super_seq);
}
