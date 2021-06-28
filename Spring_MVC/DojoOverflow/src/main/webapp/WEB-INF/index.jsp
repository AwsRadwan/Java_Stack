<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
	main {
		margin: auto;
		text-align: center;
	}
	h3 {
		flout: right;
	}
</style>
</head>
<body>
<br><br><br>
	<main>
		<h1>Questions Dashboard</h1>
		<br>
		<table class="table table-striped table-dark">
        <thead>
            <tr>
            <th scope="col">Question</th>
            <th scope="col">Tags</th>
            <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${qs}" var="q">
	            <tr>
		            <td> <a href="/questions/${q.id}"> <c:out value="${q.question}"/> </a> </td>
		            <td>
		            	<c:forEach items="${q.tags}" var="t">
		            		<samp><c:out value="${t.subject}"/> ,</samp>
		            	</c:forEach>
		            </td>
		            <td>
		            	 <form action="/deleteq/${q.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form>
		             </td>
	            </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <br>
    <h3><a href="/questions/new"> New Question </a></h3>
	</main>
</body>
</html>