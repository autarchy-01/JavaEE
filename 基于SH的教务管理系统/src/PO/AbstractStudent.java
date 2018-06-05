package PO;

/**
 * AbstractStudent entity provides the base persistence definition of the
 * Student entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStudent implements java.io.Serializable {

	// Fields

	private Integer stuId;
	private String username;
	private String password;
	private String sex;
	private String department;
	private String jiguan;
	private Integer mark;
	private String email;
	private String image;
	private String tel;
	private Integer max;

	// Constructors

	/** default constructor */
	public AbstractStudent() {
	}

	/** minimal constructor */
	public AbstractStudent(Integer stuId, String username, String password) {
		this.stuId = stuId;
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public AbstractStudent(Integer stuId, String username, String password, String sex, String department,
			String jiguan, Integer mark, String email, String image, String tel, Integer max) {
		this.stuId = stuId;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.department = department;
		this.jiguan = jiguan;
		this.mark = mark;
		this.email = email;
		this.image = image;
		this.tel = tel;
		this.max = max;
	}

	// Property accessors

	public Integer getStuId() {
		return this.stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJiguan() {
		return this.jiguan;
	}

	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}

	public Integer getMark() {
		return this.mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getMax() {
		return this.max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

}