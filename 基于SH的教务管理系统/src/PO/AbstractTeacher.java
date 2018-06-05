package PO;

/**
 * AbstractTeacher entity provides the base persistence definition of the
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTeacher implements java.io.Serializable {

	// Fields

	private Integer teaId;
	private String username;
	private String password;
	private String email;
	private String tel;

	// Constructors

	/** default constructor */
	public AbstractTeacher() {
	}

	/** minimal constructor */
	public AbstractTeacher(Integer teaId, String username, String password) {
		this.teaId = teaId;
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public AbstractTeacher(Integer teaId, String username, String password, String email, String tel) {
		this.teaId = teaId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.tel = tel;
	}

	// Property accessors

	public Integer getTeaId() {
		return this.teaId;
	}

	public void setTeaId(Integer teaId) {
		this.teaId = teaId;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}