package com.jobfinder.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jobfinder.domain.*;
import com.jobfinder.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;

    public int resume_add(Resume resume){
        resumeRepository.resume_add(resume);
        return resumeRepository.resume_num(resume.getMembers_mem_id());
    }

    public void lang_add(Language language){
        resumeRepository.lang_add(language);
    }

    public void career_add(Career career){
        resumeRepository.career_add(career);
    }

    public void awards_add(Awards awards){
        resumeRepository.awards_add(awards);
    }

    public void cert_add(Certificate certificate){
        resumeRepository.cert_add(certificate);
    }

}
