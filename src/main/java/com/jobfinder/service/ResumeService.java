package com.jobfinder.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jobfinder.domain.*;
import com.jobfinder.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;

    public int resume_add(Map<String, String> param){

        ObjectMapper objectMapper = new ObjectMapper();
        Resume resume = objectMapper.convertValue(param, Resume.class);
        resumeRepository.resume_add(resume);

        return resumeRepository.resume_num(resume.getMembers_mem_id());
    }

    public void lang_add(Map<String, String> param){
        ObjectMapper objectMapper = new ObjectMapper();
        Language lang = objectMapper.convertValue(param, Language.class);
        resumeRepository.lang_add(lang);
    }

    public void career_add(Map<String, String> param){
        ObjectMapper objectMapper = new ObjectMapper();
        Career career = objectMapper.convertValue(param, Career.class);
        resumeRepository.career_add(career);
    }

    public void awards_add(Map<String, String> param){
        ObjectMapper objectMapper = new ObjectMapper();
        Awards awards = objectMapper.convertValue(param, Awards.class);
        resumeRepository.awards_add(awards);
    }

    public void cert_add(Map<String, String> param){
        ObjectMapper objectMapper = new ObjectMapper();
        Certificate cert = objectMapper.convertValue(param, Certificate.class);
        resumeRepository.cert_add(cert);
    }

}
