package com.jobfinder.repository;

import com.jobfinder.domain.Recruit;
import com.jobfinder.persistence.RecruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecruitRepository {
    @Autowired
    RecruitMapper recruitMapper;

    public Recruit notice(int r_seq){
        Recruit notice = recruitMapper.notice(r_seq);
        return notice;
    }

    public void insertJobPosting(Recruit recruit) {
        recruitMapper.insertJobPosting(recruit);
    }
}
