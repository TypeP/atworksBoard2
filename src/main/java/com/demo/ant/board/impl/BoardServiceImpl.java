package com.demo.ant.board.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ant.board.dao.BoardMapperDao;
import com.demo.ant.board.service.BoardService;
import com.demo.ant.board.vo.BoardVO;
import com.demo.ant.board.vo.ReplyVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapperDao	dao;
	
	@Override
	public List<BoardVO> selectBoard() throws Exception {
		return dao.selectBoard();
	}
	
	@Override
	public int insertBoard(BoardVO vo) throws Exception {
		return dao.insertBoard(vo);
	}
	
	@Override
	public BoardVO contentBoard(int bdNum) throws Exception {
		return dao.contentBoard(bdNum);
	}
	
	@Override
	public int modifyBoard(BoardVO vo) throws Exception{
		return dao.modifyBoard(vo);
	}
	
	@Override
	public int deleteBoard(int bdNum) throws Exception{
		return dao.deleteBoard(bdNum);
	}
	@Override
	public List<BoardVO> searchBoard(String field,String keyword) throws Exception {

		Map<String,Object> param =new HashMap<String, Object>(); 
		
		param.put("field", field);
		param.put("keyword", keyword);
		
		 return dao.searchBoard(param);
	}
	
	@Override
	public Map<String, Object> selectAjaxBoard() throws Exception{
		Map<String, Object> param= new HashMap<String, Object>();
		
		List<BoardVO> list= dao.selectBoard();
		param.put("list", list);
		return param;
		
	}
	@Override
	public int countBoard(BoardVO vo) throws Exception{
		return dao.countBoard(vo);
	}
	
	@Override
	public List<ReplyVO> indexReply(int bdNum)throws Exception{
		return dao.indexReply(bdNum);
	}
	
	@Override
	public int insertReply(ReplyVO vo) throws Exception{
		return dao.insertReply(vo);
	}
	
	@Override
	public int deleteReply(int rpNum)throws Exception{
		return dao.deleteReply(rpNum);
	}

	
}
