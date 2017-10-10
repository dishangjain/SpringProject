package com.capgemini.hotelbooking.daos;

import java.util.Date;
import java.util.List;

import com.capgemini.hotelbooking.beans.BookingBean;
import com.capgemini.hotelbooking.beans.HotelBean;
import com.capgemini.hotelbooking.beans.RoomBean;
import com.capgemini.hotelbooking.beans.UserBean;
import com.capgemini.hotelbooking.exceptions.BookingException;

public interface IAdminDao {
	public void addHotelDetails(HotelBean hotelBean) throws BookingException;
	public void updateHotelDetails(int hotelID,int attributeOption,String attributeValue) throws BookingException;
	public void deleteHotelDetails(int hotelID) throws BookingException;
	public void addRoomDetails(RoomBean roomBean) throws BookingException;
	public void updateRoomDetails(int roomID,int attributeOption,String attributeValue) throws BookingException;
	public void deleteRoomDetails(int roomID) throws BookingException;
	public List<BookingBean> viewBookingsOfHotel(int hotelID) throws BookingException;
	public List<BookingBean> viewBookingsOfDate(Date date) throws BookingException;
	List<UserBean> viewGuestList(int hotelID) throws BookingException;
}
