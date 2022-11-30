package com.jobfinder.service;

import com.jobfinder.repository.MainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final MainRepository mainRepository;

}
