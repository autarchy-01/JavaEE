package paging;

import java.util.List;
import Dao.*;
public class GetPage {
	private TeacherDao dao=new TeacherDao();
	/**
     * pageSize为每页显示的记录数
     * page为当前显示的网页
     */
    public PageBean getPageBean(int pageSize, int page)
    {
        PageBean pageBean = new PageBean();
        
        String hql = "select s.stuId,s.username,s.sex,s.department,c.couId,c.couName,t.score from Student s,Course c,Selclass t where s.stuId=t.id.stuId and c.couId=t.id.couId ";
        
        int allRows = dao.getAllRowCount(hql);
        
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        
        int currentPage = pageBean.getCurPage(page);
        
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        
        List list = dao.queryByPage(hql, offset, pageSize);
        
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        
        return pageBean;
    }
}