<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Search Students</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--  <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script src="main.js"></script>-->
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
    
    <div  id="technology" style="width:100px;height: 100px;">
        <select class="innerselect" name="technology">
            <option id="opt1" value="1">java</option>
            <option id="opt2" value="2">sql</option>
            <option id="opt3" value="3">php</option>
        </select>
    </div>
    <div id="state" style="width:100px;height: 100px;">
        <select class="innerselect"  name="state">
            <option id="opt1" value="maharashtra">Maharashtra</option>
            <option id="opt2" value="Rajasthan">Rajasthan</option>
            <option id="opt3" value="Bihar">Bihar</option>
        </select>
    </div>

    <div id="city" style="width:100px;height: 100px;">
        <select  class="innerselect" name="city">
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
        $("#technology").hide();
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