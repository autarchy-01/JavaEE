package emailAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Dao.AdminDao;
import Dao.StudentDao;
import Dao.TeacherDao;
import PO.Admin;
import PO.Student;
import PO.Teacher;

public class JudgeEmailAction extends ActionSupport{
	private HttpServletRequest request;
	public String execute() throws Exception{
		request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		if((Integer)session.getAttribute("radiobutton")==1){
			StudentDao dao=new StudentDao();
			Student student=dao.getStudent((Integer)session.getAttribute("id"));
			if(student.getEmail()==null||student.getEmail()=="null"){
				return SUCCESS;
				}
			else{
				return "student";
				}
			}else if ((Integer)session.getAttribute("radiobutton")==2){
				TeacherDao dao=new TeacherDao();
				Teacher teacher=dao.getTeacher((Integer)session.getAttribute("id"));
				if(teacher.getEmail()==null||teacher.getEmail()=="null"){
					return SUCCESS;
					}
				else{
					return "teacher";
					}
				}
		return INPUT;
		}
	}
