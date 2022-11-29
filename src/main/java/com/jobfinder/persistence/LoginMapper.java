package com.jobfinder.persistence;

import com.jobfinder.domain.LoginVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapper {

    public List<LoginVO> loginList();

    public String id_check_com(String insert_id);
    public String id_check_per(String insert_id);

}
