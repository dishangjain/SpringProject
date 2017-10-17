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
		<form:form method="post" action="updateHotelDetails.obj">
			<label for="hotelID">Hotel Name</label>
			<select name="hotelID" >
					<c:forEach items="${ hotelList }" var="hotel">
						<option value="${hotel.hotelID }">${hotel.hotelName }</option>
					</c:forEach>
			</select>
			<br>
			<label for="attributeOption" >Options</label>
			<select name="attributeOption">
				<option value="1">City</option>
				<option value="2">Hotel Name</option>
				<option value="3">Address</option>
				<option value="4">Description</option>
				<option value="5">Average Rate Per Night</option>
				<option value="6">PhoneNumber1</option>
				<option value="7">PhoneNumber2</option>
				<option value="8">Rating</option>
				<option value="9">Email ID</option>
				<option value="10">Fax</option>
			</select>
			<br>
			<label for="attributeValue">Enter Value : </label>
			<input name="attributeValue" type="text">
			<input type="submit" value="Confirm Changes"/>
		</form:form>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>