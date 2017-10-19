<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.time.LocalDate"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Travel-R bUddY</title>
		<meta charset="utf-8" />
		
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" type="text/css" href="assets/css/main.css" />
		
	</head>
	<body onload="setMin()">
		<jsp:include page="header.jsp"></jsp:include>
		
		<center>
			<form action="searchHotels.obj">
				<label>Enter City : </label><input type="text" name="city"  pattern="[A-Za-z0-9 ]{3,20}" required="true" ><br/>
				<label>CheckIn Date : </label><input type="date" id="checkin" name="checkinDate" min="<%= LocalDate.now()%>" onchange="validate()" required="true"/><br/>
				<label>CheckOut Date : </label><input type="date" id="checkout" name="checkoutDate" min="<%= LocalDate.now().plusDays(1) %>" required="true"/>
				<br/>
				<input type="submit" value="Submit City">
			</form>
		</center>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
