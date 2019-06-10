package app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="schedules")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Schedule {



	
	public String getDate() {
		return date;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	
	@Column
	private String date;
	
	public void setDate(String date) {
		this.date = date;
	}

	

	@Column(name="subject1_id")
	private Integer subject1Id;
	@Column
	private String type1;
	
	@Column
	private String from1;
	
	@Column
	private String to1;
	@Column(name="teacher_name1")
	private String teacherName1;
	
	@Column(name="subject2_id")
	private Integer subject2Id;
	@Column
	private String type2;
	
	@Column
	private String from2;
	
	@Column
	private String to2;
	@Column(name="teacher_name2")
	private String teacherName2;
	
	@Column(name="course_id")
	private Integer courseId;

	@Column(name="room_id1")
	private Integer roomId1;
	
	@Column(name="room_id2")
	private Integer roomId2;
	
	public Integer getRoomId1() {
		return roomId1;
	}

	public void setRoomId1(Integer roomId1) {
		this.roomId1 = roomId1;
	}

	public Integer getRoomId2() {
		return roomId2;
	}

	public void setRoomId2(Integer roomId2) {
		this.roomId2 = roomId2;
	}

	

	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	

	public Integer getSubject1Id() {
		return subject1Id;
	}

	public void setSubject1Id(Integer subject1Id) {
		this.subject1Id = subject1Id;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getFrom1() {
		return from1;
	}

	public void setFrom1(String from1) {
		this.from1 = from1;
	}

	public String getTo1() {
		return to1;
	}

	public void setTo1(String to1) {
		this.to1 = to1;
	}

	
	public Integer getSubject2Id() {
		return subject2Id;
	}

	public void setSubject2Id(Integer subject2Id) {
		this.subject2Id = subject2Id;
	}

	public String getTeacherName1() {
		return teacherName1;
	}

	public void setTeacherName1(String teacherName1) {
		this.teacherName1 = teacherName1;
	}

	public String getTeacherName2() {
		return teacherName2;
	}

	public void setTeacherName2(String teacherName2) {
		this.teacherName2 = teacherName2;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getFrom2() {
		return from2;
	}

	public void setFrom2(String from2) {
		this.from2 = from2;
	}

	public String getTo2() {
		return to2;
	}

	public void setTo2(String to2) {
		this.to2 = to2;
	}


	@Override
	public String toString() {
		return "Schedule [id=" + id + ", date=" + date + ", subject1Id=" + subject1Id + ", type1=" + type1 + ", from1="
				+ from1 + ", to1=" + to1 + ", teacherName1=" + teacherName1 + ", subject2Id=" + subject2Id + ", type2="
				+ type2 + ", from2=" + from2 + ", to2=" + to2 + ", teacherName2=" + teacherName2 + ", courseId="
				+ courseId + ", roomId1=" + roomId1 + ", roomId2=" + roomId2 + "]";
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	
	
	
}
