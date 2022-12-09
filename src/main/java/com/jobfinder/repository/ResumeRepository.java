package com.jobfinder.repository;

import com.jobfinder.domain.*;
import com.jobfinder.persistence.ResumeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ResumeRepository {

    private final ResumeMapper resumeMapper;

    public void resume_add(Resume resume){
        resumeMapper.resume_add(resume);
    }

    public int resume_num(String mem_id){
        return resumeMapper.resume_num(mem_id);
    }

    public void lang_add(Language lang){
            resumeMapper.lang_add(lang);
    }

    public void cert_add(Certificate cert){
         resumeMapper.cert_add(cert);
    }

    public void career_add(Career career){
         resumeMapper.career_add(career);
    }

    public void awards_add(Awards awards){
         resumeMapper.awards_add(awards);
    }

    public int get_seq(){
        return resumeMapper.get_seq();
    }


}
