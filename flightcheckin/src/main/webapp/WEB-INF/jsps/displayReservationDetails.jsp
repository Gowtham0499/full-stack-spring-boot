<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" />
<title>Reservation Details</title>
</head>
<body>
	<div class="container">
		<h2>Flight Details</h2><br>
		Airlines: ${reservation.flight.operatingAirlines}<br>
		Flight No: ${reservation.flight.flightNumber}<br>
		Departure City: ${reservation.flight.departureCity}<br>
		Arrival City: ${reservation.flight.arrivalCity}<br>
		Date of Departure: ${reservation.flight.dateOfDeparture}<br>
		Estimated Departure Time: ${reservation.flight.estimatedDepartureTime}<br>
		<br>
		
		<h2>Passenger Details</h2><br>
		First Name: ${reservation.passenger.firstName}<br>
		Last Name: ${reservation.passenger.lastName}<br>
		Email: ${reservation.passenger.email}<br>
		Phone: ${reservation.passenger.phone}<br>
		
		<br>
		<form action="completeCheckIn" method="post">
			<div class="form-group">
				<label for="numberOfBags">Enter the number of bags you want to check in</label> 
				<input type="number" class="form-control" id="numberOfBags" name="numberOfBags"/>
			</div>
			<input type="hidden" value="${reservation.id}" name="reservationId"/>
			<br>
			<button type="submit" class="btn btn-primary">CheckIn</button>
		</form>
	</div>
</body>
</html>