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
	public Course(Integer couId,String couName,Integer max) {
		super(couId,couName, max);
	}
	public Course(Integer couId,String couName,Integer max,String room,String time){
		super(couId,couName, max,room,time);
	}

	/** full constructor */
	public Course(Integer couId, Integer teaId, String typ, Integer max, String room, String time, String mark,
			String couName) {
		super(couId, teaId, typ, max, room, time, mark, couName);
	}

}
