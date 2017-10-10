package com.capgemini.hotelbooking.services;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.capgemini.hotelbooking.beans.BookingBean;
import com.capgemini.hotelbooking.daos.EmpDao;
import com.capgemini.hotelbooking.exceptions.BookingException;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
	@Resource
	private EmpDao dao;
	
	@Override
	public List<BookingBean> getEmpList() throws BookingException {
		return dao.getEmpList();
	}

	@Override
	public BookingBean getEmpOnId(int empNo) throws BookingException {
		return dao.getEmpOnId(empNo);
	}

	@Override
	public void insertNewEmp(BookingBean emp) throws BookingException {
		dao.insertNewEmp(emp);
	}

	@Override
	public void updateEmpName(int empNo, String empNm) throws BookingException {
		dao.updateEmpName(empNo, empNm);
	}

	@Override
	public List<Integer> getEmpNoList() throws BookingException {
		return dao.getEmpNoList();
	}

}
