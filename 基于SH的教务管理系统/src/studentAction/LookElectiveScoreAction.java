package studentAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.StudentDao;

public class LookElectiveScoreAction extends ActionSupport{
	private HttpServletRequest request;
	public String execute() throws Exception{
		StudentDao dao=new StudentDao();
		request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		List list=dao.getElectiveMessage((Integer)session.getAttribute("id"));
		session.setAttribute("ElectiveMessage", list);
		return SUCCESS;
	}

}
