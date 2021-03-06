package com.capgemini.hotelbooking.services;

import java.util.Date;
import java.util.List;

import com.capgemini.hotelbooking.beans.BookingBean;
import com.capgemini.hotelbooking.beans.RoomBean;
import com.capgemini.hotelbooking.exceptions.BookingException;

public interface ICustomerService {
	public void bookRoom(BookingBean bookingBean) throws BookingException;
	public List<RoomBean> searchAvailableRooms(String city,Date bookedFrom,Date bookedTo) throws BookingException;
	public List<List<Object>> viewBookingStatus(int userId) throws BookingException;
	public List<Integer> getBookingIDs(int userId) throws BookingException;
}