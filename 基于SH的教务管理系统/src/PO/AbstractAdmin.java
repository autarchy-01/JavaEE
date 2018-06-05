package PO;

/**
 * AbstractAdmin entity provides the base persistence definition of the Admin
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAdmin implements java.io.Serializable {

	// Fields

	private Integer admId;
	private String username;
	private String password;

	// Constructors

	/** default constructor */
	public AbstractAdmin() {
	}

	/** full constructor */
	public AbstractAdmin(Integer admId, String username, String password) {
		this.admId = admId;
		this.username = username;
		this.password = password;
	}

	// Property accessors

	public Integer getAdmId() {
		return this.admId;
	}

	public void setAdmId(Integer admId) {
		this.admId = admId;
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

}