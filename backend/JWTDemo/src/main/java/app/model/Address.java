package app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private Integer id;
	@Column(name="address_line_one")
	private String addressLineOne;
	@Column(name="address_line_two")
	private String addressLineTwo;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String country;
	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="user_id")
	private Integer userId;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Address(Integer id, String addressLineOne, String addressLineTwo, String city, String state, String country,
			String postalCode) {
		super();
		this.id = id;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
	}


	public Address(String addressLineOne, String addressLineTwo, String city, String state, String country,
			String postalCode) {
		super();
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
	}


	public Address(Integer id, String addressLineOne, String addressLineTwo, String city, String state, String country,
			String postalCode, Integer userId) {
		super();
		this.id = id;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.userId = userId;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAddressLineOne() {
		return addressLineOne;
	}


	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}


	public String getAddressLineTwo() {
		return addressLineTwo;
	}


	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode + "]";
	}
	
	
	
}
