<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
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
			<h1>Add a new Ninja</h1>
			<h3><a  href="/"> Dashboard </a></h3>
		</header>
	    <br><br>
	    <form:form action="/addpro" method="POST" modelAttribute="product">

		    <p>
		        <form:label path="name">Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		  	</p>
		  	<p>
		        <form:label path="description">Description</form:label>
		        <form:errors path="description"/>
		        <form:input path="description"/>
			</p>
			<p>
		        <form:label path="price">Price</form:label>
		        <form:errors path="price"/>
		        <form:input path="price" type="number"/>
			</p>	    
		    <input type="submit" value="Add Product"/>
		</form:form>
	</article>
</body>
</html>