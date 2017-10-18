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
		<div class="row" >
			<div class="6u 12u$(medium)">
				<ul class="alt">
					<li><a href="getCity.obj">Search Hotels</a></li>
					<li><a href="showBookingStatus.obj">View Booking Status</a></li>
				</ul>
			</div>
		</div>
		
		<div class="row uniform">
			<p>
				<span class="image left"><img src="images/hotel03.jpeg" alt="" /></span>
				Greetings from Travel-R bUddY. Explore warm hospitality and Quality served here at reasonable rates.  
			</p>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>