package com.tswallpage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tswallpage.dao.AdminDao;
import com.tswallpage.entity.Admin;
import com.tswallpage.service.AdminService;
/**
 * 
 * @author Forever
 *
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Resource(name="adminDao")
	private AdminDao adminDao;
	
	
	//µÇÂ¼
	@Override
	public Admin login(Admin admin) {
		return adminDao.login(admin);
	}
	
	
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
}
