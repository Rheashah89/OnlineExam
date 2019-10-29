<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.lti.model.User"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Record</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>                                                                                                                                
				<th>User Name</th>
				<th>Date Of Birth</th>
			    <th>Mobile number</th>
				<th>Email</th>
				<th>Degree</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.userName}</td>
				<td>${user.userDateOfBirth}</td>
				<td>${user.userMobile}</td>
				<td>${user.userEmail}</td>
				<td>${user.userDegree}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>