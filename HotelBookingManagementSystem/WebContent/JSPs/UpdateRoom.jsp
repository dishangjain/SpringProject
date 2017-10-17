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
		<form:form method="post" action="updateRoom.obj">
			<select name="roomID">
					<c:forEach items="${roomList }" var="room">
						<option value="${room.roomID }">${room.roomID }</option>
					</c:forEach>
			</select>
			<br>
			<select name="attributeOption">
				<option value="1">Room Number</option>
				<option value="2">Room Type</option>
				<option value="3">Cost/Night</option>
				<option value="4">Photo</option>
			</select>
			<br>
			Enter Value : <input name="attributeValue" type="text">
			<input type="submit" value="Confirm Changes"/>
		</form:form>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>