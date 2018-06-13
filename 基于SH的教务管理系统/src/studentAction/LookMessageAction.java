package studentAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Dao.StudentDao;
import PO.Student;

public class LookMessageAction extends ActionSupport{
	private HttpServletRequest request;
	public String execute() throws Exception{
		StudentDao dao=new StudentDao();
		request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		Student stu=dao.getStudent((Integer)session.getAttribute("id"));
		request.getSession().setAttribute("student", stu);
		return SUCCESS;
		
	}

}
