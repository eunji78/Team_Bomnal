package com.jobfinder.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Certificate {

    private int seq;
    private String ce_name;
    private String ce_agency;
    private String ce_date;
    private int resume_seq;

}
