package com.jobfinder.persistence;

import com.jobfinder.domain.Recruit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecruitMapper {
    public Recruit notice(int r_seq);

    void insertJobPosting(Recruit recruit);
}
