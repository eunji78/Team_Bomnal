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
    // 모집부문
    private String r_part;
    // 공고 제목
    private String r_title;
    // 담당업무
    private String r_business;
    // 자격요건
    private String r_license;
    // 상세내용
    private String r_detail;
    // 공고 등록날짜
    private String r_open_date;
    // 채용시작 시간
    private String r_open_hour;
    // 마감일
    private String r_close_date;
    // 채용마감 시간
    private String r_close_hour;
    // new : 신입 / car : 경력 / irr : 경력무관
    private String r_career;
    // 학력
    private String r_academic_ability;
    // 기타 학력사항
    private String r_academic_option;
    // 졸업 예정자(체크박스)
    private String r_academic_candidate;
    // 급여
    // year : 연봉 / month : 월급 / week : 주급 / hour : 시급
    private String  r_salary_type;
    private String  r_salary;
    // 급여 회사 내규에 따름(체크박스)
    private String  r_salary_bylaws;
    // 소정 근로 시간 (주 *시간)
    private String r_work_time;
    // 1 : 면접 후 결정
    private String r_work_time_after;
    // 근무 형태
    // full : 정규직 / contract : 계약직 / alba : 아르바이트 /
    // intern : 인턴 / free : 프리랜서 / part : 파트타임
    private String r_job_pattern;
    // 대표근무지역(체크박스)
    // overseas : 해외지역 근무 / home : 재택근무
    private String r_work_area;
    // 근무지역 상세
    private String r_work_addr;
    // 담당자 이메일
    private String r_manager_email;
    // 담당자 이름
    private String r_manager_name;
    private String r_manager_phone_first;
    private String r_manager_phone_second;
    private String r_manager_phone_third;
    // 담당자 정보 공개 여부
    // 1 : 공개 / 0 : 비공개
    private String r_manager_email_public;
    private String r_manager_name_public;
    private String r_manager_phone_public;
    // 회사 로고
    private String company_logo;
}