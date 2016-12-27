package com.tswallpage.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tswallpage.entity.Picture_type;
import com.tswallpage.service.Picture_typeService;

/**
 * 
 * @author Forever
 *
 */
@Controller
@RequestMapping("/picture_typeAction")
public class Picture_typeAction {
	@Resource(name="picture_typeService")
	private Picture_typeService picture_typeService;
	
	//添加图片类型
	@RequestMapping("/addPt")
	public String addPt(Picture_type pt){
		System.out.println("执行了picture_typeAction");
		if(picture_typeService.addPicture_type(pt)){
			return "";
		}
		return "error";
	}
	
	//删除图片类型
	@RequestMapping("/delpt")
	public String delpt(Picture_type pt){
		if(picture_typeService.delPicture_type(pt)){
			return "";
		}
		return "error";
	}
	
	//根据ID查询图片
	@RequestMapping("/findPtById")
	public String findPtById(Picture_type pt,int id,HttpServletRequest request){
		pt = picture_typeService.findPtById(id);
		if(pt!=null){
			request.setAttribute("Picture_type", pt);
			return "";
		}
		return "error";
	}
	
	//修改图片类型
	@RequestMapping("/updatePt")
	public String updatePt(Picture_type pt){
		if(picture_typeService.updatePt(pt)){
			return "";
		}
		return "error";
	}
	
	//查看全部图片类型
	@RequestMapping("/findAllPt")
	@ResponseBody
	public List findAllPt(){
		return picture_typeService.findAllPt();
	}
	
	
	public void setPicture_typeService(Picture_typeService picture_typeService) {
		this.picture_typeService = picture_typeService;
	}
}
