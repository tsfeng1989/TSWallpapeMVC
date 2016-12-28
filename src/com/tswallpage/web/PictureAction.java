package com.tswallpage.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tswallpage.entity.Picture;
import com.tswallpage.service.PictureService;
import com.tswallpage.util.CreateUUID;

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
	
	//上传图片
	@RequestMapping("/uploadPicture")
	public String uploadPicture(Picture p){
		
		System.out.println("----uploadAction----");
		if(pictureService.uploadPicture(p)){
			return "pages/users_info";
		}
		return "error";
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
	
	
	
	
	
	
	@RequestMapping("/uploadPicture2")
	@ResponseBody
	public boolean uploadFiles(@RequestParam("file_upload") MultipartFile [] files,
			HttpServletRequest request,String pname1,String pname2,String pname3){
		
	    boolean result = false;
	    String realPath;
	    String path = request.getSession().getServletContext().getRealPath("/picture/HD");	//Tomcat根目录+picture/HD
	    
	    for(int i=0;i<files.length;i++){
	        if (!files[i].isEmpty()) { 
				String uuid = CreateUUID.getUUID();											//生成uuid
				String pictureName = files[i].getOriginalFilename();						//得到原文件名
				String suffix = pictureName.substring(pictureName.length()-3);				//文件获取后缀
				realPath = path + "/" + uuid + "." + suffix;										//上传到（项目根目录/picture/HD）
				
				System.out.println("原文件名："+pictureName);
				System.out.println("上传路径+自动生成名+后缀"+realPath);
				
		    	try {
					files[i].transferTo(new File(realPath));								// 保存文件
					result = true;
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}			
	        }  
	    }
	    return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}
}
