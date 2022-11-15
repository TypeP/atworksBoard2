package com.demo.ant.gallery.dao;

import java.util.List;
import java.util.Map;

import com.demo.ant.ajax.vo.SearchVO;
import com.demo.ant.board.vo.BoardVO;
import com.demo.ant.gallery.vo.FileListVO;
import com.demo.ant.gallery.vo.GalleryFileVO;
import com.demo.ant.gallery.vo.GalleryVO;
import com.demo.data.annotation.PrimaryMapperRepository;

@PrimaryMapperRepository
public interface GalleryMapperDao {
	
	public List<GalleryFileVO> getGalleryList(Map<String,Object> param) throws Exception;
	public int getGalleryTotalCnt(SearchVO vo) throws Exception;
	public int writeGalleryBoard(GalleryVO vo)throws Exception;
	public int insertAttachGallery(List<Map<String, Object>> paramList)throws Exception;
	public GalleryVO contentGalleryBoard (int bdNum)throws Exception;
	public List<FileListVO> getFileGallery (int bdNum) throws Exception;
	public int modifyGalleryBoard(GalleryVO vo)throws Exception;
	public int deleteGalleryAttach(int bdNum)throws Exception;
	public int deleteGallery(int bdNum)throws Exception;
	
}
