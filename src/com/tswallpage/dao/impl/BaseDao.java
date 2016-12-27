package com.tswallpage.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
@Repository
public class BaseDao {

	@Resource
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	//执行添加的公共方法
		public Object addObject(Object obj){
			try {
				getSession().save(obj);
				return obj;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		//执行修改的公共方法
		public boolean updateObject(Object obj){
			try {
				getSession().update(obj);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}

		//执行删除的公共方法
		public boolean deleteObject(Object obj){
			try {
				getSession().delete(obj);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		/**
		 * 公共根据Id获取对象的方法
		 * @param cls 对象的类型
		 * @param id  Id主键
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		public Object get(Class cls,Serializable id){
			Object obj = null;
			try {
				obj=getSession().get(cls, id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return obj;
		}
		
		//公共查询方法
		@SuppressWarnings("rawtypes")
		public List executeQuery(String hql){
			return getSession().createQuery(hql).list() ; 
		}
}
