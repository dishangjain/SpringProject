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
				<th>Hotel Name</th>
				<th>Rating</th>
				<th>Room Type</th>
				<th>Cost/Night</th>
				<th>Booking Link</th>
			</tr>
			<c:forEach items="${ roomList }" var="room">
				<tr>
					<c:forEach items="${ hotelList }" var="hotel">
						<c:if test="${ room.hotelID eq hotel.hotelID }">
							<td>${ hotel.hotelName }</td>
							<td>${ hotel.rating }</td>
						</c:if>
					</c:forEach>
					<td>${ room.roomType }</td>
					<td>${ room.perNightRate }</td>
					<td><a href="bookRoom.obj?roomID=${ room.roomID }">Book Now</a></td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>