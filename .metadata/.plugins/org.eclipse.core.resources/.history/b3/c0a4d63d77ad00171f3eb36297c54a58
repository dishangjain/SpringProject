package com.capgemini.hotelbooking.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.hotelbooking.dtos.Employee;
import com.capgemini.hotelbooking.exceptions.EmployeeException;
import com.capgemini.hotelbooking.services.EmpService;

@Controller
public class EmpCrudController {
	@Resource
	private EmpService service;
	
	@RequestMapping("/getHomePage.do")
	public ModelAndView getHomePage(){
		ModelAndView modelAndView = new ModelAndView("HomePage");
		return modelAndView;
	}
	
	@RequestMapping("/getEmpList.do")
	public ModelAndView getEmpList() throws EmployeeException{
		List<Employee> empList = service.getEmpList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("empList",empList);
		modelAndView.addObject("pageHead", "Employee List");
		
		modelAndView.setViewName("EmpList");
		return modelAndView;
	}
	
	@RequestMapping("/getEmpDetails.do")
	public ModelAndView getEmpDetails(@RequestParam("empNo") int empNo) throws EmployeeException{
		Employee emp = service.getEmpOnId(empNo);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("emp", emp);
		modelAndView.addObject("pageHead", "Employee Details");
		
		modelAndView.setViewName("EmpDetails");
		return modelAndView;
	}
	
	@RequestMapping("/getEntryPage.do")
	public ModelAndView getEntryPage(){
		ModelAndView modelAndView = new ModelAndView("EntryPage");
		Employee emp = new Employee();
		modelAndView.addObject("employee", emp);
		return modelAndView;
	}
	
	@RequestMapping(value="/submitEmpDetails.do",method=RequestMethod.POST)
	public String submitEmpDetails(@ModelAttribute("employee") Employee emp, Model model) throws EmployeeException{
		service.insertNewEmp(emp);
		
		model.addAttribute("emp", emp);
		model.addAttribute("pageHead", "Successful joining of Employee");
		
		return "SuccEmpJoining";
	}
	
	@RequestMapping("/getUpdateNamePage.do")
	public ModelAndView getUpdatePage() throws EmployeeException{
		ModelAndView modelAndView = new ModelAndView("UpdateNamePage");
		List<Integer> idList = service.getEmpNoList();
		
		modelAndView.addObject("idList", idList);
		modelAndView.addObject("pageHead", "Update name of an employee");
		return modelAndView;
	}
	
	@RequestMapping("/submitNewEmpName.do")
	public String submitNewEmpName(@RequestParam("empNo") int empNo,@RequestParam("newName") String empName, Model model) throws EmployeeException{
		service.updateEmpName(empNo, empName);
		Employee emp = service.getEmpOnId(empNo);
		model.addAttribute("emp", emp);
		model.addAttribute("pageHead", "Successfully updated name");
		
		return "SuccEmpUpdate";
	}
}
