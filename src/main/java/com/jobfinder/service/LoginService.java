package com.jobfinder.service;

import com.jobfinder.domain.LoginVO;

import java.util.HashMap;
import java.util.List;

public interface LoginService {

    public List<LoginVO> loginList();

    public String id_check_com(String insert_id);

    public String id_check_per(String insert_id);

    public String getAccessToken (String authorize_code);

    public HashMap<String, Object> getUserInfo (String access_Token);
}
