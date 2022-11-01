package com.demo.ant.register.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.demo.ant.sample.vo.SampleVO;

public interface RegisterService {

	public int insertMember(SampleVO vo) throws Exception;
	public int selectMember(SampleVO vo) throws Exception;
}
