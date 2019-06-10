package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="room_data")
public class Room {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="room_id")
	private Integer id;
	

	@Column(name="coord1_lat")
	private double coord1Lat;
	@Column(name="coord1_long")
	private double coord1Long;

	@Column(name="coord2_lat")
	private double coord2Lat;
	@Column(name="coord2_long")
	private double coord2Long;

	@Column(name="coord3_lat")
	private double coord3Lat;
	@Column(name="coord3_long")
	private double coord3Long;

	@Column(name="coord4_lat")
	private double coord4Lat;
	@Column(name="coord4_long")
	private double coord4Long;
	
	@Column(name="coord5_lat")
	private double coord5Lat;
	@Column(name="coord5_long")
	private double coord5Long;

	@Column(name="coord6_lat")
	private double coord6Lat;
	@Column(name="coord6_long")
	private double coord6Long;
	
	@Column(name="course_id")
	private int courseId;
	
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Room(Integer id) {
		super();
		this.id = id;
	}


	public Room(Integer id, double coord1Lat, double coord1Long, double coord2Lat, double coord2Long, double coord3Lat,
			double coord3Long, double coord4Lat, double coord4Long, double coord5Lat, double coord5Long,
			double coord6Lat, double coord6Long) {
		super();
		this.id = id;
		this.coord1Lat = coord1Lat;
		this.coord1Long = coord1Long;
		this.coord2Lat = coord2Lat;
		this.coord2Long = coord2Long;
		this.coord3Lat = coord3Lat;
		this.coord3Long = coord3Long;
		this.coord4Lat = coord4Lat;
		this.coord4Long = coord4Long;
		this.coord5Lat = coord5Lat;
		this.coord5Long = coord5Long;
		this.coord6Lat = coord6Lat;
		this.coord6Long = coord6Long;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getCoord1Lat() {
		return coord1Lat;
	}

	public void setCoord1Lat(double coord1Lat) {
		this.coord1Lat = coord1Lat;
	}

	public double getCoord1Long() {
		return coord1Long;
	}

	public void setCoord1Long(double coord1Long) {
		this.coord1Long = coord1Long;
	}

	public double getCoord2Lat() {
		return coord2Lat;
	}

	public void setCoord2Lat(double coord2Lat) {
		this.coord2Lat = coord2Lat;
	}

	public double getCoord2Long() {
		return coord2Long;
	}

	public void setCoord2Long(double coord2Long) {
		this.coord2Long = coord2Long;
	}

	public double getCoord3Lat() {
		return coord3Lat;
	}

	public void setCoord3Lat(double coord3Lat) {
		this.coord3Lat = coord3Lat;
	}

	public double getCoord3Long() {
		return coord3Long;
	}

	public void setCoord3Long(double coord3Long) {
		this.coord3Long = coord3Long;
	}

	public double getCoord4Lat() {
		return coord4Lat;
	}

	public void setCoord4Lat(double coord4Lat) {
		this.coord4Lat = coord4Lat;
	}

	public double getCoord4Long() {
		return coord4Long;
	}

	public void setCoord4Long(double coord4Long) {
		this.coord4Long = coord4Long;
	}

	public double getCoord5Lat() {
		return coord5Lat;
	}

	public void setCoord5Lat(double coord5Lat) {
		this.coord5Lat = coord5Lat;
	}

	public double getCoord5Long() {
		return coord5Long;
	}

	public void setCoord5Long(double coord5Long) {
		this.coord5Long = coord5Long;
	}

	public double getCoord6Lat() {
		return coord6Lat;
	}

	public void setCoord6Lat(double coord6Lat) {
		this.coord6Lat = coord6Lat;
	}

	public double getCoord6Long() {
		return coord6Long;
	}

	public void setCoord6Long(double coord6Long) {
		this.coord6Long = coord6Long;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	


}
