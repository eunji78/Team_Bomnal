package com.jobfinder.persistence;

import com.jobfinder.domain.LoginVO;
import com.jobfinder.domain.Login_ComVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapper {

    public List<LoginVO> loginList();

    public int set_signup_per(LoginVO vo);
    public int set_signup_kko(LoginVO vo);
    public int set_signup_com(Login_ComVO cvo);

    public String id_check_com(String insert_id);
    public String id_check_per(String insert_id);

    public LoginVO login_per(LoginVO vo);
    public Login_ComVO login_com(Login_ComVO cvo);

    public LoginVO get_loginVO(LoginVO vo);

    public Login_ComVO Login_ComVO(Login_ComVO cvo);
}
