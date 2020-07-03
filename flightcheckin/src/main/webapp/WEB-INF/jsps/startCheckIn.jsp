<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" />
<title>Start Check In</title>
</head>
<body>
	<div class="container">
	<h2>Start CheckIn</h2>
		<form action="startCheckIn" method="post">
			<div class="form-group">
				<label for="reservationId">Enter your Reservation Id</label> 
				<input type="number" class="form-control" id="reservationId" name="reservationId"/>
			</div>
			<br>
			<button type="submit" class="btn btn-primary">Start CheckIn</button>
		</form>
	</div>
</body>
</html>