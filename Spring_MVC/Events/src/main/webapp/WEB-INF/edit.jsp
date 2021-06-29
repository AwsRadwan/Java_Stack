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
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
	body {
		background-color: rosybrown;
        padding: 20px;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<h1>
		<c:out value="${event.name}"></c:out>
	</h1>
	<br />
	
	<h2>Edit Event</h2>
	<form:form method="POST" action="/events/${event.id}/edit" modelAttribute="event">
		<div class="form-group">
	<form:label path="name">Name</form:label>
	<form:errors path="name"></form:errors>
	<form:input path="name" class="form-control" placeholder="Name" required="true"></form:input>
	</div>
	<br />
	<div class="form-group">
	<form:label path="date">Date</form:label>
	<form:errors path="date"></form:errors>
	<form:input type="date" path="date" class="form-control" placeholder="Date" required="true"></form:input>
	</div>
	<br />
	<div class="form-group">
	<form:label path="city">Location:</form:label>
	<form:errors path="city"></form:errors>
	<form:input path="city" class="form-control" placeholder="City" required="true"></form:input>
	<br><br>
	<form:select path="state" class="form-control" placeholder="State" required="true">
		<form:option value="State" selected="true">State</form:option>
		<form:options items="${states}"/>
	</form:select>
	</div>
	<br />
	<input type="submit" value="Create Event" class="btn btn-primary"/>
	</form:form>
</body>
</html>