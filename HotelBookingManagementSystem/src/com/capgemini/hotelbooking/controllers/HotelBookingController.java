package com.capgemini.hotelbooking.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.hotelbooking.exceptions.BookingException;
import com.capgemini.hotelbooking.services.IAdminService;
import com.capgemini.hotelbooking.services.ICommonService;
import com.capgemini.hotelbooking.services.ICustomerService;

@Controller
public class HotelBookingController {
	@Resource
	private ICommonService commonService;
	@Resource
	private ICustomerService customerService;
	@Resource
	private IAdminService adminService;
	
	@RequestMapping("/getHomePage.do")
	public ModelAndView getHomePage() throws BookingException{
		System.out.println(commonService.retrieveHotels());
		return new ModelAndView("HomePage");
	}
}
