<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	form {
		display: inline-block;
	}
</style>
</head>
<body>
	<h4> <a  href="/languages/${lang.id}/edit"> Edit </a> | <a  href="/"> Dashboard </a></h4>
	<form action="/languages/${lang.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
	</form>
	<table class="table table-striped table-dark">
        <thead>
            <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Creator</th>
            <th scope="col">Version</th>
            </tr>
        </thead>
        <tbody>
	            <tr>
		            <th scope="row"> <c:out value="${lang.id}"/> </th>
		            <td> <c:out value="${lang.name}"/> </td>
		            <td><c:out value="${lang.creator}"/></td>
		            <td><c:out value="${lang.version}"/></td>
	            </tr>
        </tbody>
    </table>
</body>
</html>