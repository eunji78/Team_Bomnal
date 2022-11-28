package com.jobfinder.persistence;

import com.jobfinder.domain.LoginVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface loginMapper {
    public List<LoginVO> loginList();
    public String id_check(String insert_id);
}
