package com.tswallpage.web;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tswallpage.entity.Picture;
import com.tswallpage.entity.Picture_user;
import com.tswallpage.entity.Users;
import com.tswallpage.service.PictureService;
import com.tswallpage.service.Picture_userService;
import com.tswallpage.service.UsersService;
import com.tswallpage.util.CreateUUID;
import com.tswallpage.util.MyDateFormat;
import com.tswallpage.util.PageBean;

/**
 * 
 * @author Forever
 *
 */
@Controller
@RequestMapping("/pictureAction")
public class PictureAction {
	@Resource(name="pictureService")
	private PictureService pictureService;
	@Resource(name="usersService")
	private UsersService usersService;
	@Resource(name="picture_userService")
	private Picture_userService picture_userService;
	
	
	//上传图片
	@RequestMapping("/uploadPicture")
	@ResponseBody
	public boolean uploadFiles(Picture p,@RequestParam("file_upload") MultipartFile [] files,
			HttpServletRequest request,String pname1,String pname2,String pname3,
			String pdescribe1,String pdescribe2,String pdescribe3,int picture_leixing,
			Users u,Picture_user pu){
		
	    boolean result = false;
	    String realPath;
	    String path = request.getSession().getServletContext().getRealPath("/picture/HD");	//Tomcat根目录+picture/HD（绝对路径）
	    
	    for(int i=0;i<files.length;i++){
	        if (!files[i].isEmpty()) { 
				String uuid = CreateUUID.getUUID();											//生成uuid
				String pictureName = files[i].getOriginalFilename();						//得到原文件名
				String suffix = pictureName.substring(pictureName.length()-3);				//文件获取后缀
				realPath = path + "/" + uuid + "." + suffix;								//项目根目录/picture/HD/自动生成名+后缀（绝对路径+图片名+后缀）
				String relativePath = "picture/HD" + "/" + uuid + "." + suffix;				//相对路径+后缀
				
				p.setP_date(new Date());													//上传日期
				p.setP_path(relativePath);													//保存路径(相对路径)
				p.setP_type(picture_leixing);												//图片类型
				
				//获取图片名称
				String pn = "pname" + (i+1);
				if(pn.equals("pname1")){
					p.setP_name(pname1);
				}else if(pn.equals("pname2")){
					p.setP_name(pname2);
				}else if(pn.equals("pname3")){
					p.setP_name(pname3);
				}
				if(p.getP_name()==null || p.getP_name().length()<1){
					p.setP_name(pictureName.substring(0, pictureName.length()-4));
				}
				
				//获取图片描述
				String pd = "pdescribe" + (i+1);
				if(pd.equals("pdescribe1")){
					p.setP_describe(pdescribe1);
				}else if(pd.equals("pdescribe2")){
					p.setP_describe(pdescribe2);
				}else if(pd.equals("pdescribe3")){
					p.setP_describe(pdescribe3);
				}
				
				//保存到数据库
	    		if(pictureService.uploadPicture(p)){
	    			//根据用户ID查用户信息
	    			u = usersService.findUsersById2(u.getU_no());
					//修改用户信息 --> 更新用户的上传图片数量
			    	u.setU_upload(u.getU_upload()+1);
			    	
			    	if(usersService.updateUsers2(u)){
			    		//添加用户图片中间表信息
			    		
			    		//根据自动生成名查图片（因为自动生成名是uuid生成的，是唯一的）
						Picture pic = pictureService.findPictureByUUIDNane(relativePath);
			    		pu.setPu_uno(u.getU_no());											//上传者ID
			    		pu.setPu_pno(pic.getP_no());										//图片ID
			    		
			    		if(picture_userService.addPicture_userDao(pu)){
			    			//所有信息修改成功后保存图片
			    			try {
								files[i].transferTo(new File(realPath));					// 保存文件
								result = true;
							} catch (IllegalStateException | IOException e) {
								e.printStackTrace();
							}
			    		}
			    	}
				}
	        }  
	    }
	    return result;
	}
	
	//删除图片
	@RequestMapping("/delPicture")
	public String delPicture(Picture p){
		if(pictureService.delPicture(p)){
			return "";
		}
		return "error";
	}
	
	//查询此用户的全部图片
	@RequestMapping("/findAllPicture")
	@ResponseBody
	public List findAllPicture(int id){
		return pictureService.findAllPicture(id);
	}
	
	//查询全部图片
	@RequestMapping("queryAllPicture")
	@ResponseBody
	public List queryAllPicture(){
		return pictureService.queryAllPicture();
	} 
	
	//分页查询图片
	@RequestMapping("/pagingQuery")
	@ResponseBody
	public PageBean pagingQuery(int number){
		PageBean pb = pictureService.pagingQuery(number);
		/*MyDateFormat d = new MyDateFormat();
		
		for (int i = 0; i < pb.getList().size(); i++) {
			Picture p = (Picture)pb.getList().get(i);
			p.setP_date(d.parse(d.format(p.getP_date(), "yyyy-MM-dd HH:mm:ss")));
		}*/
		
		return pb;
	}
	
	
	
	
	
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public void setPicture_userService(Picture_userService picture_userService) {
		this.picture_userService = picture_userService;
	}
	
}
