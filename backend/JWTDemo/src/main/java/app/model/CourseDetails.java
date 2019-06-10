package app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_details")
public class CourseDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="module_id")
	private Integer id;
	@Column(name="module_name")
	private String moduleName;
	@Column(name="course_id",nullable=false, columnDefinition="int not null")
	private Integer courseId;
	
	public CourseDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseDetails(Integer id, String moduleName, Integer courseId) {
		super();
		this.id = id;
		this.moduleName = moduleName;
		this.courseId = courseId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "CourseDetails [id=" + id + ", moduleName=" + moduleName + ", courseId=" + courseId + "]";
	}
	
	
}
