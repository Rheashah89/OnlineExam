<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" media="screen" href="./assets/css/main.css" />
<title>Insert title here</title>
</head>
<body>
<div class="topnav">
		<a class="active" href="admin.jsp">Home</a> <a href="about_us.jsp">About
			Us</a> <a style="float: right" href="login.jsp">Logout</a>
	</div>
<table border="1">
		<thead>
			<tr>
				<th>Question</th>                                                                                                                               
				<th>Selected Option</th>
			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="question" items="${questions}">
			<tr>
				<td>${question.question}</td>
			<c:forEach var="option" items="${question.options}">
				<c:if test="${option.selected}">
				<td>${option.option}</td>
				</c:if>
			</c:forEach>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>