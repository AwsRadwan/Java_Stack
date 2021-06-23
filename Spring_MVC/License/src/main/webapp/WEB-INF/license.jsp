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
			<h1>Add a new License</h1>
			<h3><a  href="/"> Dashboard </a></h3>
		</header>
	    <br><br>
	    <form:form action="/addnewl" method="POST" modelAttribute="license">
		    <p>
		        <form:label path="number">Number</form:label>
		        <form:errors path="number"/>
		        <form:input path="number"/>
		  	</p>
		  	<p>
		        <form:label path="state">State</form:label>
		        <form:errors path="state"/>
		        <form:input path="state"/>
			</p>
			<p>
		        <form:label path="expirationDate">Date</form:label>
		        <form:errors path="expirationDate"/>
		        <form:input path="expirationDate" type="date" />
			</p>
			<p>
		        <form:label path="person">Person</form:label>
		        <form:errors path="person"/>
		        <select name="person">
				    <c:forEach items="${persons}" var="person">
				        <option value="${person.id}">${person.firstName} ${person.lastName}</option>
				    </c:forEach>
				</select>
			</p>
		    <input type="submit" value="Add License"/>
		</form:form>
	</article>
</body>
</html>