package com.tswallpage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tswallpage.dao.Picture_userDao;
import com.tswallpage.entity.Picture_user;
import com.tswallpage.service.Picture_userService;
/**
 * 
 * @author Forever
 *
 */
@Service("picture_userService")
public class Picture_userServiceImpl implements Picture_userService {
	@Resource(name="picture_userDao")
	private Picture_userDao picture_userDao;
	
	//Ìí¼Ó
	@Override
	public boolean addPicture_userDao(Picture_user pu) {
		return picture_userDao.addPicture_userDao(pu);
	}
	
	//É¾³ý
	@Override
	public boolean delPicture_userDao(Picture_user pu) {
		return picture_userDao.delPicture_userDao(pu);
	}
	
	//ÐÞ¸Ä
	@Override
	public boolean updatePicture_userDao(Picture_user pu) {
		return picture_userDao.updatePicture_userDao(pu);
	}

	public void setPicture_userDao(Picture_userDao picture_userDao) {
		this.picture_userDao = picture_userDao;
	}
}
