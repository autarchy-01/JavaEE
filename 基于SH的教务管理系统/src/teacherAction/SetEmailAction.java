package teacherAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.TeacherDao;

public class SetEmailAction extends ActionSupport{
	private HttpServletRequest request;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String execute() throws Exception{
		request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		TeacherDao dao=new TeacherDao();
		if(dao.setEmail((Integer)session.getAttribute("id"), getEmail())){
			return SUCCESS;
		}else {
			return INPUT;
		}
		
		
	}

}
