package com.jobfinder.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Career {

    private int seq;
    private String ca_name;
    private String ca_sdate;
    private String ca_edate;
    private String ca_type;
    private String ca_dept;
    private String ca_position;
    private String ca_salary;
    private String ca_duty;
    private int resume_seq;

}
