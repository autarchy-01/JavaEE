package adminAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.AdminDao;
import PO.Student;

public class FindStudentAction extends ActionSupport{
	private HttpServletRequest request;
	private int stuId;

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String execute() throws Exception{
		request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		AdminDao dao=new AdminDao();
		Student stu=dao.getStudent(getStuId());
		if(stu!=null){
			session.setAttribute("student", stu);
			return SUCCESS;
		}
		return INPUT;
		
	}

}
