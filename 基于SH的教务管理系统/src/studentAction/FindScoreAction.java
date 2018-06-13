package studentAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.StudentDao;

public class FindScoreAction extends ActionSupport{
	private HttpServletRequest request;
	public String execute() throws Exception{
		StudentDao dao=new StudentDao();
		request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		List list=dao.getRequiredScore((Integer)session.getAttribute("id"));
		if(list.size()!=0){
			session.setAttribute("required", list);
			return SUCCESS;
		}
		return INPUT;
		
		
	}

}
