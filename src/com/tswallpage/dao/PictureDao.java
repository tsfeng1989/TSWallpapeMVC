package com.tswallpage.dao;

import java.util.List;

import com.tswallpage.entity.Picture;

public interface PictureDao {
	//添加图片
	public boolean uploadPicture(Picture p);
	
	//删除图片
	public boolean delPicture(Picture p);
	
	//根据ID查询图片
	public Picture findPictureById(int id);
	
	//修改图片信息
	public boolean updatePicture(Picture p);
	
	//查询本用户的所有图片
	public List findAllPicture(int id);
}
