package com.tswallpage.service;

import java.util.List;

import com.tswallpage.entity.Picture_type;

/**
 * 
 * @author Forever
 *
 */
public interface Picture_typeService {
	//添加图片类型
	public boolean addPicture_type(Picture_type pt);
	
	//删除图片类型
	public boolean delPicture_type(Picture_type pt);
	
	//根据ID查找图片类型
	public Picture_type findPtById(int id);
	
	//修改图片
	public boolean updatePt(Picture_type pt);
	
	//查询全部类型
	public List findAllPt();
}
