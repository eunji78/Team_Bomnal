package com.jobfinder.persistence;

import com.jobfinder.domain.Company_info;
import com.jobfinder.domain.Job;
import com.jobfinder.domain.RegionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    public List<Job> jobList();

    public List<RegionVO> regionList();

    public List<Job> getJobDetail(int super_seq);

    public List<RegionVO> getRegionDetail(int super_seq);

    public List<Company_info> getBestCompanies();
}
