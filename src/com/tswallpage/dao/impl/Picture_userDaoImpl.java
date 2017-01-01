package com.tswallpage.dao.impl;

import org.springframework.stereotype.Repository;

import com.tswallpage.dao.Picture_userDao;
import com.tswallpage.entity.Picture_user;
/**
 * 
 * @author Forever
 *
 */
@Repository("picture_userDao")
public class Picture_userDaoImpl extends BaseDao implements Picture_userDao {
	
	//Ìí¼Ó
	@Override
	public boolean addPicture_userDao(Picture_user pu) {
		return addObject(pu)!=null?true:false;
	}
	
	//É¾³ý
	@Override
	public boolean delPicture_userDao(Picture_user pu) {
		return deleteObject(pu);
	}
	
	//ÐÞ¸Ä
	@Override
	public boolean updatePicture_userDao(Picture_user pu) {
		return updateObject(pu);
	}

}
