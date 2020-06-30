<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" />
<title>Create Location</title>
</head>
<body>
	<div class="container">
		<form action="saveLocation" method="post" >
			<div class="row mb-3">
				<label for="id" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="id" name="id">
				</div>
			</div>
			<div class="row mb-3">
				<label for="code" class="col-sm-2 col-form-label">Code</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="code" name="code">
				</div>
			</div>
			<fieldset>
				<div class="row mb-3">
					<label for="type" class="col-sm-2 col-form-label">Type</label>
					<div class="col-sm-10">
						<div class="form-check">
							<input class="form-check-input" type="radio" name="urban" id="urban" value="urban"> 
							<label class="form-check-label" for="urban"> Urban </label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="rural" id="rural" value="rural"> 
							<label class="form-check-label" for="rural"> Rural </label>
						</div>
					</div>
				</div>
			</fieldset>
			<button type="submit" class="btn btn-primary">Save</button>
		</form>
		${msg}
	</div>
</body>
</html>