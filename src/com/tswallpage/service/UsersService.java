package com.tswallpage.service;

import com.tswallpage.entity.Users;

public interface UsersService {
	//注册用户
	public Users addUsers(Users u);
	
	//登录
	public Users login(Users u);
	
	//修改用户信息
	/**
	 * 只修改 用户名、性别、年龄、个性签名、手机号码、电子邮箱
	 */
	public boolean updateUsers(Users u);
	/**
	 * 修改上传数量
	 */
	public boolean updateUsers2(Users u);
	
	//根据ID查询用户信息
	public Users findUsersById(Users u);
	public Users findUsersById2(int id);
	
	
	//修改密码
	public boolean updatePassword(Users u);
}
