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

    public List<Recruit> notice(List<Recruit> RecruitRepository){
        List<Recruit> notice = recruitRepository.notice();
        return notice;
    }
}
