package adminAction;

import com.opensymphony.xwork2.ActionSupport;

import Dao.AdminDao;
import PO.Teacher;

public class AddTeacherAction extends ActionSupport{
	private int id;
	private String name;
	private String password;
	private String tel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String execute() throws Exception{
		Teacher tea=new Teacher(getId(), getName(), getPassword(), null, getTel());
		AdminDao dao=new AdminDao();
		if(dao.saveTeacher(tea)){
			return SUCCESS;
		}
		return INPUT;
		
		
	}
}
