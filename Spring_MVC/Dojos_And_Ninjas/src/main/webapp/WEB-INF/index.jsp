<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
	header {
		display: flex;
	}
	h4 {
		flex: 1;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<br><br>
	<header>
		<h4><a href=/dojo>Add New Dojo</a></h4>
		<h4><a href="/ninja">Add New Ninja</a></h4>
	</header>
	<br><br>
    <table class="table table-striped table-dark">
        <thead>
            <tr>
            <th scope="col">#</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Age</th>
            <th scope="col">Dojo</th>
            <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ninjas}" var="ninja">
	            <tr>
		            <th scope="row"> <c:out value="${ninja.id}"/> </th>
		            <td> <c:out value="${ninja.firstName}"/> </td>
		            <td> <c:out value="${ninja.lastName}"/> </td>
		            <td><c:out value="${ninja.age}"/></td>
		            <td><c:out value="${ninja.dojo.name}"/></td>
		            <td>
		            	 <form action="/ninja/${ninja.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form>
		             </td>
	            </tr>
            </c:forEach>
        </tbody>
    </table>
    <br><br>
    <table class="table table-striped table-dark">
        <thead>
            <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Ninjas Count</th>
            <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${dojos}" var="dojo">
	            <tr>
		            <th scope="row"> <c:out value="${dojo.id}"/> </th>
		            <td> <c:out value="${dojo.name}"/> </td>
		            <td> <c:out value="${dojo.count()}"/> </td>
		            <td>
		            	 <form action="/dojo/${dojo.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form>
		             </td>
	            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>