package com.capgemini.hotelbooking.services;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.capgemini.hotelbooking.daos.EmpDao;
import com.capgemini.hotelbooking.dtos.Employee;
import com.capgemini.hotelbooking.exceptions.EmployeeException;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
	@Resource
	private EmpDao dao;
	
	@Override
	public List<Employee> getEmpList() throws EmployeeException {
		return dao.getEmpList();
	}

	@Override
	public Employee getEmpOnId(int empNo) throws EmployeeException {
		return dao.getEmpOnId(empNo);
	}

	@Override
	public void insertNewEmp(Employee emp) throws EmployeeException {
		dao.insertNewEmp(emp);
	}

	@Override
	public void updateEmpName(int empNo, String empNm) throws EmployeeException {
		dao.updateEmpName(empNo, empNm);
	}

	@Override
	public List<Integer> getEmpNoList() throws EmployeeException {
		return dao.getEmpNoList();
	}

}
