<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
			<form:form method="post" modelAttribute="roomBean"  action="insertRoom.obj" >
			
				<label for="hotelID">Hotel ID :</label>
				<form:select name="hotelID" path="hotelID" id="hotelID" required="true" >
						<c:forEach items="${ hotelList }" var="hotel">
							<option value="${hotel.hotelID }">${hotel.hotelName }</option>
						</c:forEach>
				</form:select>
				<br/>
				<label for="roomNumber">Room Number :</label>
			  		<form:input path="roomNumber" id="roomNumber" type="text" pattern="[0-9]{3}" required="true"/><br/>	
			  		
			  	<label for="roomType">Room Type :</label>
			  		<form:select path="roomType" id="roomType" >
			  			<form:option value="AC Deluxe">AC Deluxe</form:option>
			  			<form:option value="AC">AC</form:option>
			  			<form:option value="Non-AC">Non-AC</form:option>
			  		</form:select>
			  			<br/>	
			  	
			  	<label for="perNightRate">Per Night Rate :</label>
			  		<form:input path="perNightRate" id="perNightRate" type="text" pattern="[1-9][0-9]{0,3}[.]?[0-9]{0,2}" required="true"/><br/>
			  		
			  	<label for="photo">Photo : </label><form:input path="photo" id="photo" type="file" required="true"/>
				<br/>
				<input type="submit" value="Confirm Changes"/>
				
			</form:form>
		</center>
		
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>