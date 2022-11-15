package com.demo.ant.ajax.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ant.ajax.dao.AjaxMapperDao;
import com.demo.ant.ajax.service.AjaxService;
import com.demo.ant.ajax.vo.SearchVO;
import com.demo.ant.board.dao.BoardMapperDao;
import com.demo.ant.board.service.BoardService;
import com.demo.ant.board.vo.BoardVO;
import com.demo.ant.board.vo.ReplyVO;
import com.demo.ant.utils.PagingUtils;

@Service("ajaxService")
public class AjaxServiceImpl implements AjaxService{

	@Autowired
	AjaxMapperDao ajaxDao;
	
	@Autowired
	private PagingUtils pagingUtils;
	
	
	
	@Override
	public Map<String, Object> selectAjaxBoard(SearchVO vo) throws Exception{
		int totalCnt=ajaxDao.getAjaxTotalCnt(vo);
		
		Map<String, Object> param= pagingUtils.paging(vo.getCurPage(), vo.getPagePerCnt(), totalCnt);
		
		param.put("keyword", vo.getKeyword());
		param.put("searchType", vo.getSearchType());
		List<BoardVO> list= ajaxDao.selectAjaxBoard(param);
		param.put("list", list);
		return param;
		
	}
	@Override
	public Map<String, Object> getRepList(int bdNum) throws Exception{
		
		Map<String, Object> param= new HashMap<String, Object>();
		List<ReplyVO> list= ajaxDao.getRepList(bdNum);
		param.put("list", list);
		return param;
		
	}
	
	
	@Override
	public int insertAjaxBoard(BoardVO vo)throws Exception{
		return ajaxDao.insertAjaxBoard(vo);
	}
	
	@Override
	public BoardVO contentAjaxBoard(int bdNum) throws Exception{
		return ajaxDao.contentAjaxBoard(bdNum);
	}
	
	@Override
	public int modifyAjaxBoard(BoardVO vo) throws Exception{
		return ajaxDao.modifyAjaxBoard(vo);
	}
	
	@Override
	public int deleteAjaxBoard(int bdNum)throws Exception{
		return ajaxDao.deleteAjaxBoard(bdNum);
	}
	
	@Override
	public int countAjax(BoardVO vo)throws Exception{
		return ajaxDao.countAjax(vo);
	}
	
	@Override
	public int insertReplyAjax(ReplyVO vo)throws Exception{
		return ajaxDao.insertReplyAjax(vo);
	}
	
	@Override
	public int deleteReply(int rpNum)throws Exception{
		return ajaxDao.deleteReply(rpNum);
	}

	
	
}
