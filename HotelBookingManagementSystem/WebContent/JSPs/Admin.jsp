<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Travel-R bUddY</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		
		<div id="mainMenu">
			<a href="addNewHotel.obj">Add new Hotel</a><br>
			<a href="getHotelList.obj">Update Existing Hotel</a><br>
			<a href="deleteHotel.obj">Delete a Hotel</a><br>
			<a href="addNewRoom.obj">Add new Room</a><br>
			<a href="getRoomList.obj">Update Existing Room</a><br>
			<a href="deleteRoomList.obj">Delete a room</a><br>
			<a href="viewAllHotels.obj">View all Hotels</a><br>
			<a href="getHotelById.obj">View Bookings of Hotels by ID</a><br>
			<a href="getBookingsByDate.obj">View Bookings of Hotels By Date</a><br>
		</div>
		<div class="row uniform">
			<div class="4u"><span class="image fit"><img src="images/pic02.jpeg" alt="" /></span></div>
			<div class="4u$"><span class="image fit"><img src="images/hotel03.jpeg" alt="" /></span></div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
		
	</body>
</html>