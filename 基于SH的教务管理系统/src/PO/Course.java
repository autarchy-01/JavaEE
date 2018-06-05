package PO;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */
public class Course extends AbstractCourse implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(Integer couId) {
		super(couId);
	}

	/** full constructor */
	public Course(Integer couId, Integer teaId, String type, Integer max, String room, String time, String mark,
			String couName) {
		super(couId, teaId, type, max, room, time, mark, couName);
	}

}
