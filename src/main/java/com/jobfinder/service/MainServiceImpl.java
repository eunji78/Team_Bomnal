package com.jobfinder.service;

import com.jobfinder.domain.Job;
import com.jobfinder.repository.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl {
    @Autowired
    MainMapper mainMapper;

        public List<Job> jobList = mainMapper.getList();

}
