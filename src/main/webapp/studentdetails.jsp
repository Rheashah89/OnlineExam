<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
				<th>Subject ID</th>
				<th>Exam ID</th>                                                                                                                                
				<th>Subject Name</th>
				<th>Current Level</th>
				
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="exam" items="${exams}">
			
				<form action="viewReportBySubjectNameAndEmail.lti" method="post">
				<tr>
				<td name="subjectId">${exam.subject.subjectId}</td>
				<td name="examId" value="${exam.examId}">${exam.examId}</td>
				<td name="subjectName">${exam.subject.subjectName}</td>
				<td name="currentLevel">${exam.currentLevel }</td>
				<td><input type="submit" value="View Report"></td>
				</tr>
				</form>
			
			</c:forEach>
		</tbody>
	</table>
</body>
</html>