package com.tswallpage.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tswallpage.entity.Admin;
import com.tswallpage.service.AdminService;

/**
 * 
 * @author Forever
 *
 */

@Controller
@RequestMapping("/adminAction")
public class AdminAction {
	@Resource(name="adminService")
	private AdminService adminService;
	
	//登录
	@RequestMapping("/login")
	public String login(Admin adm,HttpSession session){
		if(adminService.login(adm)!=null){
			//登录成功
			
			//清空密码
			adm.setA_password("");
			//保存到session
			session.setAttribute("admin", adm);
			
			return "redirect:/admin/NewFile.jsp";
		}
		return "error";
	}
	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
}
