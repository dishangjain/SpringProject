package com.capgemini.hotelbooking.daos;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.capgemini.hotelbooking.beans.BookingBean;
import com.capgemini.hotelbooking.beans.HotelBean;
import com.capgemini.hotelbooking.beans.RoomBean;
import com.capgemini.hotelbooking.exceptions.BookingException;

@Repository
public class CustomerDao implements ICustomerDao {
	static Logger myLogger = Logger.getLogger("myLogger");

	@PersistenceContext
	private EntityManager entityManager;
	
	private void updateAvailabililty(int roomID){
		myLogger.info("Execution in updateAvailability()");
		RoomBean roomBean = entityManager.find(RoomBean.class, roomID);
		roomBean.setAvailable('F');

		myLogger.info("Room Table Updated."
				+ "\nRoom ID : " + roomID
				+ "availability : " + 'F');
	}

	@Override
	public void bookRoom(BookingBean bookingBean) throws BookingException {
		myLogger.info("Execution in bookRoom()");
		entityManager.persist(bookingBean);
		myLogger.info("New Entry -> Booking ID : "+ bookingBean.getBookingID()
					+ "\nRoom ID : " + bookingBean.getRoomID()
					+ "\nUser ID : " + bookingBean.getUserID()
					+ "\nBooked From Date : " + bookingBean.getBookedFrom()
					+ "\nBooked To Date : " + bookingBean.getBookedTo()
					+ "\nNumber of adults : " + bookingBean.getNumAdults()
					+ "\nNumber of children : " + bookingBean.getNumChildren()
					+ "\nAmount : " + bookingBean.getAmount());
				updateAvailabililty(bookingBean.getRoomID());
	}

	@Override  
	public List<List<Object>> viewBookingStatus(int userId) throws BookingException {
		List<BookingBean> bookingList = new ArrayList<BookingBean>();
		myLogger.info("Execution in viewBookingStatus()");
		String query = "SELECT b FROM BookingBean b WHERE b.userID = :userId ";
		TypedQuery<BookingBean> qry = entityManager.createQuery(query, BookingBean.class);
		qry.setParameter("userId", userId);
		bookingList = qry.getResultList();
		
		List<List<Object>> statusList = new ArrayList<List<Object>>();
		for(BookingBean bookingBean : bookingList){
			List<Object> status = new ArrayList<Object>();
			int roomID = bookingBean.getRoomID();
			RoomBean roomBean = entityManager.find(RoomBean.class, roomID);
			int hotelID = roomBean.getHotelID();
			HotelBean hotelBean = entityManager.find(HotelBean.class, hotelID);
			status.add(bookingBean);
			status.add(roomBean);
			status.add(hotelBean);
			statusList.add(status);
		}
		return statusList;
	}

	@Override
	public List<RoomBean> searchAvailableRooms(String city) throws BookingException {
		List<RoomBean> roomList = new ArrayList<RoomBean>();
		myLogger.info("Execution in searchAvailableRooms()");
		String query = "SELECT r FROM RoomBean r where r.available='T' and hotelID in (select h.hotelID from HotelBean where LOWER(city) = :city) ";
		TypedQuery<RoomBean> qry = entityManager.createQuery(query, RoomBean.class);
		qry.setParameter("city", city);
		roomList = qry.getResultList();
		return roomList;
	}

	@Override
	public List<Integer> getBookingIDs(int userId) throws BookingException {
		List<Integer> bookingIdList = new ArrayList<Integer>();
		String query = "SELECT b.BookingID FROM BookingBean b where userID=:userId";
		TypedQuery<Integer> qry = entityManager.createQuery(query, Integer.class);
		qry.setParameter("userId", userId);
		bookingIdList = qry.getResultList();
		return bookingIdList;
	}

}
