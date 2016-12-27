package com.tswallpage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述用户收藏图片的信息
 * @author Forever
 *
 */
@Entity
@Table(name="tb_collect")
public class Collect {
	private int  c_no;		//收藏表ID
	private int c_uno;		//用户ID
	private int c_pno;		//图片ID
	public Collect() {
		super();
	}
	public Collect(int c_no, int c_uno, int c_pno) {
		super();
		this.c_no = c_no;
		this.c_uno = c_uno;
		this.c_pno = c_pno;
	}
	
	@Id
	@GeneratedValue
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public int getC_uno() {
		return c_uno;
	}
	public void setC_uno(int c_uno) {
		this.c_uno = c_uno;
	}
	public int getC_pno() {
		return c_pno;
	}
	public void setC_pno(int c_pno) {
		this.c_pno = c_pno;
	}
}
