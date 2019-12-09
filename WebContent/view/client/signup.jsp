<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
	
	<c:url value="/static/client/css/signup.css" var="logincss"></c:url>
	<link href="${logincss}" rel="stylesheet" type="text/css" media="all">
	
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- phai co link phia duoi nay nhe -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>
    
</head>
<body>

	<form style="border:1px solid #ccc">
        <div class="container">
            
            <c:url value="/static/client/images/slides/1.jpg" var="imagelogin"></c:url>
                    <img src="${imagelogin}" />
            <h1>Sign Up</h1>
            <p>Please fill in this form to create an account.</p>
            <hr>
            <label for="Username"><b>Username</b></label>
            <input type="text" placeholder="Enter username" name="Username" required>

            <label for="psw"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required>
			
			<label for="Username"><b>Name</b></label>
            <input type="text" placeholder="Enter Address" name="Username" required>
			
			<label for="Username"><b>Address</b></label>
            <input type="text" placeholder="Enter Address" name="Username" required>
            
            <label for="Username"><b>Phone Number</b></label>
            <input type="text" placeholder="Enter phonenumber" name="Username" required>

            <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

            <div class="clearfix">
                <button type="button" class="cancelbtn">Cancel</button>
                <button type="submit" class="signupbtn">Sign Up</button>
            </div>
        </div>
    </form>
	
	<c:url value="/static/client/js/login.js" var="test"></c:url>
    <script src="${test}"></script>
</body>


</html>
