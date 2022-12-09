package com.jobfinder.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Resume {

    private int seq;
    private String resume_name;
    private String sc_type;
    private String univ_type;
    private String sc_name;
    private String sc_sdate;
    private String sc_edate;
    private String sc_graduate;
    private String sc_major;
    private String sc_score;
    private String max_score;
    private String members_mem_id;
    private String portfolio;
    private String reg_date;

    private Awards awards;
    private Career career;
    private Certificate certificate;
    private Language language;

}
