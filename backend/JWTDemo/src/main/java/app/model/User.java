package app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Integer id;
	@Column
	private String prn;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="username")
	private String email;
	@Column(name="contact_number")
	private String contactNumber;
	@Column
	private String password;
	@Transient
	private String confirmPassword;
	@Column(columnDefinition="boolean not null")
	private boolean enabled;
	@Column
	private String role;
	/*@Column(name="user_type") 
	private String userType;*/
	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;
	@Transient
	@JsonProperty
	private String ip;
	@Transient
	@JsonProperty
	private String latitude,longitude;
	@Column(name="course_id",nullable=false, columnDefinition="int not null")
	private Integer courseId;
	
	
	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public User() {
	
	}


	public User(Integer id, String prn, String firstName, String lastName, String email, String contactNumber,
			String password, String confirmPassword, boolean active, String role, String userType) {
		super();
		this.id = id;
		this.prn = prn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.enabled = active;
		this.role = role;
		//this.userType = userType;
	}


	public User(String prn, String firstName, String lastName, String email, String contactNumber, String password,
			String confirmPassword, boolean active, String role, String userType) {
		super();
		this.prn = prn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.enabled = active;
		this.role = role;
		//this.userType = userType;
	}


	public User(User user) {
		super();
		this.id = user.getId();
		this.prn = user.getPrn();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.contactNumber = user.getContactNumber();
		this.password = user.getPassword();
		this.confirmPassword = user.getConfirmPassword();
		this.enabled = user.isActive();
		this.role = user.getRole();
		//this.userType = user.getUserType();
	}
	
	

	public User(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public boolean isActive() {
		return enabled;
	}


	public void setActive(boolean active) {
		this.enabled = active;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	/*public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}*/

	
	

	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", prn=" + prn + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", contactNumber=" + contactNumber + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", active=" + enabled + ", role=" + role + "]";
	}
	
	
}
