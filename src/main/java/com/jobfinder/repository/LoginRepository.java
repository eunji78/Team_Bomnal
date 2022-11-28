package com.jobfinder.repository;

import com.jobfinder.domain.LoginVO;

import java.util.List;


public interface LoginRepository {
    public List<LoginVO> loginList();

    public String id_check(String insert_id);
}
