package com.capgemini.hotelbooking.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ROOMDETAILS")
public class RoomBean {
	
	private int hotelID;
	private int roomID;
	private String roomNumber;
	private String roomType;
	private float perNightRate;
	private char available;
	private String photo;
	private String status;
	
	public RoomBean() {
		super();
	}
	
	public RoomBean(int hotelID, int roomID, String roomNumber,
			String roomType, float perNightRate, char available, String photo,
			String status) {
		super();
		this.hotelID = hotelID;
		this.roomID = roomID;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.perNightRate = perNightRate;
		this.available = available;
		this.photo = photo;
		this.status = status;
	}



	@Column(name="HOTEL_ID")
	public int getHotelID() {
		return hotelID;
	}
	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}
	
	@Id
	@SequenceGenerator(name="room_id_seq",sequenceName="room_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="room_id_seq")
	@Column(name="ROOM_ID")
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	
	@Column(name="ROOM_NO")
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	@Column(name="ROOM_TYPE")
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	@Column(name="PER_NIGHT_RATE")
	public float getPerNightRate() {
		return perNightRate;
	}
	public void setPerNightRate(float perNightRate) {
		this.perNightRate = perNightRate;
	}
	
	@Column(name="availability")
	public char getAvailable() {
		return available;
	}
	public void setAvailable(char availability) {
		this.available = availability;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Room(Hotel ID=" + hotelID + ", Room ID=" + roomID + ", Room number=" + roomNumber + ", Room type=" + roomType
				+ ", rate/night=" + perNightRate + ", availability=" + available + ", Room Status=" + status + ")\n";
	}
}
