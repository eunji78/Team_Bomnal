package com.jobfinder.repository;

import com.jobfinder.domain.Criteria;
import com.jobfinder.domain.Recruit;
import com.jobfinder.persistence.SearchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SearchRepository {

    private final SearchMapper searchMapper;

    public List<Recruit> search(Criteria cri){
        return searchMapper.search(cri);
    }

    public int count_search(String keyword){
        return searchMapper.count_search(keyword);
    }
}
