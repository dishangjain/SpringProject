package com.capgemini.hotelbooking.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.capgemini.hotelbooking.beans.BookingBean;
import com.capgemini.hotelbooking.beans.HotelBean;
import com.capgemini.hotelbooking.beans.RoomBean;
import com.capgemini.hotelbooking.beans.UserBean;
import com.capgemini.hotelbooking.exceptions.BookingException;

public class AdminDao implements IAdminDao {
	static Logger myLogger = Logger.getLogger("myLogger");
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addRoomDetails(RoomBean roomBean) throws BookingException {
		myLogger.info("Execution in addRoomDetails()");
		entityManager.persist(roomBean);
		myLogger.info("New Entry -> Room ID : "+ roomBean.getRoomID()
							+ "\nHotel ID : " + roomBean.getHotelID()
							+ "\nRoom Number: " + roomBean.getRoomNumber()
							+ "\nRoom Type : " + roomBean.getRoomType()
							+ "\nPer Night Rate : " + roomBean.getPerNightRate()
							+ "\nAvailability : " + roomBean.isAvailable()
							+ "\nPhoto : " + roomBean.getPhoto());
	}

	@Override
	public void addHotelDetails(HotelBean hotelBean) throws BookingException {
		myLogger.info("Execution in addHotelDetails()");
		entityManager.persist(hotelBean);
		myLogger.info("New Entry -> Hotel ID : "+ hotelBean.getHotelID()
							+ "\nCity : " + hotelBean.getCity()
							+ "\nHotel Name : " + hotelBean.getHotelName()
							+ "\nAddress : " + hotelBean.getAddress()
							+ "\nDescription : " + hotelBean.getDescription()
							+ "\nAverage Rate per Night : " + hotelBean.getAvgRatePerNight()
							+ "\nPhone Number 1 : " + hotelBean.getPhoneNumber1()
							+ "\nPhone Number 2 : " + hotelBean.getPhoneNumber2()
							+ "\nRating : " + hotelBean.getRating()
							+ "\nFax : " + hotelBean.getFax());
	}

	@Override
	public int updateHotelDetails(int hotelID, String attributeName, String attributeValue) 
			throws BookingException {
		myLogger.info("Execution in updateHotelDetails()");
		String query = "UPDATE hotels SET " + attributeName + "=? WHERE HOTEL_ID=?";
		int recsAffected = 0;
		
		try(
			PreparedStatement preparedStatement = connect.prepareStatement(query);
		){
			preparedStatement.setString(1, attributeValue);
			preparedStatement.setInt(2, hotelID);
						
			myLogger.info("Query Execution : " + query);
			recsAffected = preparedStatement.executeUpdate();
			if(recsAffected > 0){
				myLogger.info("Hotel Table Updated."
							+ "\nHotel ID : " + hotelID
							+ "\nColumn Name : " + attributeName
							+ "Column Value : " + attributeValue);
			}
			else{
				myLogger.error("System Error");
				throw new BookingException("System Error. Try Again Later.");
				
			}
			
		} catch (SQLException e) {
			myLogger.error("Exception from updateHotelDetails()", e);
			throw new BookingException("Problem in updating data.", e);
		}
		return recsAffected;
	}

	@Override
	public int updateRoomDetails(int roomID, String attributeName,
			String attributeValue) throws BookingException {
		myLogger.info("Execution in updateRoomDetails()");
		
		String query = "UPDATE roomdetails SET " +attributeName+"=? WHERE room_ID=?";
		int recsAffected = 0;
		
		try(
			PreparedStatement preparedStatement = connect.prepareStatement(query);
		){
			
			preparedStatement.setString(1, attributeValue);
			preparedStatement.setInt(2, roomID);
						
			myLogger.info("Query Execution : " + query);
			recsAffected = preparedStatement.executeUpdate();
			
			if(recsAffected > 0){
				myLogger.info("Room Table Updated."
						+ "\nRoom ID : " + roomID
						+ "\nColumn Name : " + attributeName
						+ "Column Value : " + attributeValue);
			}
			else{
				myLogger.error("System Error");
				throw new BookingException("System Error. Try Again Later.");
				
			}
			
		} catch (SQLException e) {
			myLogger.error("Exception from updateRoomDetails()", e);
			throw new BookingException("Problem in updating data.", e);
		}
		return recsAffected;
	}

