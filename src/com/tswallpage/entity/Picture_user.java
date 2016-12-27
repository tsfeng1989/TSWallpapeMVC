package com.tswallpage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述用户图片中间表信息
 * @author Forever
 *
 */
@Entity
@Table(name="tb_picture_user")
public class Picture_user {
	private int pu_no;		//图片用户中间表ID
	private int pu_uno;		//用户ID
	private int pu_pno;		//图片ID
	public Picture_user() {
		super();
	}
	public Picture_user(int pu_no, int pu_uno, int pu_pno) {
		super();
		this.pu_no = pu_no;
		this.pu_uno = pu_uno;
		this.pu_pno = pu_pno;
	}
	
	@Id
	@GeneratedValue
	public int getPu_no() {
		return pu_no;
	}
	public void setPu_no(int pu_no) {
		this.pu_no = pu_no;
	}
	public int getPu_uno() {
		return pu_uno;
	}
	public void setPu_uno(int pu_uno) {
		this.pu_uno = pu_uno;
	}
	public int getPu_pno() {
		return pu_pno;
	}
	public void setPu_pno(int pu_pno) {
		this.pu_pno = pu_pno;
	}
}
