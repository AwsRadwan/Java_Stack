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

<style>
	h3 {
		float: right;
	}
</style>
</head>
<body>
	<h1>Top Ten Songs:</h1>
	<h3><a  href="/dashboard"> Dashboard </a></h3>
	
	<br><br>
    <table class="table table-striped table-dark">
        <thead>
            <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Rating</th>
            <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${songs}" var="song">
	            <tr>
		            <th scope="row"> <c:out value="${song.id}"/> </th>
		            <td> <a href="/songs/<c:out value="${song.id}"/>"><c:out value="${song.title}"/></a> </td>
		            <td><c:out value="${song.rate}"/></td>
		            <td>
		            	 <form action="/songs/${song.id}/delete" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form>
		             </td>
	            </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
</body>
</html>