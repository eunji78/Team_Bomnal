package com.jobfinder.repository;

import com.jobfinder.domain.Job;
import com.jobfinder.domain.RegionVO;
import com.jobfinder.persistence.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MainRepository {

    @Autowired
    MainMapper mainMapper;

    public List<Job> jobList() {
        List<Job> job_list = mainMapper.jobList();
        return job_list;
    }

    public List<RegionVO> regionList(){
        List<RegionVO> region_list = mainMapper.regionList();
        return region_list;
    }

    public List<Job> getJobDetail(int super_seq) {
        List<Job> getJobDetail = mainMapper.getJobDetail(super_seq);
        return getJobDetail;
    }

    public List<RegionVO> getRegionDetail(int super_seq){
        List<RegionVO> getRegionDetail = mainMapper.getRegionDetail(super_seq);
        return getRegionDetail;
    }
}
