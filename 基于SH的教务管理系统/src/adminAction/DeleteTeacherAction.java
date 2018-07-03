package adminAction;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.AdminDao;

public class DeleteTeacherAction extends ActionSupport{

	private HttpServletRequest request;
	public String execute() throws Exception{
		request=ServletActionContext.getRequest();
		String stu=request.getParameter("deleteTeacherValue");
		System.out.println(stu);
		String stuId []=stu.split(",");
		int id []=new int[stuId.length];
		for(int i=0;i<stuId.length;i++){
			id[i]=Integer.parseInt(stuId[i]);
		}
		AdminDao dao=new AdminDao();
		for(int j = 0;j<id.length;j++){
			dao.deleteTeacher(id[j]);
		}
		return SUCCESS;
	}
}
