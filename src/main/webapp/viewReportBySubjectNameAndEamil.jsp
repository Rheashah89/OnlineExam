<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<thead>
			<tr>
				<th>Question</th>
				<th>Option ID</th>                                                                                                                                	
			</tr>
		</thead>
		<tbody>
			<c:forEach var="answer" items="${answers}">
				<tr>
				<td >${answer.question}</td>
				<td >${answer.selectedId}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>