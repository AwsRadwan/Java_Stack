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
			<h1>Add a new Ninja</h1>
			<h3><a  href="/"> Dashboard </a></h3>
		</header>
	    <br><br>
	    <form:form action="/addninja" method="POST" modelAttribute="ninja">
	    	<p>
		        <form:label path="dojo">Dojo</form:label>
		        <form:errors path="dojo"/>
		        <select name="dojo" path="dojo">
				    <c:forEach items="${dojos}" var="dojo">
				        <option value="${dojo.id}"> ${dojo.name} </option>
				    </c:forEach>
				</select>
			</p>
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
			<p>
		        <form:label path="age">Age</form:label>
		        <form:errors path="age"/>
		        <form:input path="age" type="number"/>
			</p>	    
		    <input type="submit" value="Add Ninja"/>
		</form:form>
	</article>
</body>
</html>