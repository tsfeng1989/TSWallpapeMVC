package com.tswallpage.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import com.tswallpage.dao.PictureDao;
import com.tswallpage.entity.Picture;
import com.tswallpage.util.MyDateFormat;
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
	
	//���ͼƬ
	@Override
	public boolean uploadPicture(Picture p) {
		return addObject(p)!=null?true:false;
	}
	
	//ɾ��ͼƬ
	@Override
	public boolean delPicture(Picture p) {
		return deleteObject(p);
	}
	
	//����ID��ѯͼƬ
	@Override
	public Picture findPictureById(int id) {
		return (Picture)executeQuery("from Picture where p_no="+id).get(0);
	}
	
	//�޸�ͼƬ
	@Override
	public boolean updatePicture(Picture p) {
		return updateObject(p);
	}
	
	//��ѯ���û�������ͼƬ
	@Override
	public List findAllPicture(int id) {
		String sql = "select * from `tswallpape`.`tb_picture` p "
	+"left join `tswallpape`.`tb_picture_user` pr on p.p_no=pr.pu_pno "
	+"left join `tswallpape`.`tb_picture_type` pt on p.p_type=pt.pt_id where pr.pu_uno="+id;
		return getSession().createSQLQuery(sql).list();
	}
	
	//����uuid��������ѯͼƬ
	@Override
	public Picture findPictureByUUIDNane(String uname) {
		return (Picture)executeQuery("from Picture where p_path='"+uname+"'").get(0);
	}
	
	//�鿴ȫ��ͼƬ
	@Override
	public List queryAllPicture() {
		return executeQuery("from Picture order by a_name");
	}
	
	//��ҳ��ѯ(��ѯȫ������)
	@Override
	public PageBean pagingQuery(int number) {
		final int sl = 24;															//ÿҳ��ʾ������
		
		pageBean.setPageLine(sl);													//ÿҳ��ѯ�ļ�¼��
		pageBean.setPageLine(number);												//��ǰҳ��
		
		String sql2 = "select count(*) totalCount from `tswallpape`.`tb_picture`";
		List pb = getSession().createSQLQuery(sql2).list();
		pageBean.setTotalCount(Integer.valueOf(pb.get(0).toString()));				//�ܼ�¼��
		
		pageBean.setPageNum(pageBean.countPageNum(pageBean.getTotalCount(), sl));	//��ҳ��
		pageBean.setStart(pageBean.countStart(number, sl));							//ÿҳ��һ�ŵ��±�(��1��ʼ)
		pageBean.setEnd(pageBean.countEnd(number, sl));								//ÿҳ���һ�ŵ��±�(��1��ʼ)
		
		String sql = "select * from (select * from `tswallpape`.`tb_picture` p "
				+"left join `tswallpape`.`tb_picture_user` pr on p.p_no=pr.pu_pno "
				+"left join `tswallpape`.`tb_picture_type` pt on p.p_type=pt.pt_id "
				+"order by p.p_date desc,p.p_no desc) temporary_table limit "
				+(pageBean.getStart()-1)+","+(pageBean.getEnd()-pageBean.getStart()+1)+";";
		
		MyDateFormat d = new MyDateFormat();
		
		List list = getSession().createSQLQuery(sql).list();
		
		System.out.println(list);
		
		pageBean.setList(list);					//��ѯ�����
		
		return pageBean;
	}
	
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
}
