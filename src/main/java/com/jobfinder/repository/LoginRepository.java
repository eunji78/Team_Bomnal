package com.jobfinder.repository;

import com.jobfinder.domain.LoginVO;
import com.jobfinder.persistence.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginRepository {
    @Autowired
    LoginMapper loginMapper;

    public List<LoginVO> loginList() {
        List<LoginVO> loginVO = loginMapper.loginList();
        return loginVO;
    }

    public String id_check_com(String insert_id) {
        System.out.println("com Mapper in : " + insert_id);
        String com_id = loginMapper.id_check_com(insert_id);
        //if (com_id == null) com_id = "null";
        System.out.println("com Mapper out : " + com_id);
        return com_id;
    }

    public String id_check_per(String insert_id) {
        System.out.println("per Mapper in : " + insert_id);
        String mem_id = loginMapper.id_check_per(insert_id);
        //if (mem_id == null) mem_id = "null";
        System.out.println("per Mapper out : " + mem_id);
        return mem_id;
    }
}
