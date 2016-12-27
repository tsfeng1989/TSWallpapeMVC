package com.tswallpage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tswallpage.dao.UsersDao;
import com.tswallpage.entity.Users;
import com.tswallpage.service.UsersService;
@Service("usersService")
public class UsersServiceImpl implements UsersService {
	@Resource(name="usersDao")
	private UsersDao usersDao;
	
	//注册用户
	@Override
	public Users addUsers(Users u) {
		return usersDao.addUsers(u);
	}
	
	//登录 
	@Override
	public Users login(Users u) {
		//首先判断用户是否存在
		Users users = usersDao.findUsersByName(u);
		if(users!=null){
			if(usersDao.loginUsers(u)){
				return users;
			}
		}
		return null;
	}
	
	//修改用户信息
	@Override
	public boolean updateUsers(Users u) {
		return usersDao.updateUsers(u);
	}
	
	//根据ID查询用户信息
	@Override
	public Users findUsersById(Users u) {
		return usersDao.findUsersById(u);
	}
	@Override
	public Users findUsersById2(int id) {
		return usersDao.findUsersById2(id);
	}
	
	//修改密码
	@Override
	public boolean updatePassword(Users u) {
		return usersDao.updatePassword(u);
	}
	

}
