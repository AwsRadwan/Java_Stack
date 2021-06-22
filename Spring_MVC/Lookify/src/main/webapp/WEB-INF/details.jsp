<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h2><a href="/dashboard"> Dashboard</a></h2>
	<br><br>
	<article>
		<section>
			<h3>Title: </h3>
			<h3>Artist: </h3>
			<h3>Rate (1 - 10): </h3>
		</section>
		<section>
			<h3>${song.title} </h3>
			<h3>${song.artist} </h3>
			<h3>${song.rate} </h3>
		</section>
		<br>
		<br>
			<form action="/songs/${song.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
			</form>
	</article>
</body>
</html>