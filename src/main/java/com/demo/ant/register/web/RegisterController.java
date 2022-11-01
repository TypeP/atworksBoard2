package com.demo.ant.register.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.ant.register.service.RegisterService;
import com.demo.ant.sample.vo.SampleVO;

@Controller
@RequestMapping("/register")
public class RegisterController {

	private static final Logger log = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	RegisterService registerService;
	
	@GetMapping("/onLoad")
	public ModelAndView register() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/register/register");
		return mv;
	};
	
	@PostMapping("/insert")
	public ModelAndView insert(SampleVO vo) throws Exception {
		int result=registerService.insertMember(vo); 
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/register/registerEnd");
		return mv;
	};
	
	@GetMapping("/logIn")
	public ModelAndView logIn() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/register/logIn");
		return mv;
	};
	
	@GetMapping("/checkid")
	public ModelAndView checkid(SampleVO vo) throws Exception {
		registerService.selectMember(vo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/register/logIn");
		return mv;
	};
	
	
	
}
