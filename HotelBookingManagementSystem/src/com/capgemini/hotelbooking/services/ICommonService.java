package com.capgemini.hotelbooking.services;

import java.util.List;

import com.capgemini.hotelbooking.beans.FeedBackBean;
import com.capgemini.hotelbooking.beans.HotelBean;
import com.capgemini.hotelbooking.beans.RoomBean;
import com.capgemini.hotelbooking.beans.UserBean;
import com.capgemini.hotelbooking.exceptions.BookingException;

public interface ICommonService {
	public void registerUser(UserBean userBean) throws BookingException;
	public UserBean login(String username, String password) throws BookingException;
	List<HotelBean> retrieveHotels() throws BookingException;
	List<RoomBean> retrieveRooms() throws BookingException;
	List<String> retrieveUserNames() throws BookingException;
	void storeFeedback(FeedBackBean feedBackBean) throws BookingException;
}
