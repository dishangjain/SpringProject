package com.capgemini.hotelbooking.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.hotelbooking.beans.HotelBean;
import com.capgemini.hotelbooking.beans.UserBean;
import com.capgemini.hotelbooking.exceptions.BookingException;
import com.capgemini.hotelbooking.services.AdminService;
import com.capgemini.hotelbooking.services.CommonService;
import com.capgemini.hotelbooking.services.CustomerService;

@Controller
public class HotelBookingController {
	@Resource
	private CommonService service;
	@Resource
	private AdminService adminService;
	@Resource
	private CustomerService customerService;
	
	@RequestMapping("/getHomePage.do")
	public ModelAndView getHomePage() {
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("HomePage");
		return mAndV;
		
	}
	
	@RequestMapping("/getLoginPage.do")
	public ModelAndView getLoginPage() {
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("LoginPage");
		return mAndV;
		
		
	}
	
	@RequestMapping("/getSignUpPage.do")
	public ModelAndView getSignUpPage(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("SignUp");
		return mAndV;
	}
	
	@RequestMapping(value="/addUser.do" , method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") UserBean userBean) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		service.registerUser(userBean);
		//int userId=userBean.getUserID();
		mAndV.addObject("userBean", userBean);
		mAndV.addObject("pageHead","You have successfully registered.");
		mAndV.setViewName("Success");
		return mAndV;
		
	}
	
		
	@RequestMapping(value="/getFunctionalities.do", method=RequestMethod.POST)
	public ModelAndView getFunctionalities(@RequestParam("userName") String userName, @RequestParam("password") String password) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		UserBean validUser=null;
		validUser = service.login(userName, password);
		if(validUser==null)
		{
			
			mAndV.setViewName("HomePage");
		}
		else{
			mAndV.addObject("pageHead", userName);
			if("system".equals(userName)){
				mAndV.setViewName("Admin");
			}
			else{
			mAndV.setViewName("Customer");
			}
		}
		return mAndV;
		
	}
	@RequestMapping("/AddNewHotel.do")
	public ModelAndView addNewHotel(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("AddNewHotel");
		return mAndV;

	}
	
	@RequestMapping(value="/AddHotelDetails.do" , method=RequestMethod.POST)
	public ModelAndView addHotelDetails(@ModelAttribute("newHotel") HotelBean hotelBean ) throws BookingException {
		ModelAndView mAndV = new ModelAndView();
		adminService.addHotelDetails(hotelBean);
		mAndV.addObject("HotelBean", hotelBean);
		mAndV.addObject("pageHead","Hotel is registered successfully.");
		mAndV.setViewName("Success");
		return mAndV;
	}
	@RequestMapping("/UpdateExistingHotel.do")
		public ModelAndView updateExistingHotel(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("UpdateExistingHotel");
		return mAndV;
			
	}
	//To be continued
	
	/*@RequestMapping("/UpdateHotelDetails")
	public ModelAndView updateHotelDetails(@RequestParam("hotelID") int hotelID,@RequestParam("attributeOption") String attributeOption,@RequestParam("attributeValue") String attributeValue){
		ModelAndView mAndV = new ModelAndView();
		adminService.updateHotelDetails(hotelID, attributeOption, attributeValue);
		return mAndV;
	}*/
		
		
	
	
	
	
	/*@RequestMapping("/getEmpList.do")
	public ModelAndView getEmpList() throws BookingException{
		List<BookingBean> empList = service.getEmpList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("empList",empList);
		modelAndView.addObject("pageHead", "Employee List");
		
		modelAndView.setViewName("EmpList");
		return modelAndView;
	}
	
	@RequestMapping("/getEmpDetails.do")
	public ModelAndView getEmpDetails(@RequestParam("empNo") int empNo) throws BookingException{
		BookingBean emp = service.getEmpOnId(empNo);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("emp", emp);
		modelAndView.addObject("pageHead", "Employee Details");
		
		modelAndView.setViewName("EmpDetails");
		return modelAndView;
	}
	
	@RequestMapping("/getEntryPage.do")
	public ModelAndView getEntryPage(){
		ModelAndView modelAndView = new ModelAndView("EntryPage");
		BookingBean emp = new BookingBean();
		modelAndView.addObject("employee", emp);
		return modelAndView;
	}
	
	@RequestMapping(value="/submitEmpDetails.do",method=RequestMethod.POST)
	public String submitEmpDetails(@ModelAttribute("employee") BookingBean emp, Model model) throws BookingException{
		service.insertNewEmp(emp);
		
		model.addAttribute("emp", emp);
		model.addAttribute("pageHead", "Successful joining of Employee");
		
		return "SuccEmpJoining";
	}
	
	@RequestMapping("/getUpdateNamePage.do")
	public ModelAndView getUpdatePage() throws BookingException{
		ModelAndView modelAndView = new ModelAndView("UpdateNamePage");
		List<Integer> idList = service.getEmpNoList();
		
		modelAndView.addObject("idList", idList);
		modelAndView.addObject("pageHead", "Update name of an employee");
		return modelAndView;
	}
	
	@RequestMapping("/submitNewEmpName.do")
	public String submitNewEmpName(@RequestParam("empNo") int empNo,@RequestParam("newName") String empName, Model model) throws BookingException{
		service.updateEmpName(empNo, empName);
		BookingBean emp = service.getEmpOnId(empNo);
		model.addAttribute("emp", emp);
		model.addAttribute("pageHead", "Successfully updated name");
		
		return "SuccEmpUpdate";
	}*/
}
