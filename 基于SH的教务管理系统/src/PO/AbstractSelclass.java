package PO;

/**
 * AbstractSelclass entity provides the base persistence definition of the
 * Selclass entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSelclass implements java.io.Serializable {

	// Fields

	private SelclassId id;
	private Integer score;

	// Constructors

	/** default constructor */
	public AbstractSelclass() {
	}

	/** minimal constructor */
	public AbstractSelclass(SelclassId id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractSelclass(SelclassId id, Integer score) {
		this.id = id;
		this.score = score;
	}

	// Property accessors

	public SelclassId getId() {
		return this.id;
	}

	public void setId(SelclassId id) {
		this.id = id;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}