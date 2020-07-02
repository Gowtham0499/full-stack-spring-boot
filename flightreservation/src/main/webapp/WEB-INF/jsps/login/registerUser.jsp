<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" />
<title>User Registration</title>
</head>
<body>
<div class="container">
	<h2>User Registration</h2>
	<form action="registerUser" method="post" >
		<div class="form-group">
			<label for="firstName">First Name</label> 
			<input type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter your First Name"/> 
		</div>
		<div class="form-group">
			<label for="lastName">Last Name</label> 
			<input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter your Last Name"/> 
		</div>
		<div class="form-group">
			<label for="userName">User Name</label> 
			<input type="email" class="form-control" id="userName" name="email" placeholder="Enter your Email for User Name"/> 
		</div>
		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password" class="form-control" id="password" name="password" placeholder="Enter your Password"/>
		</div>
		<div class="form-group">
			<label for="password">Confirm Password</label> 
			<input type="password" class="form-control" id="password" name="confirmPassword" placeholder="Enter your Password"/>
		</div>
		<br>
		<button type="submit" class="btn btn-primary">Register</button>
	</form>
</div>
</body>
</html>