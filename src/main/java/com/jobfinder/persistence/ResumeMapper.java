package com.jobfinder.persistence;

import com.jobfinder.domain.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResumeMapper {

    public int resume_num(String mem_id);

    public void resume_add(Resume resume);
    public void lang_add(Language language);
    public void awards_add(Awards awards);
    public void cert_add(Certificate certificate);
    public void career_add(Career career);

    public int get_seq();

}
