package studentAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.StudentDao;

public class setElectiveAction extends ActionSupport{
	private HttpServletRequest request;
	private Integer radiobutton;
	public Integer getRadiobutton() {
		return radiobutton;
	}
	public void setRadiobutton(Integer radiobutton) {
		this.radiobutton = radiobutton;
	}
	public String execute() throws Exception{
		StudentDao dao=new StudentDao();
		request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		//判断选课人数是否超过该选课最大选课人数
		if(dao.getNumber(getRadiobutton())<dao.getCourse(getRadiobutton()).getMax()){
			//判断该学生是否已经选修了该选修课
			if(!dao.judgeElective((Integer)session.getAttribute("id"), getRadiobutton())){
				//判断该选课记录是否保存成功
				if(dao.setElective((Integer)session.getAttribute("id"), getRadiobutton())){
					return SUCCESS;
					}
				}			
		}
		return INPUT;
		}
	}
