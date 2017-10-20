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
		<script src="assets/js/hotelUpdation.js" type="text/javascript"></script>
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<center>
			<form:form method="post" action="updateHotelDetails.obj">
				<label for="hotelID">Hotel Name</label>
				<select name="hotelID" required="true">
						<c:forEach items="${ hotelList }" var="hotel">
							<option value="${hotel.hotelID }">${hotel.hotelName }</option>
						</c:forEach>
				</select>
				<br>
				<label for="attributeOption" >Options</label>
				<select name="attributeOption" onchange="addValueBox()" required="true">
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
				<p id="p">
					<label for="attributeValue">Enter City : </label>
					<input name="attributeValue" type="text" required="true" pattern="[A-Za-z0-9 ]{3,20}" placeholder="Please enter city"/>
				</p>
				<input type="submit" value="Confirm Changes"/>
			</form:form>
		</center>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>