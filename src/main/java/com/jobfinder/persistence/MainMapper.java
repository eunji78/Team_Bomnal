package com.jobfinder.persistence;

import com.jobfinder.domain.Job;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    public List<Job> getList();

    public List<Job> getJobDetail(int super_seq);
}
