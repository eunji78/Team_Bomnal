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

    public Recruit notice(){
        Recruit notice = recruitMapper.notice();
        return notice;
    }
}
