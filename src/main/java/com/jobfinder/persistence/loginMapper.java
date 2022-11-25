package com.jobfinder.persistence;

import com.jobfinder.domain.loginVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface loginMapper {

	public List<loginVO> loginList();
	
}
