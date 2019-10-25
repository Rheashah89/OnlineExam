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
				<form action="deleteQuestion.lti" method="post">
				<td><input type="hidden" name="questionId" value="${question.questionId}">${question.questionId}</input></td>
				<input type="submit" value="Delete">
				</form>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>