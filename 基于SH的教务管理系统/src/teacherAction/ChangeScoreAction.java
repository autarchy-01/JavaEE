package teacherAction;

import com.opensymphony.xwork2.ActionSupport;

import Dao.TeacherDao;
import PO.Selclass;
import PO.SelclassId;

public class ChangeScoreAction extends ActionSupport{
	private int stuId;
	private int couId;
	private int score;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String execute() throws Exception{
		SelclassId id=new SelclassId(getStuId(), getCouId());
		Selclass score=new Selclass(id, getScore());
		TeacherDao dao=new TeacherDao();
		boolean update=dao.updateScore(score);
		if(update){
			return SUCCESS;
		}
		return INPUT;
	}

}
