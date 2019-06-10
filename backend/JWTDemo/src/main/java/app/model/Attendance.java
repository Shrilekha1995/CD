package app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="attendance_details")
public class Attendance implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="attendance_id")
	private Integer id;
	
	@Column
	private String prn;
	
	@Column
	@JsonProperty
	private Integer proxy;
	
	@Column(name="subject_id")
	private Integer subjectId;

	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attendance(Integer id, String prn, int proxy, Integer subjectId) {
		super();
		this.id = id;
		this.prn = prn;
		this.proxy = proxy;
		this.subjectId = subjectId;
	}

	public Attendance(String prn, int proxy, Integer subjectId) {
		super();
		this.prn = prn;
		this.proxy = proxy;
		this.subjectId = subjectId;
	}

	
	public Attendance(String prn, int proxy) {
		super();
		
		this.prn = prn;
		this.proxy = proxy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrn() {
		return prn;
	}

	public void setPrn(String prn) {
		this.prn = prn;
	}

	public int getProxy() {
		return proxy;
	}

	public void setProxy(int proxy) {
		this.proxy = proxy;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	
	
}
