package com.jobfinder.repository;

import com.jobfinder.domain.Criteria;
import com.jobfinder.domain.Recruit;
import com.jobfinder.persistence.RecruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecruitRepository {
    @Autowired
    RecruitMapper recruitMapper;

    public Recruit notice(int r_seq){
        Recruit notice = recruitMapper.notice(r_seq);
        return notice;
    }

    public ArrayList<Recruit> noticeList(int super_job_seq){
        ArrayList<Recruit> noticeList = recruitMapper.noticeList(super_job_seq);
        return noticeList;
    }

    public ArrayList<Recruit> allList(Criteria cri){
        ArrayList<Recruit> allList = recruitMapper.allList(cri);
        return allList;
    }

    public void insertJobPosting(Recruit recruit) {
        recruitMapper.insertJobPosting(recruit);
    }

    public List<Recruit> getLatestRecruits(){
        List<Recruit> recruits = recruitMapper.getLatestRecruits();
        return recruits;
    }
}
