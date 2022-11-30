package com.jobfinder.service;

import com.jobfinder.service.repository.MainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final MainRepository mainRepository;

}
