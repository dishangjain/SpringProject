<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<form:form method="post" modelAttribute="hotelBean" action="addHotelDetails.obj">
	  		
	  			<label for="hotelName">Hotel Name :</label>
		  		<form:input path="hotelName" id="hotelName" type="text" pattern="[A-Za-z0-9 ]{3,30}" placeholder="Please enter Hotel Name" required="true"/><br/>
		  		
		  		<label for="address">Address :</label>
		  		<form:textarea path="address" id="address" type="textarea" pattern="[A-Za-z0-9,.-/\ ]{5,40}" placeholder="Please enter address" required="true"/><br/>
	  			
		  		<label for="description">Description :</label>
		  		<form:input path="description" id="description" type="text" pattern="[A-Za-z0-9 ]{10,50}" placeholder="Please enter description" required="true"/><br/>
		  		
		  		<label for="city">City :</label>
		  		<form:input path="city" id="city" type="text" pattern="[A-Za-z0-9 ]{3,20}" placeholder="Please enter city" required="true"/><br/>
		  		
		  		<label for="avgRatePerNight">Average Rate Per Night :</label>
		  		<form:input path="avgRatePerNight" id="avgRatePerNight" type="text" placeholder="eg. 1234.56" pattern="[1-9][0-9]{0,3}[.]?[0-9]{0,2}" required="true"/><br/>
		  		
		  		<label for="phoneNumber1">Phone Number 1 :</label>
		  		<form:input path="phoneNumber1" id="phoneNumber1" type="text" placeholder="eg. 7089877832" pattern="[7-9][0-9]{9}" required="true"/><br/>
		  		
		  		<label for="phoneNumber2">Phone Number 2 :</label>
		  		<form:input path="phoneNumber2" id="phoneNumber2" type="text" placeholder="eg. 7845636323(Optional)" pattern="[7-9][0-9]{9}" required="true"/><br/>
		  		
		  		<label for="rating">Rating :</label>
		  		<form:input path="rating" id="rating" type="text" placeholder="eg. 1.0" pattern="[1-4][.][0-9]" required="true"/><br/>
		  		
		  		<label for="email">Email ID :</label>
		  		<form:input path="email" id="email" type="text" placeholder="Please enter email ID" pattern="[A-Za-z0-9._%+-]{1,18}@[a-z0-9.-]{1,7}\.[a-z]{2,3}$" required="true" /><br/>
		  		
		  		<label for="fax">Fax :</label>
		  		<form:input path="fax" id="fax" type="text" placeholder="eg. 000000" pattern="[0-9]{6}" required="true"/><br/>
		  		
		  		<input type="submit" value="Submit Details"/>
			</form:form>
		</center>
		<jsp:include page="footer.jsp"></jsp:include>
		
		
	</body>
</html>