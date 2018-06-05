package PO;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */
public class Teacher extends AbstractTeacher implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Integer teaId, String username, String password) {
		super(teaId, username, password);
	}

	/** full constructor */
	public Teacher(Integer teaId, String username, String password, String email, String tel) {
		super(teaId, username, password, email, tel);
	}

}
