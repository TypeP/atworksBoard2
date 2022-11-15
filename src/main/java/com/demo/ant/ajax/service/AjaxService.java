package com.demo.ant.ajax.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.demo.ant.ajax.vo.SearchVO;
import com.demo.ant.board.vo.BoardVO;
import com.demo.ant.board.vo.ReplyVO;

public interface AjaxService {

	public Map<String, Object> selectAjaxBoard(SearchVO vo) throws Exception;
	public Map<String, Object> getRepList(int bdNum) throws Exception;
	public int insertAjaxBoard(BoardVO vo) throws Exception;
	public BoardVO contentAjaxBoard(int bdNum) throws Exception;
	public int modifyAjaxBoard(BoardVO vo) throws Exception;
	public int deleteAjaxBoard(int bdNum) throws Exception;
	public int countAjax(BoardVO vo) throws Exception;
	public int insertReplyAjax(ReplyVO vo)throws Exception;
	public int deleteReply(int rpNum)throws Exception;
	
}
