<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Remove Question</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script src="main.js"></script>
</head>
<body>
	<div class="topnav">
		<a class="active" href="admin.html">Home</a>
		<a href="about_us.jsp" action = "about_us.jsp">About Us</a>
        <a style="float:right" href="profile.jsp" action = "profile.jsp">Profile</a>
        <a style="float:right" href="logout.lti">Logout</a></a>
	</div>

  	<table border="1">
		<thead>
			<tr>                                                                                                                                
				<th>Question</th>
			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="question" items="${questions}">
			<tr>
				<td>${question.question}</td>
				
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>