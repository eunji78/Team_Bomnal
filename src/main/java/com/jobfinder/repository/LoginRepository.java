package com.jobfinder.repository;

import com.jobfinder.domain.LoginVO;
import com.jobfinder.domain.Login_ComVO;
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

    public int set_signup_com(Login_ComVO cvo){
        int res = loginMapper.set_signup_com(cvo);
        return res;
    }

    public int set_signup_per(LoginVO vo){
        int res = loginMapper.set_signup_per(vo);
        return res;
    }
    public int set_signup_kko(LoginVO vo){
        int res = loginMapper.set_signup_kko(vo);
        return res;
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
