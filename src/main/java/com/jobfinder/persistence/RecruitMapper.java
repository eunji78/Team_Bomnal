package com.jobfinder.persistence;

import com.jobfinder.domain.Recruit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecruitMapper {
    public Recruit notice(int r_seq);
    public List<Recruit> noticeList(int super_job_seq);

    public void insertJobPosting(Recruit recruit);

    public List<Recruit> getLatestRecruits();
}
