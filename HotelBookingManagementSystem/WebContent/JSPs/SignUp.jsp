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
			<form:form method="post" modelAttribute="userBean" action="addUser.obj">
	  		
	  			<label for="name">Name :</label>
		  		<form:input path="name" id="name" type="text" pattern="[A-Za-z ]{3,20}" placeholder="Please enter name" required="true"/><br/>
		  		
		  		<label for="userName">User Name :</label>
		  		<form:input path="userName" id="userName" type="text" pattern="[A-Za-z0-9 ]{6,15}" placeholder="Unique Username" required="true"/><br/>
	  			
		  		<label for="password">Password :</label>
		  		<form:input path="password" id="password" type="password" placeholder="Password" required="true"/><br/>
		  		
		  		<label for="mobileNumber">Mobile Number :</label>
		  		<form:input path="mobileNumber" id="mobileNumber" type="text" placeholder="eg. 7956854745" pattern="[7-9][0-9]{9}" required="true"/><br/>
		  		
		  		<label for="address">Address :</label>
		  		<form:textarea path="address" id="address" type="textarea" placeholder="Please enter your address" pattern="[A-Za-z0-9 ]{5,40}" required="true"/><br/>
		  		
		  		<label for="email">Email ID :</label>
		  		<form:input path="email" id="email" type="text" placeholder="Please enter email" pattern="[A-Za-z0-9._%+-]{1,18}@[a-z0-9.-]{1,7}\.[a-z]{2,3}$" required="true"/><br/>
		  		
		  		<label for="phoneNumber">Phone Number :</label>
		  		<form:input path="phoneNumber" id="phoneNumber" pattern="(^$)|(^[0-9]{10}$)" type="text" placeholder="eg. 7956854745(optional)" /><br/>
		  		
		  		<input type="submit" value="Submit Details"/>
			</form:form>
		</center>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>