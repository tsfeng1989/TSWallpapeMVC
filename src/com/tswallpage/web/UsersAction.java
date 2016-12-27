package com.tswallpage.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tswallpage.entity.Users;
import com.tswallpage.service.UsersService;

/**
 * 
 * @author Forever
 *
 */
@Controller
@RequestMapping("/usersAction")
public class UsersAction {
	@Resource(name="usersService")
	private UsersService usersService;
	
	//注册用户
	@RequestMapping("/addUsers")
	public String addUsers(Users u){
		usersService.addUsers(u);
		return "redirect:/pages/users_login.jsp";
	}
	//登录
	@RequestMapping("/login")
	public String login(Users u,HttpSession session){
		Users users = usersService.login(u);
		if(users!=null){
			//清空密码，以防密码泄露
			users.setU_pass("");
			//把用户保存到session中
			session.setAttribute("user", users);
			session.getAttribute("user");
			return "redirect:/index.jsp";
		}
		return "error";
	}
	//退出登录
	@RequestMapping("/logout")
	public String logout(Users u,HttpSession session){
		session.invalidate();
		return "redirect:/index.jsp";
	}
	
	//修改用户信息（修改 用户名、性别、年龄、个性签名、手机号码、电子邮箱）
	@RequestMapping("/updateUsers")
	public String updateUsers(Users u,String result,HttpServletRequest request,HttpSession session){
		if(usersService.updateUsers(u)){
			result = "true";
			request.setAttribute("result", result);
			return "pages/users_info";
		}
		result = "false";
		request.setAttribute("result", result);
		return "pages/users_info";
	}
	//根据ID查询用户信息
	@RequestMapping("/findUsersById")
	public Users findUsersById(Users u,int id){
		System.out.println("id:"+id);
		u = usersService.findUsersById2(id);
		System.out.println(u);
		return u;
	}
	
	//修改密码
	@RequestMapping("/updatePassword")
	public String updatePassword(Users u,String message,HttpServletRequest request){
		//验证旧密码
		if(usersService.login(u) != null){
			//验证成功，修改密码
			u.setU_pass(u.getNewPassword());
			if(usersService.updatePassword(u)){
				//修改成功
				return "pages/users_info";
			}
		}
		//旧密码错误
		return "pages/users_info";
	}
	
	
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
}
