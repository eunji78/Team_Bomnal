package com.jobfinder.repository;

import com.jobfinder.domain.Job;
import com.jobfinder.persistence.MainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MainRepository {

    private final MainMapper mainMapper;
    public List<Job> jobList(){
        return mainMapper.jobList();
    }

    public List<Job> getJobDetail(int super_seq){
        return mainMapper.getJobDetail(super_seq);
    }
}
