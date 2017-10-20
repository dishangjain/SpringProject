<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<br/>
		<table border="1">
			<tr>
				<th>Booking ID</th>
				<th>Room Number</th>
				<th>User ID</th>
				<th>Number of Adults</th>
				<th>Number of Children</th>
				<th>Amount</th>
				<th>Booked From</th>
				<th>Booked To</th>
				<th>Status</th>
				<th>First Guest Name</th>
				<th>Second Guest Name</th>
			</tr>
			<c:forEach items="${bookingList }" var="booking">
				<tr>
					<td>${ booking.bookingID }</td>
					<td>${ booking.roomID }</td>
					<td>${ booking.userID }</td>
					<td>${ booking.numAdults }</td>
					<td>${ booking.numChildren }</td>
					<td>${ booking.amount }</td>
					<td>${ booking.bookedFrom }</td>
					<td>${ booking.bookedTo }</td>
					<td>${ booking.status }</td>
					<td>${ booking.firstGuestName }</td>
					<td>${ booking.secondGuestName }</td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>