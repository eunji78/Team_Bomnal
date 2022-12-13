package com.jobfinder.service;

import com.jobfinder.domain.Recruit;
import com.jobfinder.repository.MainRepository;
import com.jobfinder.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository searchRepository;

    public List<Recruit> search(List<String> keywords){

        String keyword = keywords.get(keywords.size()-1);
        keywords.remove(keywords.size()-1);

        List<Recruit> result = searchRepository.search(keywords, keyword);

        return result;
    }

}
