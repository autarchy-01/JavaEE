package PO;

/**
 * AbstractCourse entity provides the base persistence definition of the Course
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCourse implements java.io.Serializable {

	// Fields

	private Integer couId;
	private Integer teaId;
	private String typ;
	private Integer max;
	private String room;
	private String time;
	private String mark;
	private String couName;

	// Constructors

	/** default constructor */
	public AbstractCourse() {
	}

	/** minimal constructor */
	public AbstractCourse(Integer couId) {
		this.couId = couId;
	}
    public AbstractCourse(Integer couId,String couName,Integer max) {
    	this.couId = couId;
    	this.couName = couName;
    	this.max = max;
	}
    public AbstractCourse(Integer couId,String couName,Integer max,String room,String time) {
    	this.couId = couId;
    	this.couName = couName;
    	this.max = max;
    	this.room = room;
		this.time = time;
	}

	/** full constructor */
	public AbstractCourse(Integer couId, Integer teaId, String typ, Integer max, String room, String time, String mark,
			String couName) {
		this.couId = couId;
		this.teaId = teaId;
		this.typ = typ;
		this.max = max;
		this.room = room;
		this.time = time;
		this.mark = mark;
		this.couName = couName;
	}

	// Property accessors

	public Integer getCouId() {
		return this.couId;
	}

	public void setCouId(Integer couId) {
		this.couId = couId;
	}

	public Integer getTeaId() {
		return this.teaId;
	}

	public void setTeaId(Integer teaId) {
		this.teaId = teaId;
	}

	public String getTyp() {
		return this.typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public Integer getMax() {
		return this.max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public String getRoom() {
		return this.room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getCouName() {
		return this.couName;
	}

	public void setCouName(String couName) {
		this.couName = couName;
	}

}