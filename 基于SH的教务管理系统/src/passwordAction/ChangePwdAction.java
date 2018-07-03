package passwordAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.AdminDao;
import Dao.StudentDao;
import Dao.TeacherDao;

public class ChangePwdAction extends ActionSupport{
	private HttpServletRequest request;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute() throws Exception{
		request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		if((Integer)session.getAttribute("radiobutton")==1){
			StudentDao dao=new StudentDao();
			if(dao.changePwd((Integer)session.getAttribute("id"), getPassword())){
				return SUCCESS;
				}
			}else if ((Integer)session.getAttribute("radiobutton")==2){
				TeacherDao dao=new TeacherDao();
				if(dao.changePwd((Integer)session.getAttribute("id"), getPassword())){
					return SUCCESS;
					}
				}else if ((Integer)session.getAttribute("radiobutton")==3) {
					AdminDao dao=new AdminDao();
					if(dao.changePwd((Integer)session.getAttribute("id"), getPassword())){
						return SUCCESS;
						}
					}
		return INPUT;
		}
	}
