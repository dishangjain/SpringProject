<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		
		<center>
			<form:form method="post" modelAttribute="bookingBean" action="bookRoomRequest.do">
	  		
	  			<label for="firstGuestName">First Guest Name :</label>
		  		<form:input path="firstGuestName" id="firstGuestName" type="text"/><br/>
		  		
		  		<label for="secondGuestName">Second Guest Name :</label>
		  		<form:input path="secondGuestName" id="secondGuestName" type="text"/><br/>
	  			
		  		<label for="roomID">Room ID :</label>
		  		<form:input path="roomID" id="roomID" type="text" value="${roomID }"/><br/>
		  		
		  		<label for="userID">User ID :</label>
		  		<form:input path="userID" id="userID" type="text" value="${userID }"/><br/>
		  		
		  		<label for="numAdults">Number of Adults :</label>
		  		<form:input path="numAdults" id="numAdults" type="number"/><br/>
		  		
		  		<label for="numChildren">Number of Children :</label>
		  		<form:input path="numChildren" id="numChildren" type="text"/><br/>
		  		
		  		<label for="BookedFrom">Booked From :</label>
		  		<form:input path="BookedFrom" id="BookedFrom" type="date"/><br/>
		  		
		  		<label for="BookedTo">Booked To :</label>
		  		<form:input path="BookedTo" id="BookedTo" type="date"/><br/>
		  		
		  		<input type="submit" value="Confirm Booking"/>
			</form:form>
		</center>
		
		
		
		
	</body>
</html>