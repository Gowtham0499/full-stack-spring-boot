<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" />
<title>Complete Reservation</title>
</head>
<body>
	<div class="container">
		<h2>Complete Reservation</h2>
		<br>
		<h6>Airline: ${flight.operatingAirlines}</h6>
		<h6>Departure City: ${flight.departureCity}</h6>
		<h6>Arrival City: ${flight.arrivalCity}</h6>
		<br>

		<form action="completeReservation" method="post">
		<h2>Passenger Details</h2>
			<div class="form-group">
				<label for="firstName">First Name</label> 
				<input type="text" class="form-control" id="firstName" name="passengerFirstName" placeholder="Enter your First Name" />
			</div>
			<div class="form-group">
				<label for="lastName">Last Name</label> 
				<input type="text" class="form-control" id="lastName" name="passengerLastName" placeholder="Enter your Last Name" />
			</div>
			<div class="form-group">
				<label for="email">Email</label> 
				<input type="text" class="form-control" id="email" name="passengerEmail" placeholder="Enter your Email" />
			</div>
			<div class="form-group">
				<label for="phone">Phone</label> 
				<input type="number" class="form-control" id="phone" name="passengerPhone" placeholder="Enter your Phone Number" />
			</div>
			<br>
			<h2>Card Details</h2>
			<div class="form-group">
				<label for="cardName">Name on the Card</label> 
				<input type="text" class="form-control" id="cardName" name="nameOnTheCard" />
			</div>
			<div class="form-group">
				<label for="cardNumber">Card Number</label> 
				<input type="text" class="form-control" id="cardNumber" name="cardNumber" />
			</div>
			<div class="form-group">
				<label for="expiryDate">Expiration Date</label> 
				<input type="text" class="form-control" id="expiryDate" name="expirationDate" />
			</div>
			<div class="form-group">
				<label for="cvv">CVV</label> 
				<input type="text" class="form-control" id="cvv" name="securityCode" />
			</div>
			<br>
			<input type="hidden" name="flightId" value="${ flight.id }" />
			<button type="submit" class="btn btn-primary">Confirm</button>
		</form>

	</div>
</body>
</html>