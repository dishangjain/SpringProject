package com.capgemini.hotelbooking.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.hotelbooking.beans.BookingBean;
import com.capgemini.hotelbooking.beans.HotelBean;
import com.capgemini.hotelbooking.beans.RoomBean;
import com.capgemini.hotelbooking.beans.UserBean;
import com.capgemini.hotelbooking.exceptions.BookingException;
import com.capgemini.hotelbooking.services.IAdminService;
import com.capgemini.hotelbooking.services.ICommonService;
import com.capgemini.hotelbooking.services.ICustomerService;

@Controller
public class HotelBookingController {
	@Resource
	private ICommonService commonService;
	@Resource
	private IAdminService adminService;
	@Resource
	private ICustomerService customerService;
	
	final private static String homePage = "getHomePage.obj";
	final private static String adminPage = "getAdminPage.obj";
	final private static String customerPage = "getCustomerPage.obj";

	
	
	@RequestMapping("/getHomePage")
	public ModelAndView getHomePage() {
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("HomePage");
		return mAndV;
	}
	
	@RequestMapping("/getSignUpPage")
	public ModelAndView getSignUpPage(){
		ModelAndView mAndV = new ModelAndView();
		UserBean userBean = new UserBean();
		mAndV.addObject("userBean", userBean);
		mAndV.addObject("home", homePage);
		mAndV.setViewName("SignUp");
		return mAndV;
	}
	
	@RequestMapping(value="/addUser" , method=RequestMethod.POST)
	public String addUser(@ModelAttribute("userBean") UserBean userBean , Model mAndV ) throws BookingException{
		userBean.setRole("customer");
		userBean.setStatus("active");
		commonService.registerUser(userBean);
		if(userBean.getUserID() > 0){
			mAndV.addAttribute("userBean", userBean);
			mAndV.addAttribute("pageHead",userBean.getUserName()+"is successfully registered.");
			mAndV.addAttribute("home",homePage);
			return "Success";
		}
		else{
			mAndV.addAttribute("pageHead", "Sign up Error please try again later.");
			return "ErrorPage";
		}
	}
	
	@RequestMapping("/getLoginPage")
	public ModelAndView getLoginPage() {
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("home", homePage);
		mAndV.setViewName("LoginPage");
		return mAndV;
	}
	
