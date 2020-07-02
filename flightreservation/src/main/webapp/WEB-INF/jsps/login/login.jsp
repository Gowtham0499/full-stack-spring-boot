<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
<div class="container">
	<h2>User Login</h2>
	<form action="login" method="post" >
		<div class="form-group">
			<label for="userName">User Name</label> 
			<input type="email" class="form-control" id="userName" name="email" placeholder="Enter your Email for User Name"/> 
		</div>
		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password" class="form-control" id="password" name="password" placeholder="Enter your Password"/>
		</div>
		<button type="submit" class="btn btn-primary">Login</button>
	</form>
</div>
</body>
</html>