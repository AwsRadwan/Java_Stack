<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
	<header>
		<h4><a href="/person">Add New Person</a></h4>
		<h4><a href="/license">Add New License</a></h4>
	</header>
	<br><br>
    <table class="table table-striped table-dark">
        <thead>
            <tr>
            <th scope="col">#</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">License</th>
            <th scope="col">State</th>
            <th scope="col">expiration Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${persons}" var="person">
	            <tr>
		            <th scope="row"> <c:out value="${person.id}"/> </th>
		            <td> <a href="/person/<c:out value="${person.id}"/>/details"><c:out value="${person.firstName}"/></a> </td>
		            <td> <a href="/person/<c:out value="${person.id}"/>/details"><c:out value="${person.lastName}"/></a> </td>
		            <td><c:out value="${person.license.number}"/></td>
		            <td><c:out value="${person.license.state}"/></td>
		            <td><c:out value="${person.license.expirationDate}"/></td>
	            </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
</body>
</html>