package app.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private Integer id;
	@Column(name="course_name")
	private String courseName;
	@Column
	private int duration;
	@Column
	private double fees;
	@Column(name="module_count")
	private int moduleCount;
	
	@Column(name="room_id")
	private int roomId;
	@OneToMany
	@JoinTable(name="course_room",joinColumns=@JoinColumn(name="course_id"),inverseJoinColumns=@JoinColumn(name="room_id"))
	private Set<Room> rooms;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(Integer id, String courseName, int duration, double fees, int moduleCount) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.duration = duration;
		this.fees = fees;
		this.moduleCount = moduleCount;
	}

	
	public Course(Integer id, String courseName, int duration, double fees, int moduleCount, int roomId) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.duration = duration;
		this.fees = fees;
		this.moduleCount = moduleCount;
		this.roomId = roomId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public int getModuleCount() {
		return moduleCount;
	}

	public void setModuleCount(int moduleCount) {
		this.moduleCount = moduleCount;
	}

	

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		Room room = new Room(roomId);
		this.rooms.add(room);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", duration=" + duration + ", fees=" + fees
				+ ", moduleCount=" + moduleCount +"]";
	}
	
	
	
	
}
