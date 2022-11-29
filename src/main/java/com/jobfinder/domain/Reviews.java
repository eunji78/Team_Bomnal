package com.jobfinder.domain;

import lombok.Data;

@Data
public class Reviews {
    private String review_seq;
    private String company_id;
    private String review_content;
    private String review_likes;
    private String reg_date;
    private String mem_id;
    private double welfare;
    private double work_life_balance;
    private double inner_culture;
    private double p_opportunity;
    private double management;
    private String pros;
    private String cons;
    private int my_salary;
    private char retire_yn;
}
