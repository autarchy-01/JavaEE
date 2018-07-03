package adminAction;

import com.opensymphony.xwork2.ActionSupport;

import Dao.AdminDao;
import PO.Student;

public class AddStudentAction extends ActionSupport{
	private int id;
	private String name;
	private String password;
	private String sex;
	private String department;
	private String jiguan;
	private String tel;
	private int max;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJiguan() {
		return jiguan;
	}
	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	@Override
	public String execute() throws Exception{
		Student stu=new Student(getId(), getName(), getPassword(), getSex(), getDepartment(), getJiguan(), null, null, getTel(), getMax());
		AdminDao dao=new AdminDao();
		if(dao.saveStudent(stu)){
			return SUCCESS;
		}
		return INPUT;
	}

}
