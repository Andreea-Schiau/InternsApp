<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="css/global.css" href="text/css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css"
	rel="stylesheet">
<link href="css/global.css" href="text/css" rel="stylesheet">

<title>Insert title here</title>
</head>
<%@ page import="java.io.PrintWriter"%>
<%@page import="java.sql.*,java.util.*"%>

<%
	Object message = request.getAttribute("email");
%>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand nav-item" href="#">Interns list</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item"><a
						class="nav-link disabled glyphicon glyphicon-user iconitaProfil"
						href="#" tabindex="-1" aria-disabled="true"><%=message%></a></li>
				</ul>
			</form>
		</div>
	</nav>
	<%
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/internship", "root",
					"root");
			System.out.println("Database was Connected");
			Statement students = connection.createStatement();
			ResultSet rs = students.executeQuery("SELECT * FROM intern");

			String users = "";
			while (rs.next()) {
				users = rs.getString("id");
				System.out.print(users + "\n");
			}
			if (users.equals("")) {
				System.out.println("Nu exista acest username");
			}
		} catch (Exception e) {
			System.out.print(e);

			Object idul = request.getAttribute("id");

		}
	%>
	
</body>
</html>