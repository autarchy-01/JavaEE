package adminAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.AdminDao;
import PO.Teacher;

public class FindTeachertAction extends ActionSupport{
	private HttpServletRequest request;
	private int teaId;

	public int getTeaId() {
		return teaId;
	}

	public void setTeaId(int teaId) {
		this.teaId = teaId;
	}
	public String execute() throws Exception{
		request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		AdminDao dao=new AdminDao();
		Teacher tea=dao.getTeacher(getTeaId());
		if(tea!=null){
			session.setAttribute("teacher", tea);
			return SUCCESS;
		}
		return INPUT;
		
	}

}
