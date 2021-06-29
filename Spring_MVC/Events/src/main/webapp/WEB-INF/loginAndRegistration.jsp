<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
	main {
            display: flex;
            margin: 0px 20px;
        }
    section {
        flex: 1;
        padding: 20px 50px;
        border: 4px solid black;
        border-radius: 30px;
        margin-right: 20px;
    }
    body {
        background-color: rosybrown;
        padding: 20px;
    }
</style>
<title>Insert title here</title>
</head>
<body>
	<main>
	<section>
	<h1>Register</h1>
    
    <form:form method="POST" action="/registration" modelAttribute="user">
        <p class="form-group">
            <form:label path="firstName">First Name</form:label>
            <form:input path="firstName" class="form-control" placeholder="First Name" required="true"/>
        </p>
        <p class="form-group">
            <form:label path="lastName">Last Name:</form:label>
            <form:input path="lastName" class="form-control" placeholder="Last Name" required="true"/>
        </p>
         <p class="form-group">
            <form:label path="email">Email:</form:label>
            <form:input type="email" path="email" class="form-control" placeholder="Email" required="true"/>
        </p>
        <p class="form-group">
        	<form:label path="city">Location</form:label>
        	<form:input path="city" class="form-control" placeholder="City" required="true"/><br>
        	<form:select path="state" class="form-control" placeholder="State" required="true">
        		<form:option value="State" selected="true">State</form:option>
        		<form:options items="${states}"/>
        	</form:select>
        </p>
        <p class="form-group">
            <form:label path="password">Password:</form:label>
            <form:password path="password" class="form-control" placeholder="Password" required="true"/>
        </p>
        <p class="form-group">
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation" class="form-control" placeholder="Confirm-Password" required="true"/>
        </p>
        <input type="submit" value="Register" class="btn btn-primary"/>
    </form:form>
    <p><form:errors path="user.*"/></p>
    </section>
	<section>
    <h1>Login</h1>
    <form method="POST" action="/login">
        <p class="form-group">
            <label for="username">Email</label>
            <input type="email" id="email" name="email" class="form-control" placeholder="Email" required/>
        </p>
        <p class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required/>
        </p>
        <p><c:out value="${error}" /></p>
        <br>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Login" class="btn btn-primary"/>
    </form>
    </section>
    </main>
	
</body>
</html>