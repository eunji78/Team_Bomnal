package com.jobfinder.domain;

import lombok.Data;

@Data
public class Recruit {
    // 공고 순번
    private int r_seq;
    // 기업 아이디
    private String company_id;
    // 기업 이름
    private String company_name;
    // 공고 제목
    private String r_title;
    // 경력
    private String r_career;
    // 학력
    private String r_academic_ability;
    // 근무형태
    private String r_job_pattern;
    // 급여
    private String  r_salary;
    // 근무지역
    private String r_wide_area;
    // 세부지역
    private String r_work_region;
    // 상세내용
    private String r_detail;
    // 직급/ 직책
    private String r_position;
    // 모집부문
    private String r_part;
    // 담당업무
    private String r_business;
    // 자격요건
    private String r_license;
    // 공고 등록날짜
    private String r_reg_date;
    // 마감일
    private String r_close_date;
    // 회사 로고
    private String company_logo;
    // 담당자 이메일
    private String agent_email;
    // 담당자 이름
    private String agent_name;
    // 담당자 연락처
    private String agent_phone;
}