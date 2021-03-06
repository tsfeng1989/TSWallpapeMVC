package com.tswallpage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tswallpage.dao.PictureDao;
import com.tswallpage.entity.Picture;
import com.tswallpage.service.PictureService;
import com.tswallpage.util.PageBean;

/**
 * 
 * @author Forever
 *
 */
@Service("pictureService")
public class PictureServiceImpl implements PictureService{
	
	@Resource(name="pictureDao")
	private PictureDao pictureDao;
	
	//添加图片
	@Override
	public boolean uploadPicture(Picture p) {
		return pictureDao.uploadPicture(p);
	}
	
	//删除图片
	@Override
	public boolean delPicture(Picture p) {
		return pictureDao.delPicture(p);
	}
	
	//根据ID查找图片
	@Override
	public Picture findPictureById(int id) {
		return pictureDao.findPictureById(id);
	}
	
	//修改图片
	@Override
	public boolean updatePicture(Picture p) {
		return pictureDao.updatePicture(p);
	}
	
	//查询本用户的所有图片
	@Override
	public List findAllPicture(int id) {
		return pictureDao.findAllPicture(id);
	}
	
	//根据uuid生成名查询图片
	@Override
	public Picture findPictureByUUIDNane(String uname) {
		return pictureDao.findPictureByUUIDNane(uname);
	}
	
	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}
	
	//查询全部图片
	@Override
	public List queryAllPicture() {
		return pictureDao.queryAllPicture();
	}
	
	//分页查询
	@Override
	public PageBean pagingQuery(int number) {
		return pictureDao.pagingQuery(number);
	}
}
