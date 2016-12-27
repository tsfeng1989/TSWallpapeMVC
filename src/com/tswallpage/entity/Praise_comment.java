package com.tswallpage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述赞评论的信息
 * @author Forever
 *
 */
@Entity
@Table(name="tb_praise_comment")
public class Praise_comment {
	private int pc_no;			//赞评论表ID
	private int pc_co_no;		//图片评论ID
	private int pc_u_no;		//赞评论用户的ID
	public Praise_comment() {
		super();
	}
	public Praise_comment(int pc_no, int pc_co_no, int pc_u_no) {
		super();
		this.pc_no = pc_no;
		this.pc_co_no = pc_co_no;
		this.pc_u_no = pc_u_no;
	}
	
	@Id
	@GeneratedValue
	public int getPc_no() {
		return pc_no;
	}
	public void setPc_no(int pc_no) {
		this.pc_no = pc_no;
	}
	public int getPc_co_no() {
		return pc_co_no;
	}
	public void setPc_co_no(int pc_co_no) {
		this.pc_co_no = pc_co_no;
	}
	public int getPc_u_no() {
		return pc_u_no;
	}
	public void setPc_u_no(int pc_u_no) {
		this.pc_u_no = pc_u_no;
	}
}
