<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Employee List</title>
		<script type="text/javascript" src="scripts/jquery-1.12.3.js"></script>
		<script type="text/javascript" src="scripts/MyJsLib.js"></script>
	</head>
	<body>
		<h1>Capgemini India Pvt. Ltd.</h1>
		<h3>${ pageHead }</h3>
		
		<table border="1">
			<tr>
				<th>Employee Number</th>
				<th>Employee Name</th>
				<th>View Details</th>
			</tr>
			<c:forEach items="${ empList }" var="emp">
				<tr>
					<td>${ emp.empNo }</td>
					<td> ${ emp.empNm }</td>
					<td><a href="getEmpDetails.do?empNo=${ emp.empNo }">View Details</a>
				</tr>
			</c:forEach>
		</table>
		<a href="getHomePage.do">Home Page</a>
	</body>
</html>