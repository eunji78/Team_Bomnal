package com.jobfinder.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PageMaker {
    private Criteria cri;
    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;
    private int displayPageNum=5;

    public void setTotalCount(int totalCount) {
        this.totalCount=totalCount;
        calcPaging();
    }

    private void calcPaging() {
        // 1. 화면에 보여질 마지막 페이지 번호
        endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);

        // 2. 화면에 보여질 시작 페이지 번호
        startPage = endPage-displayPageNum+1;
        if (startPage<=0) startPage=1;

        // 3. 전체 마지막 페이지 번호 계산
        int tempEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));

        // 4. 화면에 보여질 마지막 페이지 유효성 체크
        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }
        // 5. 이전 페이지버튼(링크) 존재 여부
        prev = (startPage==1)?false:true;

        // 6. 다음 페이지버튼(링크) 존재 여부
        next = (endPage<tempEndPage)?true:false;
    }

}
