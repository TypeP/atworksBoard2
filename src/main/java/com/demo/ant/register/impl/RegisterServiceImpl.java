package com.demo.ant.register.impl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ant.register.dao.RegisterMapperDao;
import com.demo.ant.register.service.RegisterService;
import com.demo.ant.sample.vo.SampleVO;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	RegisterMapperDao	dao;
	
	@Override
	public int insertMember(SampleVO vo) throws Exception {
		return dao.insertMember(vo);
	}
	
	@Override
	public int selectMember(SampleVO vo) throws Exception {
		return dao.selectMember(vo);
	}

	
}
