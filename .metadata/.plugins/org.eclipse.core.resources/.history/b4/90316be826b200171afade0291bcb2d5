<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Update employee details</title>
		<script type="text/javascript" src="scripts/jquery-1.12.3.js"></script>
		<script type="text/javascript" src="scripts/MyJsLib.js"></script>
	</head>
	<body>
		<h1>Capgemini India Pvt. Ltd.</h1>
		<h3>${ pageHead }</h3>
		
		<form action="submitNewEmpName.do">
			<label for="empNo">Select an ID number : </label>
			<select name = "empNo" id="empNo">
				<c:forEach items="${ idList }" var="empNo">
					<option value="${ empNo }">${ empNo }</option>
				</c:forEach>
			</select><br/>
			<label for="newName">Enter the new name :</label>
			<input type="text" name="newName" id="newName"><br/>
			<input type="submit" value="Update">
		</form>
	</body>
</html>