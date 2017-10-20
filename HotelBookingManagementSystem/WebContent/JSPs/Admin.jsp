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
		
		<p>
		<br/>
			<span class="image right"><img src="images/hotel01.jpeg" alt="" /></span>
			<div class="6u 12u$(medium)">
				<ul class="alt">
					<li><a href="addNewHotel.obj">Add new Hotel</a></li>
					<li><a href="getHotelList.obj">Update Existing Hotel</a></li>
					<li><a href="deleteHotel.obj">Delete a Hotel</a></li>
					<li><a href="addNewRoom.obj">Add new Room</a></li>
					<li><a href="getRoomList.obj">Update Existing Room</a></li>
					<li><a href="deleteRoomList.obj">Delete a room</a></li>
					<li><a href="viewAllHotels.obj">View all Hotels</a></li>
					<li><a href="getHotelById.obj">View Bookings by Hotel Name</a></li>
					<li><a href="getBookingsByDate.obj">View Bookings by Booking Date</a></li>
				</ul>
			</div>
		</p>
		<jsp:include page="footer.jsp"></jsp:include>
		
	</body>
</html>