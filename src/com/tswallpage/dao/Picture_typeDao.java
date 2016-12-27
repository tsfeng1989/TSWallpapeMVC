package com.tswallpage.dao;

import java.util.List;

import com.tswallpage.entity.Picture_type;

public interface Picture_typeDao {
	//添加类型
	public boolean addType(Picture_type pt);
	
	//删除类型
	public boolean delType(Picture_type pt);
	
	//根据ID查找类型
	public Picture_type findPtById(int id);
	
	//修改类型
	public boolean updateType(Picture_type pt);
	
	//查询全部类型
	public List findAllPt();
}
