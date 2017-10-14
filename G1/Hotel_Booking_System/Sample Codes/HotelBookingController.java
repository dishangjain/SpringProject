package com.capgemini.hotelbooking.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
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
	
	
	@RequestMapping("/getHomePageJsp.do")
	public ModelAndView getHomePage() {
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("HomePage");
		return mAndV;  
	}
	
	@RequestMapping("/getLoginPageJsp.do")
	public ModelAndView getLoginPage() {
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("LoginPage");
		return mAndV;
	}
	
	@RequestMapping("/getSignUpPageJsp.do")
	public ModelAndView getSignUpPage(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("SignUp");
		return mAndV;
	}
	
	@RequestMapping(value="/addUser.do" , method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") UserBean userBean ) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		commonService.registerUser(userBean);
		mAndV.addObject("userBean", userBean);
		mAndV.addObject("pageHead","You have successfully registered.");
		mAndV.setViewName("Success");
		return mAndV;
	}
	
		
	@RequestMapping(value="/getFunctionalities.do", method=RequestMethod.POST)
	public ModelAndView getFunctionalities(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpServletRequest request) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		HttpSession session=request.getSession(true);
		UserBean validUser=null;
		validUser = commonService.login(userName, password);
		if(validUser==null){
			mAndV.setViewName("HomePage");
		}
		else{
			mAndV.addObject("pageHead", userName);
			session.setAttribute("userBean",validUser);
			if("admin".equals(validUser.getRole())){
				mAndV.setViewName("Admin");
			}
			else{
			mAndV.setViewName("Customer");
			}
		}
		return mAndV;
	}
	
	@RequestMapping("/addNewHotelJsp.do")
	public ModelAndView addNewHotel(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("AddNewHotel");
		return mAndV;
	}
	
	@RequestMapping(value="/addHotelDetails.do" , method=RequestMethod.POST)
	public ModelAndView addHotelDetails(@ModelAttribute("newHotel") HotelBean hotelBean) throws BookingException {
		ModelAndView mAndV = new ModelAndView();
		adminService.addHotelDetails(hotelBean);
		mAndV.addObject("hotelBean", hotelBean);
		mAndV.addObject("pageHead","Hotel is registered successfully.");
		mAndV.setViewName("Success");
		return mAndV;
	}
	
	@RequestMapping(value="/getHotelList.do")
	public ModelAndView getHotelList() throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		List<HotelBean> hotelList =  commonService.retrieveHotels();
		mAndV.addObject("HotelList", hotelList);
		mAndV.setViewName("UpdateHotel");		
		return mAndV;
	}
	
	
	@RequestMapping("/updateHotelDetails.do")
	public ModelAndView updateHotelDetails(@RequestParam("hotelID") int hotelID,@RequestParam("attributeOption") int attributeOption,@RequestParam("attributeValue") String attributeValue) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		adminService.updateHotelDetails(hotelID, attributeOption, attributeValue);
		mAndV.setViewName("Success");	
		return mAndV;
	}
	
	@RequestMapping("/deleteHotelJsp.do")
	public ModelAndView deleteHotel(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("DeleteHotel");
		return mAndV;
	}
	
	@RequestMapping(value="/deleteHotelDetails.do", method=RequestMethod.POST )
	public ModelAndView deleteHotelDetails(@RequestParam("hotelID") int hotelID) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		HotelBean hotelBean = adminService.retrieveHotelDetails(hotelID);
		mAndV.addObject("hotelBean", hotelBean);
		adminService.deleteHotelDetails(hotelID);
		mAndV.addObject("pageHead", "Hotel Details are successfully deleted.");
		mAndV.setViewName("Success");
		return mAndV;
	}
	
	@RequestMapping("/addNewRoomJsp.do")
	public ModelAndView addNewRoom(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("AddNewRoom");
		return mAndV;
	}
	
	@RequestMapping(value="/addRoomById.do", method=RequestMethod.POST )
	public ModelAndView AddRoomById(@RequestParam("hotelID") int hotelID) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("hotelID", hotelID);
		// TO-Do validate input hotel id
		RoomBean roomBean = new RoomBean();
		mAndV.addObject("RoomBean", roomBean);
		mAndV.setViewName("AddRoomDetails");		
		return mAndV;
	}
	
	@RequestMapping(value="/insertRoom.do", method=RequestMethod.POST )
	public ModelAndView InsertRoom(@ModelAttribute("roomBean") RoomBean roomBean) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		adminService.addRoomDetails(roomBean);
		// mAndV.addObject("hotelID", hotelID);
		mAndV.addObject("pageHead", "Room is successfully added.");
		mAndV.setViewName("Success");
		return mAndV;
	}
	
	@RequestMapping(value="/getRoomList.do", method=RequestMethod.POST )
	public ModelAndView UpdateRoomList() throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		List<HotelBean> hotelList =  commonService.retrieveHotels();
		List<RoomBean> roomList = commonService.retrieveRooms();
		mAndV.addObject("RoomList", roomList);
		mAndV.addObject("HotelList", hotelList);
		mAndV.setViewName("UpdateRoom");		
		return mAndV;
	}
	
	
	
	@RequestMapping(value="/updateRoom.do", method=RequestMethod.POST )
	public ModelAndView updateRoom(@RequestParam("roomID") int roomID, 
								@RequestParam("attributeOption") int attributeOption,
								@RequestParam("attributeValue") String attributeValue
			) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		adminService.updateRoomDetails(roomID, attributeOption, attributeValue);
		mAndV.addObject("pageHead", "Room Updated");
		mAndV.setViewName("Success");				
		return mAndV;
	}
	

	@RequestMapping(value="/deleteRoomList.do", method=RequestMethod.POST )
	public ModelAndView deleteRoomList() throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		List<HotelBean> hotelList =  commonService.retrieveHotels();
		List<RoomBean> roomList = commonService.retrieveRooms();
		mAndV.addObject("RoomList", roomList);
		mAndV.addObject("HotelList", hotelList);
		mAndV.setViewName("DeleteRoom");		
		return mAndV;
	}
	
	@RequestMapping(value="/deleteRoom.do", method=RequestMethod.POST )
	public ModelAndView deleteRoom(@RequestParam("roomID") int roomID) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		RoomBean roomBean = new RoomBean();
		roomBean = adminService.retrieveRoomDetails(roomID);
		adminService.deleteRoomDetails(roomID);
		mAndV.addObject("pageHead", "The following room is deleted");
		mAndV.addObject("RoomBean", roomBean);
		mAndV.setViewName("Success");				
		return mAndV;
	}
	
	
	@RequestMapping("/viewAllHotelsJsp.do")
	public ModelAndView viewAllHotelsJsp() throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		List<HotelBean> hotelList = commonService.retrieveHotels(); 
		mAndV.addObject("HotelList", hotelList);
		mAndV.setViewName("HotelList");		
		return mAndV;
	}
	
	@RequestMapping("/getHotelByIdJsp.do")
	public ModelAndView getHotelByIdJsp(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("HotelBookingListID");
		return mAndV;
	}
	
	@RequestMapping(value="/hotelBookingByID.do", method=RequestMethod.POST )
	public ModelAndView hotelBookingByID(@RequestParam("hotelID") int hotelID) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		List<BookingBean> bookingList = adminService.viewBookingsOfHotel(hotelID);
		mAndV.addObject("BookingList", bookingList);
		mAndV.setViewName("ViewBookingHotelID");				
		return mAndV;
	}
	
	@RequestMapping("/getHotelByDateJsp.do")
	public ModelAndView getHotelByDateJsp(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("HotelBookingListDate");
		return mAndV;
	}
	
	@RequestMapping(value="/hotelBookingByDate.do", method=RequestMethod.POST )
	public ModelAndView hotelBookingByDate(@RequestParam("date") String date) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		Date bookingDate = null;
		try {
			bookingDate = formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BookingBean> bookingList = adminService.viewBookingsOfDate(bookingDate);
		mAndV.addObject("BookingList", bookingList);
		mAndV.setViewName("ViewBookingHotelID");				
		return mAndV;
	}
	
	@RequestMapping("/getHotelByIDJsp.do")
	public ModelAndView getHotelByIDJsp(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("GuestList");
		return mAndV;
	}
	
	@RequestMapping("/getGuestList.do")
	public ModelAndView getGuestList(@RequestParam("hotelID") int hotelID) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		List<UserBean> guestList=adminService.viewGuestList(hotelID);
		mAndV.addObject("guestList", guestList);
		mAndV.setViewName("GuestList");
		return mAndV;
		
	}
	
	@RequestMapping("/getCity.do")
	public ModelAndView getCity(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("CityEntry");
		return mAndV;
	}
	
	@RequestMapping("/searchHotels.do")
	public ModelAndView searchHotels(@RequestParam("city") String city) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		List<RoomBean> roomList=customerService.searchAvailableRooms(city);
		if(roomList.size()>0)
		{
		mAndV.addObject("roomList", roomList);
		mAndV.setViewName("Roomdetails");
		}
		else{
			mAndV.addObject("pageHead", "No rooms found.");
			mAndV.setViewName("Error");
		}
		return mAndV;
	}
	
	@RequestMapping("/bookRoom.do")
	public ModelAndView bookRoom(HttpServletRequest request,@RequestParam("roomID") String roomID){
		ModelAndView mAndV = new ModelAndView();
		BookingBean bookingBean = new BookingBean();
		mAndV.addObject("bookingBean", bookingBean);
		HttpSession session=request.getSession();
		UserBean userBean=(UserBean) session.getAttribute("userBean");
		int userID= userBean.getUserID();
		mAndV.addObject("userID", userID);
		mAndV.addObject("roomID", roomID);
		mAndV.setViewName("BookRoom");
		return mAndV;
	}
	
	@RequestMapping(value="/bookRoom.do",  method=RequestMethod.POST)
	public ModelAndView bookRoom(@ModelAttribute("bookingBean") BookingBean bookingBean) throws BookingException{
		ModelAndView mAndV = new ModelAndView();
		customerService.bookRoom(bookingBean);
		mAndV.addObject("pageHead", "Room is successfully booked.");
		mAndV.setViewName("Success");
		return mAndV;
	}
	
	
	@RequestMapping("/showBookingStatus.do")
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
			mAndV.setViewName("Error");
		}
		
		return mAndV;
	}
	
	
	@RequestMapping("/logOut.do")
	public ModelAndView LogOut(){
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("pageHead", "You have successfully logged out.");
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
