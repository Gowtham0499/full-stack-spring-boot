<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" />
<title>Find Flights</title>
</head>
<body>
<div class="container">
	<h2>Find Flights</h2>
	<form action="findFlights" method="post" >
		<div class="form-group">
			<label for="from">From</label> 
			<input type="text" class="form-control" id="from" name="from"/> 
		</div>
		<div class="form-group">
			<label for="to">To</label> 
			<input type="text" class="form-control" id="to" name="to"/> 
		</div>
		<div class="form-group">
			<label for="departureDate">Departure Date</label> 
			<input type="text" class="form-control" id="departureDate" name="departureDate" placeholder="MM-dd-yyyy"/> 
		</div>
		<br>
		<button type="submit" class="btn btn-primary">Search</button>
	</form>
</div>
</body>
</html>