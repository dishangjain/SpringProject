<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<script type="text/javascript" src="scripts/jquery-1.12.3.js"></script>
		<script type="text/javascript" src="scripts/MyJsLib.js"></script>
	</head>
	<body>

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
					<td>${booking.bookingID }</td>
					<td>${booking.roomID }</td>
					<td>${booking.userID }</td>
					<td>${booking.numAdults }</td>
					<td>${booking.numChildren }</td>
					<td>${booking.amount }</td>
					<td>${booking.bookedFrom }</td>
					<td>${booking.bookedTo }</td>
					<td>${booking.status }</td>
					<td>${booking.firstGuestName }</td>
					<td>${booking.secondGuestName }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="${home }">Home Page</a>
	</body>
</html>