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
		<h4><a href=/product>Add New Product</a></h4>
		<h4><a href="/category">Add New category</a></h4>
	</header>
	<br><br>
    <table class="table table-striped table-dark">
        <thead>
            <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Price</th>
            <th scope="col">Categories Count</th>
            <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${parr}" var="p">
	            <tr>
		            <th scope="row"> <c:out value="${p.id}"/> </th>
		            <td> <c:out value="${p.name}"/> </td>
		            <td> <c:out value="${p.description}"/> </td>
		            <td><c:out value="${p.price}"/></td>
		            <td><c:out value="${p.count()}"/></td>
		            <td><a href="/add_cate/${p.id}"> Add Categories </a></td>
		            <td>
		            	 <form action="/deletep/${p.id}" method="post">
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
            <th scope="col">Product Count</th>
            <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${carr}" var="c">
	            <tr>
		            <th scope="row"> <c:out value="${c.id}"/> </th>
		            <td> <c:out value="${c.name}"/> </td>
		            <td> <c:out value="${c.count()}"/> </td>
		            <td><a href="/add_pro/${c.id}"> Add Products </a></td>
		            <td>
		            	 <form action="/deletec/${c.id}" method="post">
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