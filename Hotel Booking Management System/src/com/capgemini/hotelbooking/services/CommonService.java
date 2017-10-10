package com.capgemini.hotelbooking.services;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.capgemini.hotelbooking.beans.HotelBean;
import com.capgemini.hotelbooking.beans.RoomBean;
import com.capgemini.hotelbooking.beans.UserBean;
import com.capgemini.hotelbooking.daos.ICommonDao;
import com.capgemini.hotelbooking.exceptions.BookingException;

@Service
public class CommonService implements ICommonService {
	@Resource
	private ICommonDao dao;
	
	private static String mobileNumberPattern = "[7-9][0-9]{9}";
	private static String emailPattern = "[A-Z a-z]*[@][A-Z a-z]*[.](com|org|in|co.in)";
	
	static Logger myLogger = Logger.getLogger("myLogger");
	
	public static boolean validateMobileNumber(String mobileNumber){
		boolean flag = false;
		if(mobileNumber.matches(mobileNumberPattern))
		{
			flag = true;
		}
		return flag;
	}
	
	public static boolean validateEmail(String email){
		boolean flag = false;
		if(email.matches(emailPattern))
		{
			flag = true;
		}
		return flag;
	}
	
	@Override
	public UserBean login(String username, String password)
			throws BookingException {
		return dao.login(username, password);
	}

	@Override
	public List<HotelBean> retrieveHotels() throws BookingException {
		return dao.retrieveHotels();
	}

	@Override
	public List<RoomBean> retrieveRooms() throws BookingException {
		return dao.retrieveRooms();
	}

	@Override
	public void registerUser(UserBean userBean) throws BookingException {
		dao.registerUser(userBean);
	}

	@Override
	public List<String> retrieveUserNames() throws BookingException {
		return dao.retrieveUserNames();
	}
}
