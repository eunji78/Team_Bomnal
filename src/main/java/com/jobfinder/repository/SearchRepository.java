package com.jobfinder.repository;

import com.jobfinder.domain.Recruit;
import com.jobfinder.persistence.SearchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SearchRepository {

    private final SearchMapper searchMapper;

    public List<Recruit> search(List<String> tags, String keyword){
        return searchMapper.search(tags, keyword);
    }
}
