<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<style>
		body {
			background-color: rosybrown;
        	padding: 20px;
		}
		.ttt {
			padding: 20px;
			width: 400px;
		}
	</style>
</head>
<body>
	<div class="ttt">
	<h2>Edit Course</h2>
	<br>
	<form:form method="POST" action="/courses/${course.id}/edit" modelAttribute="course">
	<div class="form-group">
		<form:label path="name">Name: </form:label>
		<form:errors path="name"></form:errors>
		<form:input path="name" class="form-control" placeholder="Name" required="true"></form:input>
		</div>
		<br />
		<div class="form-group">
		<form:label path="instructer">Instructor: </form:label>
		<form:errors path="instructer"></form:errors>
		<form:input path="instructer" class="form-control" placeholder="Instructor" required="true"></form:input>
		</div>
		<br />
		<div class="form-group">
		<form:label path="capacity">Capacity:</form:label>
		<form:errors path="capacity"></form:errors>
		<form:input type="number" path="capacity" class="form-control" placeholder="Capacity" required="true"></form:input>
		<br><br>
		</div>
		<br />
		<input type="submit" value="Edit Course" class="btn btn-primary"/>
	</form:form>
	</div>
</body>
</html>