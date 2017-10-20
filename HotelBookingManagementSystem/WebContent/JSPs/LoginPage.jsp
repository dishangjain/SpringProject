<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<br><br>
		
		<form method="post" action="getFunctionalities.obj">
			<center><h4>${ invalidMessage }</h4></center>
			<div class="row uniform" align="center">
				<div class="6u 12u$(xsmall)">
					<label for="userName">User Name : </label>
					<input type="text" name="userName" id="userName" placeholder="Enter User Name" pattern="[A-Za-z0-9 ]{6,15}" placeholder="Username" required="true"/>
				</div>
				<div class="6u 12u$(xsmall)">
					<label for="password">Password : </label>
					<input type="password" name="password" id="password" placeholder="Enter Password" maxlength="32" required="true" placeholder="Password"/>
				</div>
				<div class="12u$" align="center">
					<ul class="actions">
						<li><input type="submit" value="Sign In" class="special" /></li>
						<li><input type="reset" value="Reset" /></li>
					</ul>
				</div>
			</div>
		</form>
		<div class="box alt">
			<div class="row uniform">
				<div class="4u"><span class="image fit"><img src="images/pic02.jpeg" alt="" /></span></div>
				<div class="4u"><span class="image fit"><img src="images/pic03.jpeg" alt="" /></span></div>
				<div class="4u"><span class="image fit"><img src="images/pic01.jpeg" alt="" /></span></div>
			</div>
		</div>
			<jsp:include page="footer.jsp"></jsp:include>
			<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
		
	</body>
</html>