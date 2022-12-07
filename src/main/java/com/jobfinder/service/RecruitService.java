package com.jobfinder.service;

import com.jobfinder.domain.Recruit;
import com.jobfinder.repository.RecruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitService {

    @Autowired
    RecruitRepository recruitRepository;

    public Recruit notice(int r_seq){
        Recruit notice = recruitRepository.notice(r_seq);
        return notice;
    }

    public void insertJobPosting(Recruit recruit) {
        recruitRepository.insertJobPosting(recruit);
    }
}
