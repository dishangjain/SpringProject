package com.capgemini.hotelbooking.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HOTELS")
public class HotelBean {
	private int hotelID;
	private String city;
	private String hotelName;
	private String address;
	private String description;
	private float avgRatePerNight;
	private String phoneNumber1;
	private String phoneNumber2;
	private String rating;
	private String email;
	private String fax;
	private String status;
	
	public HotelBean() {
		super();
	}
	
	public HotelBean(int hotelID, String city, String hotelName,
			String address, String description, float avgRatePerNight,
			String phoneNumber1, String phoneNumber2, String rating,
			String email, String fax, String status) {
		super();
		this.hotelID = hotelID;
		this.city = city;
		this.hotelName = hotelName;
		this.address = address;
		this.description = description;
		this.avgRatePerNight = avgRatePerNight;
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;
		this.rating = rating;
		this.email = email;
		this.fax = fax;
		this.status = status;
	}

	@Id
	@SequenceGenerator(name="hotel_id_seq",sequenceName="hotel_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hotel_id_seq")
	@Column(name="HOTEL_ID")
	public int getHotelID() {
		return hotelID;
	}
	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name="HOTEL_NAME")
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="AVG_RATE_PER_NIGHT")
	public float getAvgRatePerNight() {
		return avgRatePerNight;
	}
	public void setAvgRatePerNight(float avgRatePerNight) {
		this.avgRatePerNight = avgRatePerNight;
	}
	
	@Column(name="phone_no1")
	public String getPhoneNumber1() {
		return phoneNumber1;
	}
	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}
	
	@Column(name="phone_no2")
	public String getPhoneNumber2() {
		return phoneNumber2;
	}
	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}
	
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Hotel(Hotel ID=" + hotelID + ", City=" + city
				+ ", Hotel name=" + hotelName + ", Address=" + address
				+ ", Description=" + description + ", Average cost of a room="
				+ avgRatePerNight + ", Phone number 1=" + phoneNumber1
				+ ", Phone number 2=" + phoneNumber2 + ", Rating=" + rating
				+ ", Email=" + email + ", Fax=" + fax + ", Affliation Status=" + status + ")\n";
	}
	
}
