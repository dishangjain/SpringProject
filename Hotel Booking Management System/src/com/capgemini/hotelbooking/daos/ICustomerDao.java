package com.capgemini.hotelbooking.daos;

import java.util.List;

import com.capgemini.hotelbooking.beans.BookingBean;
import com.capgemini.hotelbooking.beans.RoomBean;
import com.capgemini.hotelbooking.exceptions.BookingException;

public interface ICustomerDao{
	public void bookRoom(BookingBean bookingBean) throws BookingException;
	public List<List<Object>> viewBookingStatus(int bookingId,int userId) throws BookingException;
	public List<RoomBean> searchAvailableRooms(String city) throws BookingException;
	public List<Integer> getBookingIDs(int userId) throws BookingException;
}
