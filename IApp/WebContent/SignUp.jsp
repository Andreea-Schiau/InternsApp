<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Take a breath</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="css/global.css" href="text/css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link href="css/global.css" href="text/css" rel="stylesheet">
<meta charset="ISO-8859-1">
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-4 col-md-3 col-sm-4 col-xs-12"></div>
			<div class="col-lg-4 col-md-6 col-sm-4 col-xs-12">
				<div class="color">
					<form class="form-containter usernameForm" action="signUp"
						method="post">
						<h1>Create an account</h1>
						<div class="form-group">
							<label for="exampleInputEmail1">Email address</label> <input
								type="email" class="form-control input-lg" id="txtUsername"
								aria-describedby="emailHelp" placeholder="Enter email"
								name="email">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" class="form-control input-lg" id="txtPassword"
								placeholder="Password" name="password">
						</div>
						<div class="form-group form-check">
							<input type="checkbox" class="form-check-input"
								id="exampleCheck1"> <label class="form-check-label"
								for="exampleCheck1">Remember me</label>
						</div>
						<button type="submit" class="btn btn-success btn-block"
							id="btnCheck">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>