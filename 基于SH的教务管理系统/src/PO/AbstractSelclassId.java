package PO;

/**
 * AbstractSelclassId entity provides the base persistence definition of the
 * SelclassId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSelclassId implements java.io.Serializable {

	// Fields

	private Integer stuId;
	private Integer couId;

	// Constructors

	/** default constructor */
	public AbstractSelclassId() {
	}

	/** full constructor */
	public AbstractSelclassId(Integer stuId, Integer couId) {
		this.stuId = stuId;
		this.couId = couId;
	}

	// Property accessors

	public Integer getStuId() {
		return this.stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public Integer getCouId() {
		return this.couId;
	}

	public void setCouId(Integer couId) {
		this.couId = couId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractSelclassId))
			return false;
		AbstractSelclassId castOther = (AbstractSelclassId) other;

		return ((this.getStuId() == castOther.getStuId()) || (this.getStuId() != null && castOther.getStuId() != null
				&& this.getStuId().equals(castOther.getStuId())))
				&& ((this.getCouId() == castOther.getCouId()) || (this.getCouId() != null
						&& castOther.getCouId() != null && this.getCouId().equals(castOther.getCouId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getStuId() == null ? 0 : this.getStuId().hashCode());
		result = 37 * result + (getCouId() == null ? 0 : this.getCouId().hashCode());
		return result;
	}

}