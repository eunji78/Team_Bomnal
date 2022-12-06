package com.jobfinder.domain;

import lombok.Data;

@Data
public class Recruit {
    private int r_seq;
    private String company_name;
    private String r_title;
    // new : 신입 / car : 경력 / irr : 경력무관
    private String r_career;
    private String r_academic_ability;
    // 기타 학력사항
    private String r_academic_ability_option;
    // 졸업 예정자(체크박스)
    private String r_academic_ability_candidate;
    // 근무 형태
    // full : 계약직 / contract : 계약직 / alba : 아르바이트 /
    // intern : 인턴 / free : 프리랜서 / part : 파트타임
    private String r_job_pattern;
    // year : 연봉 / month : 월급 / week : 주급 / hour : 시급
    private String  r_salary_type;
    private String  r_salary;
    // 급여 회사 내규에 따름(체크박스)
    private String  r_salary_bylaws;
    private String r_wide_area;
    // 대표근무지역(체크박스)
    // overseas : 해외지역 근무 / home : 재택근무
    private String r_work_place;
    // 근무지역 상세
    private String r_work_region;
    private String r_detail;
    private String r_position;
    private String r_part;
    private String r_business;
    private String r_license;
    private String r_reg_date;
    private String r_close_date;
    // 채용시작 시간
    private String r_start_hour;
    // 채용마감 시간
    private String r_close_hour;
    private String company_logo;
    // 소정 근로 시간 (주 *시간)
    private String work_per_week;
    // 1 : 면접 후 결정
    private String work_per_week_after;
    private String agent_email;
    private String agent_name;
    private String agent_phone_first;
    private String agent_phone_second;
    private String agent_phone_third;
    // 담당자 정보 공개 여부
    // 1 : 공개 / 0 : 비공개
    private String public_email;
    private String public_name;
    private String public_tel;
}