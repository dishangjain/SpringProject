<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
	
		
		
		<center>
			<form:form method="post" modelAttribute="bookingBean" action="insertBookingDetails.do">
	  		
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
		  		<form:input path="numChildren" id="numChildren" type="number"/><br/>
		  		
		  		<label for="bookedFrom">Booked From :</label>
		  		<%-- <fmt:formatDate value="${bookingBean.bookedFrom }" var="dateString" pattern="dd/MM/yyyy"/> --%>
		  		<%-- <form:input type="text" class="date" path="bookedFrom" id="bookedFrom"/><br/> --%>
		  		
		  		<%-- <label for="bookedTo">Booked To :</label>
		  		<fmt:formatDate value="${bookingBean.bookedTo }" var="dateString" pattern="dd/MM/yyyy"/>
		  		<form:input path="bookedTo" value="${dateString }" id="bookedTo" type="date"/><br/>
		  		 --%>
		  		
		  		<input type="text" path="bookedFrom" class= "date" name = "bookedFrom" value = "<fmt:formatDate value='${bookingBean.bookedFrom}' pattern='dd-MM-yyyy' />" />
		  		
		  		<input type="submit" value="Confirm Booking"/>
			</form:form>
		</center>
		
		
		
		
	</body>
</html>