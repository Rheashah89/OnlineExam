<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Add Question</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="./assets/css/main.css" />
        <script src="./assets/js/main.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#boolean").show();
            $("#options3").hide();
            $("#options4").hide();

            $("#noOfOptions").change(function () {
                if ($(this).val() == "boolean") {
                    $("#boolean").show();
                    $("#options3").hide();
                    $("#options4").hide();
                }
                else if ($(this).val() == "options3") {
                    $("#boolean").hide();
                    $("#options3").show();
                    $("#options4").hide();
                }
                else if ($(this).val() == "options4") {
                    $("#boolean").hide();
                    $("#options3").hide();
                    $("#options4").show();
                }
            });
        });

       

    </script>
</head>
<body>

	<div class="topnav">
		<a class="active" href="admin.jsp">Home</a>
		<a href="about_us.jsp" action = "about_us.jsp">About Us</a>
        <a style="float:right" href="profile.jsp" action = "profile.jsp">Profile</a>
        <a style="float:right" href="logout.lti">Logout</a></a>
	</div>
	
      <form action="" method="POST">
      <table>
      <tr>
     <div>
        <div>
        <h3>Add New Question </h3>
        <table>
        <tr>
                <td>
                    <label>Select Subject:</label>
                </td>
                <td colspan="4">
                    <select class="innerselect" name="subjectname" style="width: 300px">
      <%! int i=0; %>
        <c:forEach var="subject" items="${subjects}">
            <option id="opt<% i++; %>" value="${subject.subjectId}">${subject.subjectName}</option>
           </c:forEach>
        </select>
                </td>
            </tr>
             <tr>
                <td>
                    <label>Select Level:</label>
                </td>
                <td colspan="4">
                    <input type="text" name="subjectlevel" class="text" placeholder="Enter Subject Level" style="width: 420px;">
                </td>
            </tr>
            
            <tr>
                <td>
                    <label>Your Question:</label>
                </td>
                <td colspan="4">
                    <input type="text" name="question" class="text" placeholder="Type your question here" style="width: 420px;">
                </td>
            </tr>
        </table>
        </div>

        <div>
            <label for="noOfOptions">Select Number of options</label>
            <select id="noOfOptions">
                <option id="op1" value="boolean">True/False</option>
                <option id="op2" value="options3">3 Options</option>
                <option id="op3" value="options4">4 Options</option>
            </select>
        </div>

        <div id="boolean" style="width:100px;height: 100px;">
            <table>
                <tr>
                   <td> option1: <input type="text" name="options1" class="text" placeholder="First Option" style="width: 130px;"></td>
                   <td> Correct Answer:<input type="text" name="CorrectAns1" class="text" placeholder="Correct Answer" style="width: 130px;"></td>
                </tr>
                <tr>
                    <td> option2: <input type="text" name="options2" class="text" placeholder="Second Option" style="width: 130px;"></td>
                    <td> Correct Answer:<input type="text" name="CorrectAns2" class="text" placeholder="Correct Answer" style="width: 130px;"></td>
                </tr>
            </table>
        </div>

        <div id="options3" style="width:100px;height: 100px;">
                <table>
                        <tr>
                           <td> option1: <input type="text" name="options1" class="text" placeholder="First Option" style="width: 130px;"></td>
                           <td> Correct Answer:<input type="text" name="CorrectAns1" class="text" placeholder="Correct Answer" style="width: 130px;"></td>
                        </tr>
                        <tr>
                            <td> option2: <input type="text" name="options2" class="text" placeholder="Second Option" style="width: 130px;"></td>
                            <td> Correct Answer:<input type="text" name="CorrectAns2" class="text" placeholder="Correct Answer" style="width: 130px;"></td>
                        </tr>
                        <tr>
                            <td> option3: <input type="text" name="options3" class="text" placeholder="Third Option" style="width: 130px;"></td>
                            <td> Correct Answer:<input type="text" name="CorrectAns3" class="text" placeholder="Correct Answer" style="width: 130px;"></td>
                        </tr>
                             
                    </table>
        </div>

        <div id="options4" style="width:100px;height: 100px;">
            <table>
                <tr>
                    <td> option1: <input type="text" name="options1" class="text" placeholder="First Option" style="width: 130px;"></td>
                    <td> Correct Answer:<input type="text" name="CorrectAns1" class="text" placeholder="Correct Answer" style="width: 130px;"></td>
                </tr>
                <tr>
                    <td> option2: <input type="text" name="options2" class="text" placeholder="Second Option" style="width: 130px;"></td>
                    <td> Correct Answer:<input type="text" name="CorrectAns2" class="text" placeholder="Correct Answer" style="width: 130px;"></td>
                </tr>
                <tr>
                    <td> option3: <input type="text" name="options3" class="text" placeholder="Third Option" style="width: 130px;"></td>
                    <td> Correct Answer:<input type="text" name="CorrectAns3" class="text" placeholder="Correct Answer" style="width: 130px;"></td>
                </tr>
                <tr>
                    <td> option4: <input type="text" name="options4" class="text" placeholder="Fourth Option" style="width: 130px;"></td>
                    <td> Correct Answer:<input type="text" name="CorrectAns4" class="text" placeholder="Correct Answer" style="width: 130px;"></td>
                </tr>   
            </table>   
        
    </div>
    </div> 
    </tr>
    
    <tr>
<div > <cneter><input type ="submit" value="AddQuestion"></cneter></div> 
</tr>
</table>


        
</form> 
</body>
</html>