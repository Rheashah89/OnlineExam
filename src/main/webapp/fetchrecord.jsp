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
        <select id="noOfOptions">
            <option id="op1" value="technology">Technology</option>
            <option id="op2" value="state">State</option>
            <option id="op3" value="city">city</option>
        </select>
    </form action="search.lti" method="post">
    <div  id="technology" style="width:100px;height: 100px;">
        <select class="innerselect" name="Technology">
      <%! int i=0; %>
        <c:forEach var="subject" items="${subjects}">
            <option id="opt<% i++; %>>" value="${subject.subjectId}">${subject.subjectName}</option>
           </c:forEach>
        </select>
    </div>
    <div id="state" style="width:100px;height: 100px;">
        <select class="innerselect"  name="State">
            <option id="opt1" value="1">Maharashtra</option>
            <option id="opt2" value="2">Rajasthan</option>
            <option id="opt3" value="3">UP Bihar Lutne</option>
        </select>
    </div>

    <div id="city" style="width:100px;height: 100px;">
        <select  class="innerselect" name="City">
            <option id="opt1" value="1">Mumbai</option>
            <option id="opt2" value="2">Pune</option>
            <option id="opt3" value="3">Kanpur</option>
        </select>
    </div>
    <div > <input type="submit" value="Search Students"> </div>
    </form>
</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){
        $("#technology").show();
        $("#state").hide();
        $("#city").hide();

            $("#noOfOptions").change(function(){
                if($(this).val()=="technology"){
                    $("#technology").show();
        $("#state").hide();
        $("#city").hide();
                }
                else if($(this).val()=="state"){
                    $("#technology").hide();
        $("#state").show();
        $("#city").hide();
                }
                else if($(this).val()=="city"){
                    $("#technology").hide();
        $("#state").hide();
        $("#city").show();
                }
            });
        });
    </script>
</body>
</html>