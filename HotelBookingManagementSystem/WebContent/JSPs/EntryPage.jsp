<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add employee</title>
		<script type="text/javascript" src="scripts/jquery-1.12.3.js"></script>
		<script type="text/javascript" src="scripts/MyJsLib.js"></script>
	</head>
	<body>
		<sf:form method="post" modelAttribute="employee" action="submitEmpDetails.do">
			<label for="empNm">Enter Name:</label> 
			<sf:input path="empNm" id="empNm" type="text" pattern="[A-Z]{3,}"/><br/>
			
			<label for="empSal">Enter Salary:</label> 
			<sf:input path="empSal" id="empSal" type="text"/><br/>
			
			<label for="hireDate">Enter Date of joining:</label> 
			<sf:input path="hireDate" id="hireDate" type="text"/><br/>
			
			<input type="submit" value="Add Employee"/>
		</sf:form>
	</body>
</html>