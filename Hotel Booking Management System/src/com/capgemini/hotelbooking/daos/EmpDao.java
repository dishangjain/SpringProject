package com.capgemini.hotelbooking.daos;

import java.util.List;

import com.capgemini.hotelbooking.beans.BookingBean;
import com.capgemini.hotelbooking.exceptions.BookingException;

public interface EmpDao {
	public List<BookingBean> getEmpList() throws BookingException;
	public BookingBean getEmpOnId(int empNo) throws BookingException;
	public void insertNewEmp(BookingBean emp) throws BookingException;
	public void updateEmpName(int empNo, String empNm) throws BookingException;
	public List<Integer> getEmpNoList() throws BookingException;
}
