<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" media="screen" href="./assets/css/main.css" />
    <script src="./assets/js/main.js"></script>
</head>
<body>
<div class="adminreportcard">
    <form action="search.lti" method="post">
      
        <label for="noOfOptions">Select students based on</label>
        <select id="noOfOptions" name="firstselect">
            <option id="op1" value="technology">Technology</option>
            <option id="op2" value="userState">State</option>
            <option id="op3" value="userCity">city</option>
        </select>
    <div  id="technology" style="width:100px;height: 100px;">
        <select class="innerselect" name="secondselect1">
      <%! int i=0; %>
        <c:forEach var="subject" items="${subjects}">
            <option id="opt<% i++; %>" value="${subject.subjectId}">${subject.subjectName}</option>
           </c:forEach>
        </select>
    </div> 
    <div id="userState" style="width:100px;height: 100px;">
        <select class="innerselect"  name="secondselect2">
            <option id="opt1" value="Maharashtra">Maharashtra</option>
            <option id="opt2" value="Rajasthan">Rajasthan</option>
            <option id="opt3" value="Bihar">Bihar</option>
        </select>
    </div>

    <div id="userCity" style="width:100px;height: 100px;">
        <select  class="innerselect" name="secondselect3">
            <option id="opt1" value="Mumbai">Mumbai</option>
            <option id="opt2" value="Pune">Pune</option>
            <option id="opt3" value="Kanpur">Kanpur</option>
        </select>
    </div>
    <div > <input type="submit" value="Search Students"> </div>
    </form>
    <div>
    <form action="searchbystudentname.lti" method="post">
    <input type="text" name="studentEmail" placeholder="Enter Student Email">
    <input type="submit" value="Search" >
    </form>
    </div>
</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){
        $("#technology").show();
        $("#userState").hide();
        $("#userCity").hide();

            $("#noOfOptions").change(function(){
                if($(this).val()=="technology"){
                    $("#technology").show();
        $("#userState").hide();
        $("#userCity").hide();
                }
                else if($(this).val()=="userState"){
                    $("#technology").hide();
        $("#userState").show();
        $("#userCity").hide();
                }
                else if($(this).val()=="userCity"){
                    $("#technology").hide();
        $("#userState").hide();
        $("#userCity").show();
                }
            });
        });
    </script>
</body>
</html>