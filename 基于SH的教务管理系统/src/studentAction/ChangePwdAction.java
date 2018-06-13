package studentAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.StudentDao;
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
		StudentDao dao=new StudentDao();
		if(dao.changePwd((Integer)session.getAttribute("id"), getPassword())){
			return SUCCESS;
		}else {
			return INPUT;
		}
	}

}
