package com.jobfinder.persistence;

import com.jobfinder.domain.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResumeMapper {

    public int resume_num(String mem_id);

    // 이력서 등록
    public void resume_add(Resume resume);
    public void lang_add(Language language);
    public void awards_add(Awards awards);
    public void cert_add(Certificate certificate);
    public void career_add(Career career);

    public int get_seq();

    // 이력서 목록
    public List<Resume> resume_list(String mem_id);
    public Resume get_resume(int seq);
    public Awards get_awards(int seq);
    public Certificate get_cert(int seq);
    public Career get_career(int seq);
    public Language get_lang(int seq);

    //이력서 수정
    public void resume_edit(Resume resume);
    public void lang_edit(Language language);
    public void awards_edit(Awards awards);
    public void cert_edit(Certificate certificate);
    public void career_edit(Career career);
}
