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
			<h1>Add a new Song</h1>
			<h3><a  href="/dashboard"> Dashboard </a></h3>
		</header>
	    <br><br>
	    <form:form action="/addnew" method="POST" modelAttribute="song">
		    <p>
		        <form:label path="title">Name</form:label>
		        <form:errors path="title"/>
		        <form:input path="title"/>
		  	</p>
		  	<p>
		        <form:label path="artist">Artist</form:label>
		        <form:errors path="artist"/>
		        <form:textarea path="artist"/>
			</p>
			<p>
		        <form:label path="rate">Rating</form:label>
		        <form:errors path="rate"/>
		        <form:input path="rate" type="number"/>
			</p>	    
		    <input type="submit" value="Add Song"/>
		</form:form>
	</article>
</body>
</html>