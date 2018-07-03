package emailAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.AdminDao;
import Dao.StudentDao;
import Dao.TeacherDao;
import PO.Student;
import PO.Teacher;

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
		request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		if((Integer)session.getAttribute("radiobutton")==1){
			StudentDao dao=new StudentDao();
			if(dao.setEmail((Integer)session.getAttribute("id"), getEmail())){
				return "student";
				}
			}else if ((Integer)session.getAttribute("radiobutton")==2){
				TeacherDao dao=new TeacherDao();
				if(dao.setEmail((Integer)session.getAttribute("id"), getEmail())){
					return "teacher";
					}
				}
		return INPUT;
		}
	}
