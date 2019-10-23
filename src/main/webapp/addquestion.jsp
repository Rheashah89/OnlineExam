<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Question</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script src="main.js"></script>
</head>
<body>
    <div class="form">
    <div>Select Subject: <input type="text" name="test">   </div>
    <div>Select Level: <input type="text" name="file">   </div>

    <div class="panel form-style-6" style="max-width: 420!important;float: right">   
            <form action="controller.jsp" >
                <div class="title">Add New Question </div>
                <table >
                    <tr>
                        <td><label>Course Name</label></td>
                        <td colspan="3"> 
                           <select name="coursename" class="text">
    
         </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label>Your Question:</label></td>
                        <td colspan="4"><input type="text" name="question" class="text" placeholder="Type your question here" style="width: 420px;" ></td><br>
                    </tr>
                    <tr>
                        <td><label>Options</label></td>
                        <td><input type="text" name="opt1" class="text" placeholder="First Option" style="width: 130px;" ></td>
                        <td><input type="text" name="opt2" class="text" placeholder="Second Option" style="width: 130px;" ></td>
                        <td><input type="text" name="opt3" class="text" placeholder="Third Option" style="width: 130px;" ></td>
                        <td><input type="text" name="opt4" class="text" placeholder="Fourth Option" style="width: 130px;" ></td>
                    </tr>
                    <tr>
                        <td><label>Correct Answer</label></td>
                        <td colspan="4"><center><input type="text" name="correct" class="text" placeholder="Correct Answer" style="width: 130px;" ></center></td>
                    <tr>
                        <td colspan="5"><input type="hidden" name="page" value="questions">
                 <input type="hidden" name="operation" value="addnew">
                    <center><input type="submit" class="form-button" value="Add" name="submit"></center></td>
                        
                </tr>
                </table>
 
             </form>
        
 

    <div><a href="ques_add.jsp"><button>NEXT</button></a>  </div>
    </div>
</body>
</html>