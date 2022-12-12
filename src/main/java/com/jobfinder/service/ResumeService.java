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


    //이력서 삭제
    public void delete_resume(int seq){
        resumeRepository.delete_resume(seq);
    }

    /**
     *  이력서 등록
     */
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


    /**
     *  이력서 목록
     */
    public List<Resume> resume_list(String mem_id){
        return resumeRepository.resume_list(mem_id);
    }

    public Resume get_resume(int seq){
        return resumeRepository.get_resume(seq);
    }
    public Awards get_awards(int seq){
        return resumeRepository.get_awards(seq);
    }
    public Certificate get_cert(int seq){
        return resumeRepository.get_cert(seq);
    }
    public Career get_career(int seq){
        return resumeRepository.get_career(seq);
    }
    public Language get_lang(int seq){
        return resumeRepository.get_lang(seq);
    }


    /**
     *  이력서 수정
     */
    public void resume_edit(Resume resume){
        resumeRepository.resume_edit(resume);
    }

    public void lang_edit(Language language){
        resumeRepository.lang_edit(language);
    }

    public void career_edit(Career career){
        resumeRepository.career_edit(career);
    }

    public void awards_edit(Awards awards){
        resumeRepository.awards_edit(awards);
    }

    public void cert_edit(Certificate certificate){
        resumeRepository.cert_edit(certificate);
    }


}
