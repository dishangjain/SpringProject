<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		
		
		<form:form method="post" action="hotelBookingByID.do">
			<select name="hotelID">
					<c:forEach items="${ hotelList }" var="hotel">
						<option value="${hotel.hotelID }">${hotel.hotelName }</option>
					</c:forEach>
			</select>
			
			<input type="submit" value="View Bookings"/>
			
		</form:form>
	
	</body>
</html>