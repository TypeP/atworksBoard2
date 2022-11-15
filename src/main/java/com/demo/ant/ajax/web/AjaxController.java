package com.demo.ant.ajax.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.ant.ajax.service.AjaxService;
import com.demo.ant.ajax.vo.SearchVO;
import com.demo.ant.board.service.BoardService;
import com.demo.ant.board.vo.BoardVO;
import com.demo.ant.board.vo.ReplyVO;


@Controller
@RequestMapping("/ajax")
public class AjaxController {

	private static final Logger log = LoggerFactory.getLogger(AjaxController.class);
	
	@Autowired
	AjaxService ajaxService;
	
	@GetMapping("/indexAjaxBoard")
	public ModelAndView indexAjaxBoard(Model model) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/ajax/ajaxboard");
		return mv;
	};
	
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	@ResponseBody	//비동기통신 처리 어노테이션
	public Map<String, Object> getNoticeList(SearchVO vo) throws Exception {
		return ajaxService.selectAjaxBoard(vo);
		
		
	}
	
	@GetMapping("/writeAjaxBoard")
	public ModelAndView writeAjaxBoard(Model model) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/ajax/writeajaxboard");
		return mv;
	};
	
	
	@PostMapping("/insertReplyAjax")
	public ModelAndView insertReplyAjax(ReplyVO vo2)throws Exception{
		BoardVO vo= ajaxService.contentAjaxBoard(vo2.getBdNum());
		ajaxService.insertReplyAjax(vo2);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("cont", vo);
		mv.setViewName("/ajax/contentajaxboard");
		return mv;
	}
	
	@RequestMapping(value="/getRepList", method =RequestMethod.GET)
	@ResponseBody
	public Map<String,Object>getRepList(ReplyVO vo) throws Exception{
		return ajaxService.getRepList(vo.getBdNum());
		
		
	}
	
	@PostMapping("/writeAjaxBoard")
	public ModelAndView writeAjaxBoard(BoardVO vo,Model model) throws Exception {
		ajaxService.insertAjaxBoard(vo);

		ModelAndView mv = new ModelAndView();	

		mv.setViewName("/ajax/ajaxboard");
		return mv;
	};
	
	@GetMapping("/deleteReply")
	public ModelAndView deleteReply(int bdNum,int rpNum)throws Exception{
		BoardVO vo= ajaxService.contentAjaxBoard(bdNum);
		ajaxService.deleteReply(rpNum);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("cont", vo);
		mv.setViewName("/ajax/contentajaxboard");
		return mv;
	}
	
	@GetMapping("/contentAjaxBoard")
	public ModelAndView contentAjaxBoard(int bdNum) throws Exception{
		BoardVO vo= ajaxService.contentAjaxBoard(bdNum);
		ajaxService.countAjax(vo);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("cont", vo);
		mv.setViewName("/ajax/contentajaxboard");
		return mv;
		
	}
	
	@GetMapping("/modifyAjaxBoard")
	public ModelAndView modifyAjaxBoard(int bdNum) throws Exception{
		BoardVO vo= ajaxService.contentAjaxBoard(bdNum);

		ModelAndView mv = new ModelAndView();
		
		mv.addObject("cont", vo);
		mv.setViewName("/ajax/modifyAjaxBoard");
		return mv;
	}
	@PostMapping("/modifyBoard")
	public ModelAndView modifyBoard(BoardVO vo) throws Exception{
		ajaxService.modifyAjaxBoard(vo);
		
		BoardVO dto= ajaxService.contentAjaxBoard(vo.getBdNum());

		ModelAndView mv = new ModelAndView();
		
		mv.addObject("cont", dto);
		mv.setViewName("/ajax/contentajaxboard");
		return mv;
	}
	
	@GetMapping("/deleteAjaxBoard")
	public ModelAndView deleteAjaxBoard(int bdNum,Model model) throws Exception{
		ajaxService.deleteAjaxBoard(bdNum);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/ajax/ajaxboard");
		return mv;
		
	}

	
	
}
