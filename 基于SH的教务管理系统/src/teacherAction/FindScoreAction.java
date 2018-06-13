package teacherAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.TeacherDao;
import PO.Selclass;
import PO.SelclassId;

public class FindScoreAction extends ActionSupport{
	private int stuId;
	private int couId;
	private HttpServletRequest request;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public int getCouId() {
		return couId;
	}
	public void setCouId(int couId) {
		this.couId = couId;
	}
	public String execute() throws Exception{
		TeacherDao dao=new TeacherDao();
		SelclassId id=new SelclassId(getStuId(),getCouId());
		Selclass s=dao.getScore(id);
		if(s!=null){
		int stuId=s.getId().getStuId();
		int couId=s.getId().getCouId();
		int score=s.getScore();
			request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			session.setAttribute("stuId", stuId);
			session.setAttribute("couId", couId);
			session.setAttribute("score", score);
			return SUCCESS;
		}
		return INPUT;
		
		
	}

}
