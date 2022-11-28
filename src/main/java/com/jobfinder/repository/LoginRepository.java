package com.jobfinder.repository;

import com.jobfinder.domain.LoginVO;

import java.util.List;


public interface LoginRepository {
    public List<LoginVO> loginList();

    public String id_check_com(String insert_id);

    public String id_check_per(String insert_id);
}
