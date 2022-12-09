package com.jobfinder.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Language {

    private int seq;
    private String la_type;
    private String la_name;
    private String la_score;
    private String la_grade;
    private String la_check;
    private String la_date;
    private int resume_seq;
}
