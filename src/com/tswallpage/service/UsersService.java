package com.tswallpage.service;

import com.tswallpage.entity.Users;

public interface UsersService {
	//注册用户
	public Users addUsers(Users u);
	
	//登录
	public Users login(Users u);
	
	//修改用户信息
	public boolean updateUsers(Users u);
	
	//根据ID查询用户信息
	public Users findUsersById(Users u);
	public Users findUsersById2(int id);
	
	
	//修改密码
	public boolean updatePassword(Users u);
}
