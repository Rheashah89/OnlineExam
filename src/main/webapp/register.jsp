<html>
<head>
<title>Register Page</title>
<link rel="stylesheet" type="text/css" href="main.css">
<body style=" background:#edd1ff;">
        <div class="loginbox">
                <img src="LoginIcon.png" class="avatar">
                <h1>Please Register</h1>
                <form action="login.jsp">
                <div class="scroll">
                        <p>Full Name</p>
                        <input type="text" name="userName" placeholder="Your Name">
                        <p>Email</p>
                        <input type="text" name="userEmail" placeholder="Your Email">
                        <p>Mobile</p>
                        <input type="text" name="userMobile" placeholder="Your Mobile No.">
                        <p>State</p>
                        <input type="text" name="userState" placeholder="Your State">
                        <p>Date of birth</p>
                        <input type="date" name="userDateOfBirth" placeholder="Your Date of Birth">
                        <p>City</p>
                        <input type="text" name="userCity" placeholder="Your City">
                        <p>Degree</p>
                        <input type="text" name="userDegree" placeholder="Your Degree">
                </div>
                <br><br>
                <div style="width: 50%; margin: 0 auto;">
                <input type="submit" name="register" value="Register">
                </div>
                </form>
        </div>
</body>
</head>
</html>