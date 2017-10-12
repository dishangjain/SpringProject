package com.capgemini.hotelbooking.daos;

import java.util.List;

import com.capgemini.hotelbooking.beans.HotelBean;
import com.capgemini.hotelbooking.beans.RoomBean;
import com.capgemini.hotelbooking.beans.UserBean;
import com.capgemini.hotelbooking.exceptions.BookingException;

public interface ICommonDao {
	public void registerUser(UserBean userBean) throws BookingException;
	public UserBean login(String username, String password) throws BookingException;
	List<HotelBean> retrieveHotels() throws BookingException;
	List<RoomBean> retrieveRooms() throws BookingException;
	public List<String> retrieveUserNames() throws BookingException;
}
