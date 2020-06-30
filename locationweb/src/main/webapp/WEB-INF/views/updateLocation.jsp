<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" />
<title>Edit Location</title>
</head>
<body>
<div class="container">
		<form action="updateLocation" method="post">
			<div class="row mb-3">
				<label for="id" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="id" name="id" value="${location.id}" readonly="readonly">
				</div>
			</div>
			<div class="row mb-3">
				<label for="code" class="col-sm-2 col-form-label">Code</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="code" name="code" value="${location.code}">
				</div>
			</div>
			<div class="row mb-3">
				<label for="name" class="col-sm-2 col-form-label">Name</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name" value="${location.name}">
				</div>
			</div>
			<fieldset>
				<div class="row mb-3">
					<legend class="col-form-label col-sm-2 pt-0">Type</legend>
					<div class="col-sm-10">
						<div class="form-check">
							<input class="form-check-input" type="radio" name="type" id="urban" value="URBAN" ${location.type=='URBAN'?'checked':''}> 
							<label class="form-check-label" for="urban"> Urban
							</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="type" id="rural" value="RURAL" ${location.type=='RURAL'?'checked':''}> 
							<label class="form-check-label" for="rural"> Rural
							</label>
						</div>
					</div>
				</div>
			</fieldset>
			<button type="submit" class="btn btn-primary">Save</button>
		</form>
	</div>
</body>
</html>