	@Override
	public List<BookingBean> viewBookingsOfHotel(int hotelID) throws BookingException {
		List<BookingBean> bookingList = new ArrayList<BookingBean>();
		myLogger.info("Execution in viewBookingsOfHotel()");
		String query = "SELECT * FROM bookingdetails b WHERE b.room_id in (SELECT r.room_id from roomdetails r "
				+ "WHERE r.hotel_id = ?)";
		ResultSet resultSet = null;
		
		try(
			PreparedStatement preparedStatement = connect.prepareStatement(query);
		){
			preparedStatement.setInt(1, hotelID);
			myLogger.info("Query Execution : " + query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				int bookingID = Integer.parseInt(resultSet.getString("BOOKING_ID"));
				int userID = resultSet.getInt("USER_ID");
				int roomID = resultSet.getInt("ROOM_ID");
				int numAdults = resultSet.getInt("NO_OF_ADULTS");
				int numChildren = resultSet.getInt("NO_OF_CHILDREN");
				float amount = resultSet.getFloat("AMOUNT");
				LocalDate bookedFrom = resultSet.getDate("BOOKED_FROM").toLocalDate();
				LocalDate bookedTo = resultSet.getDate("BOOKED_TO").toLocalDate();
				
				bookingList.add(new BookingBean(bookingID, roomID, userID, numAdults, numChildren, amount, bookedFrom, bookedTo));
			}
			
		} catch (SQLException e) {
			myLogger.error("Exception from viewBookingsOfHotel()", e);
			throw new BookingException("Problem in retrieving data.", e);
		}
		return bookingList;
	}

	@Override
	public List<BookingBean> viewBookingsOfDate(LocalDate localDate) throws BookingException {
		List<BookingBean> bookingList = new ArrayList<BookingBean>();
		myLogger.info("Execution in getBookingsOfDate()");
		String query = "SELECT * FROM bookingdetails WHERE ? BETWEEN BOOKED_FROM AND BOOKED_TO";
		ResultSet resultSet = null;
		
		try(
			PreparedStatement preparedStatement = connect.prepareStatement(query);
		){
			Date sqlDate = Date.valueOf(localDate);
			preparedStatement.setDate(1, sqlDate);
						
			myLogger.info("Query Execution : " + query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				int bookingID = resultSet.getInt("BOOKING_ID");
				int userID = resultSet.getInt("USER_ID");
				int roomID = resultSet.getInt("ROOM_ID");
				int numAdults = resultSet.getInt("NO_OF_ADULTS");
				int numChildren = resultSet.getInt("NO_OF_CHILDREN");
				float amount = resultSet.getFloat("AMOUNT");
				LocalDate bookedFrom = resultSet.getDate("BOOKED_FROM").toLocalDate();
				LocalDate bookedTo = resultSet.getDate("BOOKED_TO").toLocalDate();
				
				bookingList.add(new BookingBean(bookingID, roomID, userID, numAdults, numChildren, amount, bookedFrom, bookedTo));
			}
			
		} catch (SQLException e) {
			myLogger.error("Exception from getBookingsOfDate()", e);
			throw new BookingException("Problem in retrieving data.", e);
		}
		return bookingList;
	}

	@Override
	public void deleteHotelDetails(int hotelID) throws BookingException {
		//TODO Don't remove the column, set inactive
		myLogger.info("Execution in deleteHotelDetails()");
		HotelBean hotelBean = entityManager.find(HotelBean.class, hotelID);
		entityManager.remove(hotelBean);
		myLogger.info("1 row deleted from hotels."
				+ "\nHotel ID of deleted row : " + hotelID);
	}

	@Override
	public void deleteRoomDetails(int roomID) throws BookingException {
		//TODO Don't remove the column, set inactive
		myLogger.info("Execution in deletRoomDetails()");
		RoomBean roomBean = entityManager.find(RoomBean.class, roomID);
		entityManager.remove(roomBean);
		myLogger.info("1 row deleted from roomdetails."
						+ "\nRoom ID of deleted row : " + roomID);
	}

	@Override
	public List<UserBean> viewGuestList(int hotelID) throws BookingException {
		List<UserBean> bookingList = new ArrayList<UserBean>();
		myLogger.info("Execution in viewGuestList()");
		String query = "SELECT * FROM users u WHERE u.user_id in (SELECT b.user_id FROM bookingdetails b "
				+ "WHERE b.room_id in (SELECT r.room_id FROM roomdetails r WHERE r.hotel_id = ?))";
		ResultSet resultSet = null;
		
		try(
			PreparedStatement preparedStatement = connect.prepareStatement(query);
		){
			preparedStatement.setInt(1, hotelID);
						
			myLogger.info("Query Execution : " + query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				String userName = resultSet.getString("USER_NAME");
				int userID = resultSet.getInt("USER_ID");
				String role = resultSet.getString("ROLE");
				String password = "";
				String mobileNumber = resultSet.getString("MOBILE_NO");
				String address = resultSet.getString("ADDRESS");
				String email = resultSet.getString("EMAIL");
				String phoneNumber = resultSet.getString("PHONE");
				
				bookingList.add(new UserBean(userID, password, role, userName, mobileNumber, address, email, phoneNumber));
			}
			
		} catch (SQLException e) {
			myLogger.error("Exception from viewGuestList()", e);
			throw new BookingException("Problem in retrieving data.", e);
		}
		return bookingList;
	}
}
