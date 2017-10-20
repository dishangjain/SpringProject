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
		<script src="assets/js/roomUpdation.js" type="text/javascript"></script>
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<center>
			<form:form method="post" action="updateRoom.obj">
				<label>Room ID for which information to be Updated</label><br/>
				<select name="roomID" required="true">
						<c:forEach items="${ roomList }" var="room">
							<option value="${ room.roomID }">${ room.roomID }</option>
						</c:forEach>
				</select>
				<br>
				<label>Update Parameter</label><br/>
				<select name="attributeOption" onchange="addValueBox()">
					<option value="1">Room Number</option>
					<option value="2">Room Type</option>
					<option value="3">Cost/Night</option>
					<option value="4">Photo</option>
				</select>
				<br>
				<p id="p">
					<label>Enter Room Number </label><br/><input name="attributeValue" placeholder="eg. 000" type="text" required="true" pattern="[0-9]{3}"/>
				</p>
				<br>
				<input type="submit" value="Confirm Changes"/>
			</form:form>
		</center>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>