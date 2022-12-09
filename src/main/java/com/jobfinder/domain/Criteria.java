package com.jobfinder.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Criteria {
    private int page; // 현재 페이지 번호
    private int perPageNum; // 한 페이지에 보여줄 게시글의 수
    private String industry_class;
    private String keyword;
    private int super_job_seq;
    
    public Criteria() {
        this.page = 1; // 현재 페이지 = 1
        this.perPageNum = 10; // 한 페이지 당 게시글을 10개씩
    }

    // 현재 페이지의 게시글의 시작번호
    // 1페이지는 1, 2페이지는 11, 3페이지는 21 ...
    public int getPageStart(){
        return (page-1)*perPageNum;
    }
}
