package com.demo.ant.ajax.dao;

import java.util.List;
import java.util.Map;

import com.demo.ant.ajax.vo.SearchVO;
import com.demo.ant.board.vo.BoardVO;
import com.demo.ant.board.vo.ReplyVO;
import com.demo.data.annotation.PrimaryMapperRepository;

@PrimaryMapperRepository
public interface AjaxMapperDao {
	
	public int getAjaxTotalCnt(SearchVO vo) throws Exception;
	public List<BoardVO> selectAjaxBoard(Map<String,Object> param) throws Exception;
	public List<ReplyVO> getRepList(int bdNum)throws Exception;
	public int insertAjaxBoard(BoardVO vo)throws Exception;
	public BoardVO contentAjaxBoard(int bdNum) throws Exception;
	public int modifyAjaxBoard(BoardVO vo)throws Exception;
	public int deleteAjaxBoard(int bdNum) throws Exception;
	public int countAjax(BoardVO vo)throws Exception;
	public int insertReplyAjax(ReplyVO vo)throws Exception;
	public int deleteReply(int rpNum)throws Exception;
	
}
