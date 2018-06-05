package PO;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
public class Student extends AbstractStudent implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Integer stuId, String username, String password) {
		super(stuId, username, password);
	}

	/** full constructor */
	public Student(Integer stuId, String username, String password, String sex, String department, String jiguan,
			Integer mark, String email, String image, String tel, Integer max) {
		super(stuId, username, password, sex, department, jiguan, mark, email, image, tel, max);
	}

}
