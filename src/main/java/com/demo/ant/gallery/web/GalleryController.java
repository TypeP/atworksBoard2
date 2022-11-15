package com.demo.ant.gallery.web;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.demo.ant.ajax.service.AjaxService;
import com.demo.ant.ajax.vo.SearchVO;
import com.demo.ant.board.service.BoardService;
import com.demo.ant.board.vo.BoardVO;
import com.demo.ant.gallery.service.GalleryService;
import com.demo.ant.gallery.vo.FileListVO;
import com.demo.ant.gallery.vo.GalleryVO;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

	private static final Logger log = LoggerFactory.getLogger(GalleryController.class);

	@Autowired
	GalleryService galleryService;

	@GetMapping("/indexGalleryBoard")
	public ModelAndView indexGalleryBoard(Model model) throws Exception {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("/gallery/galleryboard");
		return mv;
	};

	@GetMapping("/getGalleryList")
	@ResponseBody
	public Map<String, Object> getGalleryList(SearchVO vo) throws Exception {
		return galleryService.getGalleryList(vo);
	}

	@GetMapping("/writeGallery")
	public ModelAndView writeGallery() throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/gallery/writegallery");
		return mv;
	};

	@PostMapping("/writeGalleryBoard")
	// @RequestMapping(value="/writeGalleryBoard",method = RequestMethod.POST)
	public ModelAndView writeGalleryBoard(GalleryVO vo, MultipartHttpServletRequest req,
			@RequestParam("file") List<MultipartFile> file) throws Exception {
		galleryService.writeGalleryBoard(vo, req, file);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/gallery/galleryboard");
		return mv;
	}

	@GetMapping("/contentGalleryBoard")
	public ModelAndView contentGalleryBoard(int bdNum) throws Exception {
		GalleryVO galleryVO = galleryService.contentGalleryBoard(bdNum);

		ModelAndView mv = new ModelAndView();
		mv.addObject("cont", galleryVO);
		mv.setViewName("/gallery/contentgalleryboard");
		return mv;
	}

	@GetMapping("/modifyGallery")
	public ModelAndView modifyGallery(int bdNum) throws Exception {
		GalleryVO galleryVO = galleryService.contentGalleryBoard(bdNum);

		ModelAndView mv = new ModelAndView();
		mv.addObject("cont", galleryVO);
		mv.setViewName("/gallery/modifyGalleryBd");
		return mv;
	}

	@PostMapping("/modifyGalleryBoard")
	// @RequestMapping(value="/writeGalleryBoard",method = RequestMethod.POST)
	public ModelAndView modifyGalleryBoard(GalleryVO vo, MultipartHttpServletRequest req,
			@RequestParam("file") List<MultipartFile> file) throws Exception {
		galleryService.modifyGalleryBoard(vo, req, file);

		GalleryVO galleryVO = galleryService.contentGalleryBoard(vo.getBdNum());

		ModelAndView mv = new ModelAndView();
		mv.addObject("cont", galleryVO);

		mv.setViewName("/gallery/contentgalleryboard");
		return mv;
	}

	@GetMapping("/deleteGallery")
	public ModelAndView deleteGallery(int bdNum, HttpServletRequest req) throws Exception {
		galleryService.deleteGallery(bdNum, req);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/gallery/galleryboard");
		return mv;
	}

}