	@RequestMapping(value="/getFunctionalities", method=RequestMethod.POST)
	public ModelAndView getFunctionalities(@RequestParam("userName") String userName, @RequestParam("password") String password,HttpServletRequest request) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		UserBean validUser=null;
		HttpSession session = request.getSession(true);
		validUser = commonService.login(userName, password);
		if(validUser==null){
			mAndV.addObject("home", homePage);
			mAndV.setViewName("LoginPage");
		}
		else{
			session.setAttribute("message", "Hi, " + validUser.getName());
			session.setAttribute("userBean", validUser);
			if("admin".equals(validUser.getRole())){
				session.setAttribute("home", adminPage);
				mAndV.setViewName("Admin");
			}
			else{
				session.setAttribute("home", customerPage);
				mAndV.setViewName("Customer");
			}
		}
		return mAndV;
	}
	
	@RequestMapping("/getAdminPage")
	public ModelAndView getAdminPage(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("Admin");
		return mAndV;
	}
	
	@RequestMapping("/getCustomerPage")
	public ModelAndView getCustomerPage(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("Customer");
		return mAndV;
	}
	
	@RequestMapping("/addNewHotel")
	public ModelAndView addNewHotel(){
		ModelAndView mAndV = new ModelAndView();
		HotelBean hotelBean = new HotelBean();
		mAndV.addObject("hotelBean", hotelBean);
		mAndV.setViewName("AddNewHotel");
		return mAndV;
	}
	
	@RequestMapping(value="/addHotelDetails" , method=RequestMethod.POST)
	public ModelAndView addHotelDetails(@ModelAttribute("hotelBean") HotelBean hotelBean) throws BookingException {
		ModelAndView mAndV = new ModelAndView();
		hotelBean.setStatus("active");
		adminService.addHotelDetails(hotelBean);
		mAndV.addObject("hotelBean", hotelBean);
		mAndV.addObject("pageHead",hotelBean.getHotelName()+" Hotel is registered successfully.");
		mAndV.setViewName("Success");
		return mAndV;
	}
	
	@RequestMapping(value="/getHotelList")
	public ModelAndView getHotelList() throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		List<HotelBean> hotelList =  commonService.retrieveHotels();
		mAndV.addObject("hotelList", hotelList);
		mAndV.setViewName("UpdateHotel");		
		return mAndV;
	}
	
	
	@RequestMapping("/updateHotelDetails")
	public ModelAndView updateHotelDetails(@RequestParam("hotelID") int hotelID,@RequestParam("attributeOption") int attributeOption,@RequestParam("attributeValue") String attributeValue) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		adminService.updateHotelDetails(hotelID, attributeOption, attributeValue);
		mAndV.addObject("pageHead","Hotel with hotel ID "+ hotelID +" is successfully Updated.");
		mAndV.setViewName("Success");
		return mAndV;
	}
	
	@RequestMapping("/deleteHotel")
	public ModelAndView deleteHotel() throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		List<HotelBean> hotelList =  commonService.retrieveHotels();
		mAndV.addObject("hotelList", hotelList);
		mAndV.setViewName("DeleteHotel");
		return mAndV;
	}
	
	@RequestMapping(value="/deleteHotelDetails", method=RequestMethod.POST )
	public ModelAndView deleteHotelDetails(@RequestParam("hotelID") int hotelID) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		HotelBean hotelBean = adminService.retrieveHotelDetails(hotelID);
		mAndV.addObject("hotelBean", hotelBean);
		adminService.deleteHotelDetails(hotelID);
		mAndV.addObject("pageHead", "Hotel with hotel ID"+ hotelID +" is successfully deleted.");
		mAndV.setViewName("Success");
		return mAndV;
	}
	
	@RequestMapping("/addNewRoom")
	public ModelAndView addNewRoom() throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		RoomBean roomBean = new RoomBean();
		mAndV.addObject("roomBean", roomBean);
		List<HotelBean> hotelList =  commonService.retrieveHotels();
		mAndV.addObject("hotelList", hotelList);
		mAndV.setViewName("AddNewRoom");
		return mAndV;
	}
	
	@RequestMapping(value="/insertRoom", method=RequestMethod.POST )
	public ModelAndView InsertRoom(@ModelAttribute("roomBean") RoomBean roomBean) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		roomBean.setAvailable('T');
		roomBean.setStatus("active");
		adminService.addRoomDetails(roomBean);
		
		mAndV.addObject("pageHead","Room with room ID "+ roomBean.getRoomID() +" is successfully added.");
		mAndV.setViewName("Success");
		return mAndV;
	}
	
	@RequestMapping(value="/getRoomList")
	public ModelAndView UpdateRoomList() throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		List<RoomBean> roomList = commonService.retrieveRooms();
		mAndV.addObject("roomList", roomList);
		mAndV.setViewName("UpdateRoom");		
		return mAndV;
	}
	
	
	
	@RequestMapping(value="/updateRoom", method=RequestMethod.POST )
	public ModelAndView updateRoom(@RequestParam("roomID") int roomID, 
								@RequestParam("attributeOption") int attributeOption,
								@RequestParam("attributeValue") String attributeValue
			) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		adminService.updateRoomDetails(roomID, attributeOption, attributeValue);
		mAndV.addObject("pageHead","Room with room ID "+ roomID +" is Updated");;
		mAndV.setViewName("Success");				
		return mAndV;
	}
	

	@RequestMapping(value="/deleteRoomList")
	public ModelAndView deleteRoomList() throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		List<RoomBean> roomList = commonService.retrieveRooms();
		mAndV.addObject("roomList", roomList);
		mAndV.setViewName("DeleteRoom");		
		return mAndV;
	}
	
	@RequestMapping(value="/deleteRoom", method=RequestMethod.POST )
	public ModelAndView deleteRoom(@RequestParam("roomID") int roomID) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		RoomBean roomBean = new RoomBean();
		roomBean = adminService.retrieveRoomDetails(roomID);
		adminService.deleteRoomDetails(roomID);
		mAndV.addObject("pageHead", "Room with room ID"+ roomID +" is deleted");
		mAndV.addObject("RoomBean", roomBean);
		mAndV.setViewName("Success");				
		return mAndV;
	}
	
	
	@RequestMapping("/viewAllHotels")
	public ModelAndView viewAllHotelsJsp() throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		List<HotelBean> hotelList = commonService.retrieveHotels(); 
		mAndV.addObject("hotelList", hotelList);
		mAndV.setViewName("HotelList");		
		return mAndV;
	}
	
	@RequestMapping("/getHotelById")
	public ModelAndView getHotelById() throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		List<HotelBean> hotelList = commonService.retrieveHotels(); 
		mAndV.addObject("hotelList", hotelList);
		mAndV.setViewName("HotelBookingListID");
		return mAndV;
	}
	
	@RequestMapping(value="/hotelBookingByID", method=RequestMethod.POST )
	public ModelAndView hotelBookingByID(@RequestParam("hotelID") int hotelID) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		List<BookingBean> bookingList = adminService.viewBookingsOfHotel(hotelID);
		if(bookingList.size()>0)
		{
			mAndV.addObject("bookingList", bookingList);
			mAndV.setViewName("ViewBookingHotelID");
		}
		else{
			mAndV.addObject("pageHead", "No Bookings found.");
			mAndV.setViewName("ErrorPage");
		}
		return mAndV;
	}
	
	@RequestMapping("/getBookingsByDate")
	public ModelAndView getHotelByDate() throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("HotelBookingListDate");
		return mAndV;
	}
	
	@RequestMapping(value="/hotelBookingByDate", method=RequestMethod.POST )
	public ModelAndView hotelBookingByDate(@RequestParam("date") String date) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date bookingDate = null;
		try {
			bookingDate = formatter.parse(date);
		} catch (ParseException e) {
			mAndV.addObject("pageHead", "Enter Valid Date Format. ");
			mAndV.setViewName("ErrorPage");
		}
		List<BookingBean> bookingList = adminService.viewBookingsOfDate(bookingDate);
		if(bookingList.size()>0)
		{
			mAndV.addObject("bookingList", bookingList);
			mAndV.setViewName("ViewBookingHotelID");
		}
		else{
			mAndV.addObject("pageHead", "No Bookings found.");
			mAndV.setViewName("ErrorPage");
		}			
		return mAndV;
	}
	
	@RequestMapping("/getHotelByID")
	public ModelAndView getHotelByID(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("GuestList");
		return mAndV;
	}
	
	@RequestMapping("/getGuestList")
	public ModelAndView getGuestList(@RequestParam("hotelID") int hotelID) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		List<UserBean> guestList=adminService.viewGuestList(hotelID);
		mAndV.addObject("guestList", guestList);
		mAndV.setViewName("GuestList");
		return mAndV;
	}
	
	@RequestMapping("/getCity")
	public ModelAndView getCity(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("CityEntry");
		return mAndV;
	}
	
	@RequestMapping("/searchHotels")
	public ModelAndView searchHotels(@RequestParam("city") String city) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		List<RoomBean> roomList = customerService.searchAvailableRooms(city.toLowerCase());
		if(roomList.size()>0)
		{
			mAndV.addObject("roomList", roomList);
			mAndV.setViewName("Roomdetails");
		}
		else{
			mAndV.addObject("pageHead", "No rooms found.");
			mAndV.setViewName("ErrorPage");
		}
		return mAndV;
	}
	
	@RequestMapping("/bookRoom")
	public ModelAndView bookRoom(HttpServletRequest request,@RequestParam("roomID") int roomID){
		ModelAndView mAndV = new ModelAndView();
		BookingBean bookingBean = new BookingBean();
		mAndV.addObject("bookingBean", bookingBean);
		HttpSession session=request.getSession(false);
		UserBean userBean=(UserBean) session.getAttribute("userBean");
		int userID= userBean.getUserID();
		mAndV.addObject("userID", userID);
		mAndV.addObject("roomID", roomID);
		mAndV.setViewName("BookRoom");
		return mAndV;
	}
	
	@RequestMapping(value="/insertBookingDetails",method=RequestMethod.POST)
	public ModelAndView bookRoom(@ModelAttribute("bookingBean") BookingBean bookingBean) throws BookingException{
		System.out.println(bookingBean);
		ModelAndView mAndV = new ModelAndView();
		customerService.bookRoom(bookingBean);
		mAndV.addObject("pageHead", "Room is successfully booked.");
		mAndV.setViewName("Success");
		return mAndV;
	}
	
	
	@RequestMapping("/showBookingStatus")
	public ModelAndView showBookingstatus(HttpServletRequest request) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		HttpSession session=request.getSession();
		UserBean userBean=(UserBean) session.getAttribute("userBean");
		int userID= userBean.getUserID();
		List<List<Object>> statusList = customerService.viewBookingStatus(userID);
		
		if(statusList.size()>0){
			mAndV.addObject("statusList",statusList);
			mAndV.setViewName("BookingStatus");
		}
		else{
			mAndV.addObject("pageHead", "No Bookings found.");
			mAndV.setViewName("ErrorPage");
		}
		return mAndV;
	}
	
	
	@RequestMapping("/logOut")
	public ModelAndView LogOut(HttpServletRequest request){
		ModelAndView mAndV = new ModelAndView();
		HttpSession session = request.getSession(false);
		if(session != null){
			session.invalidate();
			mAndV.addObject("pageHead", "You have successfully logged out.");
			mAndV.addObject("home", homePage);
		}
		mAndV.setViewName("LogOut");
		return mAndV;
	}
	
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
