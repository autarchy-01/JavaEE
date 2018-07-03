package pagingAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import Dao.*;
public class GetPage {
	private HttpServletRequest request;
	public PageBean getPageBean1(int pageSize, int page) {
		String hql="";
        PageBean pageBean = new PageBean();      
        request=ServletActionContext.getRequest();      
        HttpSession session=request.getSession();
        hql = "from Teacher t";
    	TeacherDao dao=new TeacherDao();
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
	/**
     * pageSize为每页显示的记录数
     * page为当前显示的网页
     */
    public PageBean getPageBean(int pageSize, int page)
    {
    	String hql="";
        PageBean pageBean = new PageBean();      
        request=ServletActionContext.getRequest();      
        HttpSession session=request.getSession();   
        if((Integer)session.getAttribute("radiobutton")==2){
        	hql = "select s.stuId,s.username,s.sex,s.department,c.couId,c.couName,t.score from Student s,Course c,Selclass t where s.stuId=t.id.stuId and c.couId=t.id.couId ";
        	TeacherDao dao=new TeacherDao();
        	int allRows = dao.getAllRowCount(hql);       
            int totalPage = pageBean.getTotalPages(pageSize, allRows);       
            int currentPage = pageBean.getCurPage(page);      
            int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);  
            List list = dao.queryByPage(hql, offset, pageSize);  
            pageBean.setList(list);
            pageBean.setAllRows(allRows);
            pageBean.setCurrentPage(currentPage);
            pageBean.setTotalPage(totalPage);
        }else if((Integer)session.getAttribute("radiobutton")==3){
        	hql = "from Student s";
        	TeacherDao dao=new TeacherDao();
        	int allRows = dao.getAllRowCount(hql);       
            int totalPage = pageBean.getTotalPages(pageSize, allRows);       
            int currentPage = pageBean.getCurPage(page);      
            int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);  
            List list = dao.queryByPage(hql, offset, pageSize);  
            pageBean.setList(list);
            pageBean.setAllRows(allRows);
            pageBean.setCurrentPage(currentPage);
            pageBean.setTotalPage(totalPage);
		}     
        return pageBean;
    }
}