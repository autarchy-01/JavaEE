package PO;

/**
 * Selclass entity. @author MyEclipse Persistence Tools
 */
public class Selclass extends AbstractSelclass implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Selclass() {
	}

	/** minimal constructor */
	public Selclass(SelclassId id) {
		super(id);
	}

	/** full constructor */
	public Selclass(SelclassId id, Integer score) {
		super(id, score);
	}

}
