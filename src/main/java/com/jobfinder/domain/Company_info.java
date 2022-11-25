package com.jobfinder.domain;

import lombok.Data;

@Data
public class Company_info {
    private int company_id;
    private String foundation_dt;
    private String company_owner;
    private int staff_number;
    private int total_sales;
    private String website;
    private String company_history;
    private String company_content;
    private String company_logo;
}
