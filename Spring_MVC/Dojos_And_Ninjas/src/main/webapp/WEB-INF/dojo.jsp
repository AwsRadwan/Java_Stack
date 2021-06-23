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
			<h1>Add a new Dojo</h1>
			<h3><a  href="/"> Dashboard </a></h3>
		</header>
	    <br><br>
	    <form:form action="/adddojo" method="POST" modelAttribute="dojo">
		    <p>
		        <form:label path="name">Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		  	</p> 
		    <input type="submit" value="Add Dojo"/>
		</form:form>
	</article>
</body>
</html>