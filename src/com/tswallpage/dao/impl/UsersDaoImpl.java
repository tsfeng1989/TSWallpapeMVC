package com.tswallpage.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tswallpage.dao.UsersDao;
import com.tswallpage.entity.Users;
@Repository("usersDao")
public class UsersDaoImpl extends BaseDao implements UsersDao {
	//注册
	@Override
	public Users addUsers(Users u) {
		//注册日期为当前日期
		u.setU_intime(new Date());
		u.setU_attention(0);
		u.setU_fans(0);
		u.setU_state(0);
		u.setU_collect(0);
		u.setU_upload(0);
		return (Users) addObject(u);
	}
	
	//判断用户是否存在
	@Override
	public Users findUsersByName(Users u) {
		List list = getSession().createQuery("from Users u where u.u_name='"+u.getU_name()+"'").list();
		
		if(list.size()>0 && list!=null){
			return (Users)list.get(0);
		}else{
			return null;
		}
	}
	
	//验证账号密码是否正确
	@Override
	public boolean loginUsers(Users u) {
		List list = getSession().createQuery("from Users u where u.u_name='"+
			u.getU_name()+"' and u.u_pass='"+u.getU_pass()+"'").list();
		if(list.size()>0 && list!=null){
			return true;
		}else{
			return false;
		}
	}
	
	//修改用户信息
	/**
	 * 只修改 用户名、性别、年龄、个性签名、手机号码、电子邮箱
	 */
	@Override
	public boolean updateUsers(Users u) {
		//修改 用户名、性别、年龄、个性签名、手机号码、电子邮箱
		String sql = "update tswallpape.tb_user set u_name='"+u.getU_name()+"',u_sex='"
				+u.getU_sex()+"',u_age="+u.getU_age()+",u_autograph='"+u.getU_autograph()+"',u_phone='"
				+u.getU_phone()+"',u_email='"+u.getU_email()+"' where u_no="+u.getU_no();
		
		return getSession().createSQLQuery(sql).executeUpdate()>0?true:false;
	}
	/**
	 * 修改上传数量
	 */
	@Override
	public boolean updateUsers2(Users u) {
		String sql = "update tswallpape.tb_user set u_upload="+u.getU_upload()+" where u_no="+u.getU_no();
		
		return getSession().createSQLQuery(sql).executeUpdate()>0?true:false;
	}
	
	//根据ID查找用户
	@Override
	public Users findUsersById(Users u) {
		return (Users)get(u.getClass(), u.getU_no());
	}
	@Override
	public Users findUsersById2(int id) {
		return (Users)executeQuery("from Users where u_no="+id).get(0);
	}
	
	//登录
	@Override
	public boolean updatePassword(Users u) {
		String sql = "update tswallpape.tb_user set u_pass= '"+u.getNewPassword()+"' where u_no="+u.getU_no();
		
		return getSession().createSQLQuery(sql).executeUpdate()>0?true:false;
	}

	

}









