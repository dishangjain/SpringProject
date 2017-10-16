package com.capgemini.hotelbooking.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BOOKINGDETAILS")
public class BookingBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int bookingID;
	private int roomID;
	private int userID;
	private int numAdults;
	private int numChildren;
	private float amount;
	private Date bookedFrom;
	private Date bookedTo;
	private String status;
	private String firstGuestName;
	private String secondGuestName;

	public BookingBean(int bookingID, int roomID, int userID, int numAdults,
			int numChildren, float amount, Date bookedFrom, Date bookedTo,
			String status, String firstGuestName, String secondGuestName) {
		super();
		this.bookingID = bookingID;
		this.roomID = roomID;
		this.userID = userID;
		this.numAdults = numAdults;
		this.numChildren = numChildren;
		this.amount = amount;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.status = status;
		this.firstGuestName = firstGuestName;
		this.secondGuestName = secondGuestName;
	}

	public BookingBean() {
		super();
	}
	
	@Id
	@SequenceGenerator(name="booking_id_seq",sequenceName="booking_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="booking_id_seq")
	@Column(name="BOOKING_ID")
	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	
	@Column(name="ROOM_ID")
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	
	@Column(name="USER_ID")
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	@Column(name="NO_OF_ADULTS")
	public int getNumAdults() {
		return numAdults;
	}
	public void setNumAdults(int numAdults) {
		this.numAdults = numAdults;
	}
	
	@Column(name="NO_OF_CHILDREN")
	public int getNumChildren() {
		return numChildren;
	}
	public void setNumChildren(int numChildren) {
		this.numChildren = numChildren;
	}
	
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="BOOKED_FROM")
	public Date getBookedFrom() {
		return bookedFrom;
	}
	public void setBookedFrom(Date bookedFrom) {
		this.bookedFrom = bookedFrom;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="BOOKED_TO")
	public Date getBookedTo() {
		return bookedTo;
	}
	public void setBookedTo(Date bookedTo) {
		this.bookedTo = bookedTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getFirstGuestName() {
		return firstGuestName;
	}

	public void setFirstGuestName(String firstGuestName) {
		this.firstGuestName = firstGuestName;
	}

	public String getSecondGuestName() {
		return secondGuestName;
	}

	public void setSecondGuestName(String secondGuestName) {
		this.secondGuestName = secondGuestName;
	}


	@Override
	public String toString() {
		return "Booking(Booking Reference Number=" + bookingID + ", RoomID=" + roomID
				+ ", UserID=" + userID + ", Number of adults=" + numAdults
				+ ", Number of children=" + numChildren + ", Total amount per room=" + amount
				+ ", Booking From=" + bookedFrom + ", Booking Upto=" + bookedTo + ", Booking Status=" + status + ", First Guest Name=" + firstGuestName + ", Second Guest Name=" + secondGuestName + ")\n";
	}
	
}
