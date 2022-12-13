package com.jobfinder.service;

import com.jobfinder.domain.Criteria;
import com.jobfinder.domain.Recruit;
import com.jobfinder.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository searchRepository;

    public List<Recruit> search(Criteria cri){

        List<Recruit> result = searchRepository.search(cri);

        return result;
    }
    public int count_search(String keyword){
        return searchRepository.count_search(keyword);
    }

}
