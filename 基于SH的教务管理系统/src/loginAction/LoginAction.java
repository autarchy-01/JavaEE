package loginAction;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import Dao.*;
import PO.*;

public class LoginAction extends ActionSupport{
	private String sno;
	private String password;
	private Integer radiobutton;
	private HttpServletRequest request;
	StudentDao sm=new StudentDao();
	AdminDao ad=new AdminDao();
	TeacherDao te=new TeacherDao();
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRadiobutton() {
		return radiobutton;
	}
	public void setRadiobutton(Integer radiobutton) {
		this.radiobutton = radiobutton;
	}
	public String execute() {
		if(radiobutton==1){
			Student stu=new Student();
			stu.setStuId(Integer.parseInt(getSno()));
			stu.setPassword(getPassword());
			if(sm.stuLogin(stu)){
				request=ServletActionContext.getRequest();
				HttpSession session=request.getSession();
				Student stu1=sm.getStudent(Integer.parseInt(getSno()));
				session.setAttribute("username", stu1.getUsername());
				session.setAttribute("id", stu1.getStuId());
				return SUCCESS;
			}
			
		}else if (radiobutton==2) {
			Teacher tea=new Teacher();
			tea.setTeaId(Integer.parseInt(getSno()));
			tea.setPassword(getPassword());
			if(te.teaLogin(tea)){
				request=ServletActionContext.getRequest();
				HttpSession session=request.getSession();
				Teacher tea1=te.getTeacher(Integer.parseInt(getSno()));
				session.setAttribute("username", tea1.getUsername());
				session.setAttribute("id", tea1.getTeaId());
				return "tsuccess";
			}
		}else if (radiobutton==3) {
			Admin adm=new Admin();
			adm.setAdmId(Integer.parseInt(getSno()));
			adm.setPassword(getPassword());
			if(ad.admLogin(adm)){
				return "asuccess";
			}
		}else{
			return INPUT;			
		}
		return INPUT;
	}

}
