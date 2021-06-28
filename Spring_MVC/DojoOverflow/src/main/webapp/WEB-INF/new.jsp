<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	input {
		flout: right;
	}
	main {
		margin: auto;
		text-align: center;
	}
</style>
</head>
<body>
<br><br><br><br>
	<main>
		<h1>What is your Question ??</h1>
		<br><br>
		<form:form action="/add_q" method="POST" modelAttribute="ques">
		    <p>
		        <form:label path="question">Your Question: </form:label>
		        <form:errors path="question"/>
		        <form:input path="question"/>
		  	</p>
		  	<p>
		  		<label>Tags: </label>
		        <input name="tag" type="text">
			</p>
			<br>
		    <input type="submit" value="Add Question"/>
		</form:form>
	</main>
</body>
</html>