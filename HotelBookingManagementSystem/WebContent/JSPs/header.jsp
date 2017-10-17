<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<header id="header">
		<h2>Travel-R bUddY </h2>
	<nav>
		<ul>
			<li><a href="${ home }">Home</a></li>
			<% 
				if(session.getAttribute("userBean") != null){
					out.println("<li><a href='logOut.obj'>Log Out</a></li>");
				} 
			%>
		</ul>
	</nav>
</header>
<div align="right">
	<span style="margin-right:2px">${ message }</span>
</div>