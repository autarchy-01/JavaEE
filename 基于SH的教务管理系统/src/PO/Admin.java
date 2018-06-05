package PO;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */
public class Admin extends AbstractAdmin implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(Integer admId, String username, String password) {
		super(admId, username, password);
	}

}
