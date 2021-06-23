<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	h2 {
		float: right;
	}
	article {
		display: flex;
		width: 500px;
		margin: auto;
	}
	section {
		flex: 1;
	}
	form {
		display: bluck;
	}
</style>
</head>
<body>
<br><br>
	<h2><a href="/"> Dashboard</a></h2>
	<br><br>
	<article>
		<section>
			<h3>First Name: </h3>
			<h3>Last Name: </h3>
			<h3>License Number: </h3>
			<h3>State: </h3>
			<h3>Expiration Date: </h3>
		</section>
		<section>
			<h3>${person.firstName} </h3>
			<h3>${person.lastName} </h3>
			<h3>${person.license.number} </h3>
			<h3>${person.license.state} </h3>
			<h3>${person.license.expirationDate} </h3>
		</section>
		<br>
		<br>
	</article>
</body>
</html>