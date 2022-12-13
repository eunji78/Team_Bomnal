package com.jobfinder.persistence;

import com.jobfinder.domain.Criteria;
import com.jobfinder.domain.Recruit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {

    public List<Recruit> search(Criteria cri);

    public int count_search(String keyword);
}
