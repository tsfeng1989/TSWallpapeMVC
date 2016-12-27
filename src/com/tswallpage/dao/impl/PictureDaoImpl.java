package com.tswallpage.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.tswallpage.dao.PictureDao;
import com.tswallpage.entity.Picture;
/**
 * 
 * @author Forever
 *
 */
@Repository("pictureDao")
public class PictureDaoImpl extends BaseDao implements PictureDao {
	
	//添加图片
	@Override
	public boolean uploadPicture(Picture p) {
		return addObject(p)!=null?true:false;
	}
	
	//删除图片
	@Override
	public boolean delPicture(Picture p) {
		return deleteObject(p);
	}
	
	//根据ID查询图片
	@Override
	public Picture findPictureById(int id) {
		return (Picture)executeQuery("from Picture where p_no="+id).get(0);
	}
	
	//修改图片
	@Override
	public boolean updatePicture(Picture p) {
		return updateObject(p);
	}
	
	//查询本用户的所有图片
	@Override
	public List findAllPicture(int id) {
		String sql = "select * from `tswallpape`.`tb_picture` p "
	+"left join `tswallpape`.`tb_picture_user` pr on p.p_no=pr.pu_pno "
	+"left join `tswallpape`.`tb_picture_type` pt on p.p_type=pt.pt_id where pr.pu_uno="+id;
		return getSession().createSQLQuery(sql).list();
	}

}
