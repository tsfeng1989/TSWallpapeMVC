package com.tswallpage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述粉丝的信息
 * @author Forever
 *
 */
@Entity
@Table(name="tb_fans")
public class Fans {
	private int f_no;		//粉丝表ID
	private int f_uno;		//被关注用户ID
	private int f_uno2;		//关注用户ID
	public Fans() {
		super();
	}
	public Fans(int f_no, int f_uno, int f_uno2) {
		super();
		this.f_no = f_no;
		this.f_uno = f_uno;
		this.f_uno2 = f_uno2;
	}
	
	@Id
	@GeneratedValue
	public int getF_no() {
		return f_no;
	}
	public void setF_no(int f_no) {
		this.f_no = f_no;
	}
	public int getF_uno() {
		return f_uno;
	}
	public void setF_uno(int f_uno) {
		this.f_uno = f_uno;
	}
	public int getF_uno2() {
		return f_uno2;
	}
	public void setF_uno2(int f_uno2) {
		this.f_uno2 = f_uno2;
	}
}
