package com.jobfinder.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Awards {

    private int seq;
    private String aw_name;
    private String aw_agency;
    private String aw_date;
    private int resume_seq;
}
