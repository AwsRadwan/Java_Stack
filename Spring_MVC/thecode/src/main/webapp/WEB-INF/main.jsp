<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	body {
		display: flex;
	}
	div {
		text-align: center;
		background-color: green;
		padding: 20px;
		width: fit-content;
		margin: auto;
		
	}
</style>
</head>
<body>
	<div>
		<h2> Your Password: </h2> <br>
		<p> <c:out value="${error}"/> </p>
		<form action="/result" method="post">
			<input name="password" type="password" required> <br><br>
			<input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>