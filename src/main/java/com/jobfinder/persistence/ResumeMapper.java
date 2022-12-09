package com.jobfinder.persistence;

import com.jobfinder.domain.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResumeMapper {

    public int resume_num(String mem_id);

    public void resume_add(Resume resume);
    public void lang_add(Language seq);
    public void awards_add(Awards seq);
    public void cert_add(Certificate seq);
    public void career_add(Career seq);

}
