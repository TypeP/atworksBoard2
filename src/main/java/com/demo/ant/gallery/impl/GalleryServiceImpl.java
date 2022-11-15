package com.demo.ant.gallery.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.javassist.bytecode.stackmap.Tracer;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.demo.ant.ajax.vo.SearchVO;
import com.demo.ant.board.vo.BoardVO;
import com.demo.ant.board.vo.ReplyVO;
import com.demo.ant.gallery.dao.GalleryMapperDao;
import com.demo.ant.gallery.service.GalleryService;
import com.demo.ant.gallery.vo.FileListVO;
import com.demo.ant.gallery.vo.GalleryFileVO;
import com.demo.ant.gallery.vo.GalleryVO;
import com.demo.ant.utils.FileUtil;
import com.demo.ant.utils.PagingUtils;

@Service("galleryService")
public class GalleryServiceImpl implements GalleryService{

	@Autowired
	GalleryMapperDao	dao;
	
	@Autowired
	private PlatformTransactionManager platformTransactionManager;
	
	@Autowired
	private PagingUtils pagingUtils;
	
	@Autowired
	private FileUtil fileUtil;
	
	@Override
	public Map<String,Object> getGalleryList(SearchVO vo) throws Exception {
		
		int totalCnt=dao.getGalleryTotalCnt(vo);
		
		Map<String, Object> param= pagingUtils.paging(vo.getCurPage(), vo.getPagePerCnt(), totalCnt);
		
		param.put("keyword", vo.getKeyword());
		param.put("searchType", vo.getSearchType());
		List<GalleryFileVO> list =dao.getGalleryList(param);
		
		param.put("list", list);
		
		return param;
	}
	
	@Override
	public int writeGalleryBoard(GalleryVO vo, MultipartHttpServletRequest req,@RequestParam("file")List<MultipartFile> files)throws Exception{
		TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
		List<Map<String,Object>>paramList = new ArrayList<Map<String,Object>>();
		try {
			dao.writeGalleryBoard(vo);
			

			
			if(files.get(0).getSize()>0) {
				paramList = fileUtil.imageUpload(req, vo.getBdNum());
				
				dao.insertAttachGallery(paramList);
			}
			platformTransactionManager.commit(status);
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			platformTransactionManager.rollback(status);
			for(Map<String,Object>param:paramList) {
				if(files.get(0).getSize()>0) {
					fileUtil.deleteFile(req,param.get("saved_file_name").toString());
				}
			}
			return 0;
		}
	}
	
	@Override
	public GalleryVO contentGalleryBoard(int bdNum) throws Exception {
		GalleryVO galleryVo = dao.contentGalleryBoard(bdNum);
		List<FileListVO> fileList= dao.getFileGallery(bdNum);
		System.out.println("===============");
		System.out.println("fileList"+fileList.toString());
		System.out.println("===============");
		
		galleryVo.setFileList(fileList);
		return galleryVo;
		
	}
	
	@Override
	public int modifyGalleryBoard(GalleryVO vo, MultipartHttpServletRequest req,@RequestParam("file")List<MultipartFile> files)throws Exception{
		TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
		Map<String,Object> param= new HashMap<String,Object>();
		try {
			dao.modifyGalleryBoard(vo);
			

			
			if(files.get(0).getSize()>0) {
				List<FileListVO> fileList = dao.getFileGallery(vo.getBdNum());
				if(!fileList.isEmpty()) {
					for(FileListVO vo1:fileList) {
						
						param.put("saved_file_name",vo1.getSavedFileName());
						fileUtil.deleteFile(req, vo1.getSavedFileName());
					}
					dao.deleteGalleryAttach(vo.getBdNum());
				}
				List<Map<String,Object>>paramList=fileUtil.imageUpload(req,vo.getBdNum());
				
				
				dao.insertAttachGallery(paramList);
			}
			platformTransactionManager.commit(status);
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			platformTransactionManager.rollback(status);
			return 0;
		}
	}
	
	@Override
	public int deleteGallery(int bdNum, HttpServletRequest req) {
		TransactionStatus status= platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
		Map<String,Object> param= new HashMap<String, Object>();
		try {
			List<FileListVO> fileList= dao.getFileGallery(bdNum);
			for(FileListVO vo:fileList) {
				param.put("saved_file_name", vo.getSavedFileName());
				fileUtil.deleteFile(req, vo.getSavedFileName());
			}
			dao.deleteGallery(bdNum);
			dao.deleteGalleryAttach(bdNum);
			platformTransactionManager.commit(status);
			return 1;
			
		}catch(Exception e) {
			platformTransactionManager.rollback(status);
			
			return 0;
		}
	}
	
	
}
