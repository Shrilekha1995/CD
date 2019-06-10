package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emails")
public class Communication {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comm_id")
	private Integer id;
	
	@Column(name="src_id")
	private String sourceId;
	@Column(name="dest_id")
	private String destinationId;
	@Column(name="message")
	private String message;
	
	public Communication() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Communication(String sourceId, String destinationId, String message) {
		super();
		this.sourceId = sourceId;
		this.destinationId = destinationId;
		this.message = message;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
