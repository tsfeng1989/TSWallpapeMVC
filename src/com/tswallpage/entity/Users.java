package com.tswallpage.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 封装用户的实体类
 * @author Forever
 * @version 1.0
 */
@Entity
@Table(name="tb_user")
public class Users implements Serializable {
	private int u_no;				/*用户ID*/
	private String u_name;			/*用户名*/
	private String u_pass;			/*密码*/
	private String u_sex;			/*性别*/
	private int u_age;				/*性别*/
	private String u_photo;			/*头像*/
	private String u_autograph;		/*个性签名*/
	private String u_phone;			/*手机号码*/
	private String u_email;			/*电子邮箱*/
	private Date u_intime;			/*注册时间*/
	private int u_attention;		/*关注数量*/
	private int u_fans;				/*粉丝数量*/
	private int u_upload;			/*用户上传图片数量*/
	private int u_collect;			/*用户收藏图片数量*/
	private int u_state;			/*状态 0：正常，1：冻结*/
	
	//新增  新密码
	private String newPassword;
	
	public Users() {
		super();
	}
	
	public Users(int u_no, String u_name, String u_pass, String u_sex, int u_age, String u_photo, String u_autograph,
			String u_phone, String u_email, Date u_intime, int u_attention, int u_fans, int u_upload, int u_collect,
			int u_state) {
		super();
		this.u_no = u_no;
		this.u_name = u_name;
		this.u_pass = u_pass;
		this.u_sex = u_sex;
		this.u_age = u_age;
		this.u_photo = u_photo;
		this.u_autograph = u_autograph;
		this.u_phone = u_phone;
		this.u_email = u_email;
		this.u_intime = u_intime;
		this.u_attention = u_attention;
		this.u_fans = u_fans;
		this.u_upload = u_upload;
		this.u_collect = u_collect;
		this.u_state = u_state;
	}







	@Id
	@GeneratedValue
	public int getU_no() {
		return u_no;
	}
	public void setU_no(int u_no) {
		this.u_no = u_no;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_pass() {
		return u_pass;
	}
	public void setU_pass(String u_pass) {
		this.u_pass = u_pass;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public int getU_age() {
		return u_age;
	}
	public void setU_age(int u_age) {
		this.u_age = u_age;
	}
	public String getU_photo() {
		return u_photo;
	}
	public void setU_photo(String u_photo) {
		this.u_photo = u_photo;
	}
	public String getU_autograph() {
		return u_autograph;
	}
	public void setU_autograph(String u_autograph) {
		this.u_autograph = u_autograph;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public Date getU_intime() {
		return u_intime;
	}
	public void setU_intime(Date u_intime) {
		this.u_intime = u_intime;
	}
	public int getU_attention() {
		return u_attention;
	}
	public void setU_attention(int u_attention) {
		this.u_attention = u_attention;
	}
	public int getU_fans() {
		return u_fans;
	}
	public void setU_fans(int u_fans) {
		this.u_fans = u_fans;
	}
	public int getU_upload() {
		return u_upload;
	}
	public void setU_upload(int u_upload) {
		this.u_upload = u_upload;
	}
	public int getU_collect() {
		return u_collect;
	}
	public void setU_collect(int u_collect) {
		this.u_collect = u_collect;
	}
	public int getU_state() {
		return u_state;
	}
	public void setU_state(int u_state) {
		this.u_state = u_state;
	}

	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
