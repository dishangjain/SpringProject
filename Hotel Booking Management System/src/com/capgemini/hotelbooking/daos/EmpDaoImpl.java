package com.capgemini.hotelbooking.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelbooking.beans.BookingBean;
import com.capgemini.hotelbooking.exceptions.BookingException;

@Repository
public class EmpDaoImpl implements EmpDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<BookingBean> getEmpList() throws BookingException {
		String query = "SELECT e FROM Employee e";
		TypedQuery<BookingBean> qry = entityManager.createQuery(query, BookingBean.class);
		List<BookingBean> empList = qry.getResultList();
		return empList;
	}
	
	@Override
	public List<Integer> getEmpNoList() throws BookingException {
		String query = "SELECT e.empNo FROM Employee e";
		TypedQuery<Integer> qry = entityManager.createQuery(query, Integer.class);
		List<Integer> empNoList = qry.getResultList();
		return empNoList;
	}

	@Override
	public BookingBean getEmpOnId(int empNo) throws BookingException {
		BookingBean emp = entityManager.find(BookingBean.class, empNo);
		return emp;
	}

	@Override
	public void insertNewEmp(BookingBean emp) throws BookingException {
		entityManager.persist(emp);
	}
	
	@Override
	public void updateEmpName(int empNo, String empNm){
		BookingBean emp = entityManager.find(BookingBean.class, empNo);
		emp.setBookingID(empNo);
	}
}
