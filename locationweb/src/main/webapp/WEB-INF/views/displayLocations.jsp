<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" />
<title>Display Locations</title>
</head>
<body>
	<div class="container">
		<h2>Locations</h2>
		<table class="table table-hover">
			<tr>
				<th>Id</th>
				<th>Code</th>
				<th>Name</th>
				<th>Type</th>
			</tr>
			<c:forEach items="${locations}" var="location">
				<tr>
					<td>${location.id}</td>
					<td>${location.code}</td>
					<td>${location.name}</td>
					<td>${location.type}</td>
					<td><a href="showUpdate?id=${location.id}" class="btn btn-info" >Edit</a></td>
					<td><a href="deleteLocation?id=${location.id}" class="btn btn-danger" >Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="showCreate" class="btn btn-default">Add Location</a>
	</div>
</body>
</html>