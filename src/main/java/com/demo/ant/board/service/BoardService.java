package com.demo.ant.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.demo.ant.board.vo.BoardVO;

public interface BoardService {

	public List<BoardVO>  selectBoard() throws Exception;
	public int insertBoard(BoardVO vo) throws Exception;
	public BoardVO contentBoard(int bdNum)throws Exception;
	public int modifyBoard (BoardVO vo) throws Exception;
	public int deleteBoard(int bdNum)throws Exception;
	public List<BoardVO> searchBoard(String field,String keyword) throws Exception;
	

}
