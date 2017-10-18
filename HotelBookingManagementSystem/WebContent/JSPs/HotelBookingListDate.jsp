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
			<form method="post" action="hotelBookingByDate.obj">
				<label for="date">Enter Target Date : </label><br/>
				<input type="date" class="date" name="date" id="date" min="${ LocalDate.now() }"  required="true"/>
				<br/>
				<input type="submit" value="View Bookings" />
			</form>
		</center>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>