<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
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
		<center>
		
			<label>Room Number :</label>
			<h3>${ roomNumber }</h3><br>
			
			<form:form method="post" modelAttribute="bookingBean" action="insertBookingDetails.obj">
	  		
	  			<label for="firstGuestName">First Guest Name :</label>
		  		<form:input path="firstGuestName" id="firstGuestName" type="text" pattern="[A-Za-z ]{3,30}" placeholder="Enter your Name" required="true"/><br/>
		  		
		  		<label for="secondGuestName">Second Guest Name :</label>
		  		<form:input path="secondGuestName" id="secondGuestName" type="text" placeholder="Enter second Name(Optional)" pattern="[A-Za-z ]{3,30}"/><br/>
	  			
		  		<form:input path="roomID" id="roomID" type="hidden" value="${ roomID }" readonly="true"/>
		  		
		  		<form:input path="userID" id="userID" type="hidden" value="${ userID }" readonly="true"/>
		  		
		  		<label for="numAdults">Number of Adults :</label>
		  		<form:input path="numAdults" id="numAdults" type="text"  pattern="[1-3]" placeholder="eg. 1-9" min="1" max="3" required="true" /><br/>
		  		
		  		<label for="numChildren">Number of Children :</label>
		  		<form:input path="numChildren" id="numChildren" type="text" pattern="[0-3]" placeholder="eg. 0-9" min="0" max="3" required="true"/><br/>
		  		
		  		<input type="submit" value="Confirm Booking"/>
			</form:form>
		</center>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>