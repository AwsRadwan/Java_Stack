<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style type="text/css">
	body {
		margin: auto;
	}
	td {
		dispiay: flex;
	}
	form {
		display: inline-block;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<br><br><br>
    <h1>All Languages</h1>
    <br><br>
    <table class="table table-striped table-dark">
        <thead>
            <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Creator</th>
            <th scope="col">Version</th>
            <th scope="col">Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${languages}" var="lang">
	            <tr>
		            <th scope="row"> <c:out value="${lang.id}"/> </th>
		            <td> <a href="/languages/<c:out value="${lang.id}"/>"><c:out value="${lang.name}"/></a> </td>
		            <td><c:out value="${lang.creator}"/></td>
		            <td><c:out value="${lang.version}"/></td>
		            <td> <a href="/languages/<c:out value="${lang.id}"/>/edit"> Edit </a> | 
		            	 <form action="/languages/${lang.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form>
		             </td>
	            </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
	
	<h3>Add a new Language</h3>
    <br><br>
    <form:form action="/languages" method="POST" modelAttribute="language">
	    <p>
	        <form:label path="name">Name</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	  	</p>
	  	<p>
	        <form:label path="creator">Creator</form:label>
	        <form:errors path="creator"/>
	        <form:textarea path="creator"/>
		</p>
		<p>
	        <form:label path="version">Version</form:label>
	        <form:errors path="version"/>
	        <form:input path="version"/>
		</p>	    
	    <input type="submit" value="Submit"/>
	</form:form>
	
</body>
</html>