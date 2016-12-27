package com.tswallpage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tswallpage.dao.Picture_typeDao;
import com.tswallpage.entity.Picture_type;
import com.tswallpage.service.Picture_typeService;
@Service("picture_typeService")
public class Picture_typeServiceImpl implements Picture_typeService {
	@Resource(name="picture_typeDao")
	private Picture_typeDao picture_typedao;
	
	//添加图片类型
	@Override
	public boolean addPicture_type(Picture_type pt) {
		return picture_typedao.addType(pt);
	}
	
	//删除图片类型
	@Override
	public boolean delPicture_type(Picture_type pt) {
		return picture_typedao.delType(pt);
	}
	
	//根据ID查找图片类型
	@Override
	public Picture_type findPtById(int id) {
		return picture_typedao.findPtById(id);
	}
	
	//修改图片
	@Override
	public boolean updatePt(Picture_type pt) {
		return picture_typedao.updateType(pt);
	}
	
	//查询全部类型
	@Override
	public List findAllPt() {
		return picture_typedao.findAllPt();
	}

	public void setPicture_typedao(Picture_typeDao picture_typedao) {
		this.picture_typedao = picture_typedao;
	}
}
