package com.demo.ant.board.dao;

import java.util.List;
import java.util.Map;

import com.demo.ant.board.vo.BoardVO;
import com.demo.ant.board.vo.ReplyVO;
import com.demo.data.annotation.PrimaryMapperRepository;

@PrimaryMapperRepository
public interface BoardMapperDao {
	
	public List<BoardVO> selectBoard() throws Exception;
	public int insertBoard(BoardVO vo) throws Exception;
	public BoardVO contentBoard(int bdNum) throws Exception; 
	public int modifyBoard(BoardVO vo) throws Exception;
	public int deleteBoard(int bdNum) throws Exception;
	public List<BoardVO> searchBoard(Map<String, Object> param) throws Exception;
	public int countBoard (BoardVO vo) throws Exception;
	public List<ReplyVO> indexReply (int bdNum) throws Exception;
	public int insertReply (ReplyVO vo)throws Exception;
	public int deleteReply(int rpNum) throws Exception;
	
	
}