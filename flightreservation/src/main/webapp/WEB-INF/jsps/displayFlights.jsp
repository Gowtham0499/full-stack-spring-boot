<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" />
<title>Flights</title>
</head>
<body>
	<div class="container">
		<h2>Available Flights</h2>
		<table class="table table-hover">
			<tr>
				<th>Airlines</th>
				<th>Departure City</th>
				<th>Arrival City
				<th>Departure Time</th>
			</tr>
			<c:forEach items="${flights}" var="flight">
				<tr>
					<td>${ flight.operatingAirlines }</td>
					<td>${ flight.departureCity }</td>
					<td>${ flight.arrivalCity }</td>
					<td>${ flight.estimatedDepartureTime }</td>
					<td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>