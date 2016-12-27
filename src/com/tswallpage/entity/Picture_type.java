package com.tswallpage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述图片类型的实体类
 * @author Forever
 *
 */
@Entity
@Table(name="tb_picture_type")
public class Picture_type {
	private int pt_id;
	private String pt_name;
	
	public Picture_type() {
		super();
	}
	public Picture_type(int pt_id, String pt_name) {
		super();
		this.pt_id = pt_id;
		this.pt_name = pt_name;
	}
	@Id
	@GeneratedValue
	public int getPt_id() {
		return pt_id;
	}
	public void setPt_id(int pt_id) {
		this.pt_id = pt_id;
	}
	public String getPt_name() {
		return pt_name;
	}
	public void setPt_name(String pt_name) {
		this.pt_name = pt_name;
	}
}
