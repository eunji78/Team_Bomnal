package com.jobfinder.domain;

import lombok.Data;

@Data
public class LoginVO {
    private String mem_id;
    private String mem_pw;
    private String mem_name;
    private String addr;
    private String mem_phone;
    private String mem_bdate;
    private String mem_email;
    private String mem_info;
    private int mem_resume;
    private char mem_type;
    private char m_agreement1;
    private char m_agreement2;
    private char m_agreement3;
    private char m_agreement4;
    private char m_agreement5;
}
