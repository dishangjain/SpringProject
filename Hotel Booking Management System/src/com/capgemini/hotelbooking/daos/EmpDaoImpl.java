package com.capgemini.hotelbooking.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelbooking.dtos.Employee;
import com.capgemini.hotelbooking.exceptions.EmployeeException;

@Repository
public class EmpDaoImpl implements EmpDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Employee> getEmpList() throws EmployeeException {
		String query = "SELECT e FROM Employee e";
		TypedQuery<Employee> qry = entityManager.createQuery(query, Employee.class);
		List<Employee> empList = qry.getResultList();
		return empList;
	}
	
	@Override
	public List<Integer> getEmpNoList() throws EmployeeException {
		String query = "SELECT e.empNo FROM Employee e";
		TypedQuery<Integer> qry = entityManager.createQuery(query, Integer.class);
		List<Integer> empNoList = qry.getResultList();
		return empNoList;
	}

	@Override
	public Employee getEmpOnId(int empNo) throws EmployeeException {
		Employee emp = entityManager.find(Employee.class, empNo);
		return emp;
	}

	@Override
	public void insertNewEmp(Employee emp) throws EmployeeException {
		entityManager.persist(emp);
	}
	
	@Override
	public void updateEmpName(int empNo, String empNm){
		Employee emp = entityManager.find(Employee.class, empNo);
		emp.setEmpNm(empNm);
	}
}
