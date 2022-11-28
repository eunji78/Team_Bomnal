package com.jobfinder.repository;

import com.jobfinder.domain.LoginVO;
import com.jobfinder.persistence.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public List<LoginVO> loginList() {
        List<LoginVO> loginVO = loginMapper.loginList();
        return loginVO;
    }

    @Override
    public String id_check(String insert_id) {
        System.out.println("Mapper : " + insert_id);
        String mem_id = loginMapper.id_check(insert_id);
        return mem_id;
    }
}
