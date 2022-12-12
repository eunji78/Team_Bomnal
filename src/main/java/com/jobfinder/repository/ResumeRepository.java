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

    //이력서 삭제
    public void delete_resume(int seq){
        resumeMapper.delete_resume(seq);
    }


    /**
     * 이력서 등록
     */
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


    /**
     *  이력서 목록
     */
    public List<Resume> resume_list(String mem_id){
        return resumeMapper.resume_list(mem_id);
    }

    public Resume get_resume(int seq){
        return resumeMapper.get_resume(seq);
    }
    public Awards get_awards(int seq){
        return resumeMapper.get_awards(seq);
    }
    public Certificate get_cert(int seq){
        return resumeMapper.get_cert(seq);
    }
    public Career get_career(int seq){
        return resumeMapper.get_career(seq);
    }
    public Language get_lang(int seq){
        return resumeMapper.get_lang(seq);
    }

    /**
     *  이력서 수정
     */
    public void resume_edit(Resume resume){
        resumeMapper.resume_edit(resume);
    }

    public void lang_edit(Language lang){
        resumeMapper.lang_edit(lang);
    }

    public void cert_edit(Certificate cert){
        resumeMapper.cert_edit(cert);
    }

    public void career_edit(Career career){
        resumeMapper.career_edit(career);
    }

    public void awards_edit(Awards awards){
        resumeMapper.awards_edit(awards);
    }


}
