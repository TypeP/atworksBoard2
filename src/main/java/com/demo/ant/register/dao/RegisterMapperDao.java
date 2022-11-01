package com.demo.ant.register.dao;

import java.util.List;



import com.demo.ant.sample.vo.SampleVO;
import com.demo.data.annotation.PrimaryMapperRepository;

@PrimaryMapperRepository
public interface RegisterMapperDao {
	
	
	public int insertMember(SampleVO vo) throws Exception;
	
	public int selectMember(SampleVO vo) throws Exception;
	
}
