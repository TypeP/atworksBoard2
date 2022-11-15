package com.demo.ant.gallery.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.demo.ant.ajax.vo.SearchVO;
import com.demo.ant.board.vo.BoardVO;
import com.demo.ant.board.vo.ReplyVO;
import com.demo.ant.gallery.vo.GalleryVO;

public interface GalleryService {

	public Map<String, Object> getGalleryList(SearchVO vo) throws Exception;
	public int writeGalleryBoard(GalleryVO vo, MultipartHttpServletRequest req, List<MultipartFile> file)throws Exception;
	public GalleryVO contentGalleryBoard(int bdNum)throws Exception;
	public int modifyGalleryBoard(GalleryVO vo, MultipartHttpServletRequest req, List<MultipartFile> file)throws Exception;
	public int deleteGallery(int bdNum,HttpServletRequest req)throws Exception;
}
