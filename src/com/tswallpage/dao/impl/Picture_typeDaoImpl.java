package com.tswallpage.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tswallpage.dao.Picture_typeDao;
import com.tswallpage.entity.Picture_type;
/**
 * 
 * @author Forever
 *
 */
@Repository("picture_typeDao")
public class Picture_typeDaoImpl extends BaseDao implements Picture_typeDao {
	//添加类型
	@Override
	public boolean addType(Picture_type pt) {
		return addObject(pt)!=null?true:false;
	}
	
	//删除类型
	@Override
	public boolean delType(Picture_type pt) {
		return deleteObject(pt);
	}
	
	//根据ID查找类型
	@Override
	public Picture_type findPtById(int id) {
		return (Picture_type)executeQuery("from Picture_type where pt_id="+id).get(0);
	}
	
	//修改类型
	@Override
	public boolean updateType(Picture_type pt) {
		return updateObject(pt);
	}
	
	//查找全部类型
	@Override
	public List findAllPt() {
		return executeQuery("from Picture_type");
	}

}
