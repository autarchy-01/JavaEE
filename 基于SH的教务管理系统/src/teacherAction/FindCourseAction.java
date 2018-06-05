package teacherAction;

import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import Dao.TeacherDao;
import PO.Course;

public class FindCourseAction extends ActionSupport {
	private HttpServletRequest request;
	 @Override
	    public String execute() throws Exception{
		 TeacherDao dao=new TeacherDao();
		 Course course=new Course();
		 request = ServletActionContext.getRequest();
		 HttpSession session=request.getSession();
		 List list=dao.findCourse((Integer)session.getAttribute("id"));
			 request.getSession().setAttribute("course", list);
			 return SUCCESS; 
		
		 
	 }

}
