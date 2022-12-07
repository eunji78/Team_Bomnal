package com.jobfinder.domain;

import lombok.Data;

@Data
public class CompanyList {
    private String company_id;
    private String company_logo;
    private String company_name;
    private String company_industry;
    private String company_type;
    private int reviewcount;
    private double totalstar;
    private int avgsalary;
}
