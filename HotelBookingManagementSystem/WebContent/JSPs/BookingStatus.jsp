<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<br/><br/>
			<table border="1">
			<tr>
				<th>Booking Reference Number</th>
				<th>City</th>
				<th>Hotel Name</th>
				<th>Address</th>
				<th>Room Number</th>
				<th>Check in Date</th>
				<th>Check Out Date</th>
				<th>Total Amount</th>
				<th>User Name</th>
				<th>First Guest Reference</th>
				<th>Second Guest Reference</th>
				<th>Hotel Contact</th>
			</tr>
			<c:forEach items="${ statusList }" var="sl">
				<tr>
					<td>${ sl.get(0).bookingID }</td>
					<td>${ sl.get(2).city }</td>
					<td>${ sl.get(2).hotelName }</td>
					<td>${ sl.get(2).address }</td>
					<td>${ sl.get(1).roomNumber }</td>
					<td>${ sl.get(0).bookedFrom }</td>
					<td>${ sl.get(0).bookedTo }</td>
					<td>${ sl.get(0).amount }</td>
					<td>${ sessionScope.userBean.name }</td>
					<td>${ sl.get(0).firstGuestName }</td>
					<td>${ sl.get(0).secondGuestName }</td>
					<td>${ sl.get(2).phoneNumber1 }</td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>