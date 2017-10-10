package com.capgemini.hotelbooking.services;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.hotelbooking.beans.BookingBean;
import com.capgemini.hotelbooking.beans.HotelBean;
import com.capgemini.hotelbooking.beans.RoomBean;
import com.capgemini.hotelbooking.beans.UserBean;
import com.capgemini.hotelbooking.exceptions.BookingException;

public interface IAdminService {
	public void addHotelDetails(HotelBean hotelBean) throws BookingException;
	public int updateHotelDetails(int hotelID,String attributeName,String attributeValue) throws BookingException;
	public void deleteHotelDetails(int hotelID) throws BookingException;
	public void addRoomDetails(RoomBean roomBean) throws BookingException;
	public int updateRoomDetails(int roomID,String attributeName,String attributeValue) throws BookingException;
	public void deleteRoomDetails(int roomID) throws BookingException;
	public List<BookingBean> viewBookingsOfHotel(int hotelID) throws BookingException;
	public List<BookingBean> viewBookingsOfDate(LocalDate date) throws BookingException;
	List<UserBean> viewGuestList(int hotelID) throws BookingException;
}