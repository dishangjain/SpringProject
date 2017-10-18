package com.capgemini.hotelbooking.daos;

import java.util.List;

import com.capgemini.hotelbooking.beans.FeedBackBean;
import com.capgemini.hotelbooking.beans.HotelBean;
import com.capgemini.hotelbooking.beans.RoomBean;
import com.capgemini.hotelbooking.beans.UserBean;
import com.capgemini.hotelbooking.exceptions.BookingException;

public interface ICommonDao {
	public void registerUser(UserBean userBean) throws BookingException;
	public UserBean login(String username, String password) throws BookingException;
	public List<HotelBean> retrieveHotels() throws BookingException;
	public List<RoomBean> retrieveRooms() throws BookingException;
	public List<String> retrieveUserNames() throws BookingException;
	public void cancelBooking(int bookingId) throws BookingException;
	public void resetPassword(int userId, String newPassword) throws BookingException;
	public void storeFeedback(FeedBackBean feedBackBean) throws BookingException;
}
