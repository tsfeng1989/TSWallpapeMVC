package com.tswallpage.dao.impl;

import org.springframework.stereotype.Repository;

import com.tswallpage.dao.AdminDao;
import com.tswallpage.entity.Admin;
@Repository("adminDao")
public class AdminDaoImpl extends BaseDao implements AdminDao {
	
	//登录 （ 这样做是不安全的，为了方便所以这么写）
	@Override
	public Admin login(Admin admin) {
		return (Admin)executeQuery("from Admin where a_name='"
	+admin.getA_name()+"' and a_password='"+admin.getA_password()+"'").get(0);
	}

}
