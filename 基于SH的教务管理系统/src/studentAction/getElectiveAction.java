package studentAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.StudentDao;

public class getElectiveAction extends ActionSupport{
	private HttpServletRequest request;
	public String execute() throws Exception{
		StudentDao dao=new StudentDao();
		request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		//判断学生选课是否超过其最大选课数
		if(dao.getElectiveNumber((Integer)session.getAttribute("id"))<=dao.getStudent((Integer)session.getAttribute("id")).getMax()){
			List list=dao.getElective();
				session.setAttribute("elective", list);
				return SUCCESS;
			}
		return INPUT;
		}
	}
