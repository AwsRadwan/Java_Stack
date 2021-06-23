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
	header {
		display: flex;
	}
	h1 {
		flex: 1;
	}
	h3 {
		flex: 1;
	}
</style>
</head>
<body>
	<article>
		<header>
			<h1>Add a new Person</h1>
			<h3><a  href="/"> Dashboard </a></h3>
		</header>
	    <br><br>
	    <form:form action="/addnewp" method="POST" modelAttribute="person">
		    <p>
		        <form:label path="firstName">First Name</form:label>
		        <form:errors path="firstName"/>
		        <form:input path="firstName"/>
		  	</p>
		  	<p>
		        <form:label path="lastName">Last Name</form:label>
		        <form:errors path="lastName"/>
		        <form:input path="lastName"/>
			</p>    
		    <input type="submit" value="Add Person"/>
		</form:form>
	</article>
</body>
</html>