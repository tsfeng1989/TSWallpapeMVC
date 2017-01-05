package com.tswallpage.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import com.tswallpage.dao.PictureDao;
import com.tswallpage.entity.Picture;
import com.tswallpage.util.PageBean;
/**
 * 
 * @author Forever
 *
 */
@Repository("pictureDao")
public class PictureDaoImpl extends BaseDao implements PictureDao {
	@Resource(name="pageBean")
	private PageBean pageBean;
	
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
	
	//根据uuid生成名查询图片
	@Override
	public Picture findPictureByUUIDNane(String uname) {
		return (Picture)executeQuery("from Picture where p_path='"+uname+"'").get(0);
	}
	
	//查看全部图片
	@Override
	public List queryAllPicture() {
		return executeQuery("from Picture order by p_date desc");
	}
	
	//分页查询(查询全部数据)
	@Override
	public PageBean pagingQuery(int number) {
		final int sl = 24;															//每页显示的数量
		
		pageBean.setPageLine(sl);													//每页查询的记录数
		pageBean.setPageLine(number);												//当前页码
		
		String sql2 = "select count(*) totalCount from `tswallpape`.`tb_picture`";
		List pb = getSession().createSQLQuery(sql2).list();
		pageBean.setTotalCount(Integer.valueOf(pb.get(0).toString()));				//总记录数
		
		pageBean.setPageNum(pageBean.countPageNum(pageBean.getTotalCount(), sl));	//总页数
		pageBean.setStart(pageBean.countStart(number, sl));							//每页第一张的下标(从1开始)
		pageBean.setEnd(pageBean.countEnd(number, sl));								//每页最后一张的下标(从1开始)
		
		String sql = "select * from (select * from `tswallpape`.`tb_picture` p "
				+"left join `tswallpape`.`tb_picture_user` pr on p.p_no=pr.pu_pno "
				+"left join `tswallpape`.`tb_picture_type` pt on p.p_type=pt.pt_id "
				+"order by p.p_date desc,p.p_no desc) temporary_table limit "
				+(pageBean.getStart()-1)+","+(pageBean.getEnd()-pageBean.getStart()+1)+";";
					
		pageBean.setList(getSession().createSQLQuery(sql).list());					//查询结果集
		
		return pageBean;
	}
	
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
}
