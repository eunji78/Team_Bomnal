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
    // new : 신입 / car : 경력 / irr : 경력무관
    private String r_career;
    // 학력
    private String r_academic_ability;
    // 기타 학력사항
    private String r_academic_ability_option;
    // 졸업 예정자(체크박스)
    private String r_academic_ability_candidate;
    // 근무 형태
    // full : 계약직 / contract : 계약직 / alba : 아르바이트 /
    // intern : 인턴 / free : 프리랜서 / part : 파트타임
    private String r_job_pattern;
    // 급여
    // year : 연봉 / month : 월급 / week : 주급 / hour : 시급
    private String  r_salary_type;
    private String  r_salary;
    // 급여 회사 내규에 따름(체크박스)
    private String  r_salary_bylaws;
    // 근무지역
    private String r_wide_area;
    // 대표근무지역(체크박스)
    // overseas : 해외지역 근무 / home : 재택근무
    private String r_work_place;
    // 근무지역 상세
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

    // 채용시작 시간
    private String r_start_hour;
    // 채용마감 시간
    private String r_close_hour;
    // 회사 로고
    private String company_logo;
    // 소정 근로 시간 (주 *시간)
    private String work_per_week;
    // 1 : 면접 후 결정
    private String work_per_week_after;
    // 담당자 이메일
    private String agent_email;
    // 담당자 이름
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