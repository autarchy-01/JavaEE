package teacherAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import Dao.TeacherDao;
import PO.Teacher;

public class JudgeEmailAction extends ActionSupport{
	private HttpServletRequest request;
	public String execute() throws Exception{
		TeacherDao dao=new TeacherDao();
		 request = ServletActionContext.getRequest();
		 HttpSession session=request.getSession();
		 Teacher teacher=dao.getTeacher((Integer)session.getAttribute("id"));
		 if(teacher.getEmail()==null){
			 return SUCCESS;
		 }
		 return INPUT;
	}
}
