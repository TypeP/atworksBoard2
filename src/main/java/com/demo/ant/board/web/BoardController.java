package com.demo.ant.board.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.ant.board.service.BoardService;
import com.demo.ant.board.vo.BoardVO;
import com.demo.ant.board.vo.ReplyVO;


@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/indexBoard")
	public ModelAndView indexBoard(HttpServletRequest req) throws Exception {
		List<BoardVO> list= boardService.selectBoard();
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", list);
		mv.setViewName("/board/board");
		return mv;
	};
	
	@GetMapping("/writeBoard")
	public ModelAndView writeBoard(HttpServletRequest req) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/board/writeboard");
		return mv;
	};
	
	@PostMapping("/insertBoard")
	public ModelAndView insertBoard(BoardVO vo,HttpServletRequest req) throws Exception {
		boardService.insertBoard(vo);
		List<BoardVO> list= boardService.selectBoard();
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		
		mv.setViewName("/board/board");
		return mv;
	};
	
	@GetMapping("/content")
	public ModelAndView contentBoard(int bdNum,HttpServletRequest req) throws Exception {

		BoardVO cont= boardService.contentBoard(bdNum);
		List<ReplyVO> list= boardService.indexReply(bdNum);		
		boardService.countBoard(cont);		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.addObject("cont", cont);
		
		mv.setViewName("/board/content");
		return mv;
	};
	
	@PostMapping("/insertReply")
	public ModelAndView insertReply(ReplyVO vo)throws Exception{
		BoardVO cont= boardService.contentBoard(vo.getBdNum());
		boardService.insertReply(vo);
		
		List<ReplyVO> list= boardService.indexReply(vo.getBdNum());	
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.addObject("cont", cont);
		
		mv.setViewName("/board/content");
		return mv;
	}
	
	@GetMapping("/deleteReply")
	public ModelAndView deleteReply(int bdNum,int rpNum) throws Exception{
		BoardVO cont= boardService.contentBoard(bdNum);
		boardService.deleteReply(rpNum);
		
		List<ReplyVO> list= boardService.indexReply(bdNum);	
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.addObject("cont", cont);
		
		mv.setViewName("/board/content");
		return mv;
	}
	
	@GetMapping("/modifyBoard")
	public ModelAndView modifyBoard(int bdNum,HttpServletRequest req) throws Exception {

		BoardVO cont= boardService.contentBoard(bdNum);
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("cont", cont);
		
		mv.setViewName("/board/modify");
		return mv;
	};
	
	@PostMapping("/modify")
	public ModelAndView modify(BoardVO vo,HttpServletRequest req) throws Exception {
		boardService.modifyBoard(vo);
		BoardVO cont= boardService.contentBoard(vo.getBdNum());
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("cont", cont);
		
		mv.setViewName("/board/content");
		return mv;
	};
	
	@GetMapping("/deleteBoard")
	public ModelAndView deleteBoard(int bdNum,HttpServletRequest req)throws Exception{
		boardService.deleteBoard(bdNum);
		
		List<BoardVO> list= boardService.selectBoard();
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		
		mv.setViewName("/board/board");
		return mv;
	};
	
	@PostMapping("/search")
	public ModelAndView search(@RequestParam("field")String field,@RequestParam("keyword") String keyword)throws Exception{
		
	
		List<BoardVO> list= boardService.searchBoard(field,keyword);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", list);
		mv.setViewName("/board/board");
		return mv;
		};
	
}
