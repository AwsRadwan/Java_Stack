<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<style>
	* {
			margen: auto;
			text-align: center;
			
		}
	body {
		
		background-color: rosybrown;
        padding: 20px;
	}
	.col{
		
	}
	#wall{
		height:300px;
		overflow-y:scroll;
	}
	.aa {
		display: flex;
		justify-content: space-between;
		width: fit-content;
		margin: auto;
	}
	.a11 {
	 	flex: 1;
	}
	.ttt {
			padding: 20px;
			background-color: white;
			margin: auto;
			width: 80%;
		}
		#ww {
		    width: 10px;
		}
</style>

</head>
<body>
	<div class="col">
		<h1>
			<c:out value="${course.getName()}"></c:out>
		</h1>
		<br><br>
		<p>
			Host: <c:out value="${course.host.getName()}"></c:out>
		</p>
		<p>
			Instructor: <c:out value="${course.instructer}"></c:out>
		</p>
		<p>
			Sign Ups: <c:out value="${course.joiners.size()}"></c:out>
		</p>
		<div class="ttt">
		<table class="table table-hover">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Name</th>
	      <th scope="col">Sign up Date</th>
	      <th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${course.joiners}" var="joiner">
			    <tr>
			      <th scope="row"><c:out value="${joiner.id}"></c:out></th>
			      <td>
			      	<c:out value="${joiner.getName()}"></c:out>
			      </td>
			      <td>
			      	<c:out value = "${joiner.date}"></c:out>
			      </td>
			      <td>
			      	<c:choose>
						<c:when test="${joiner.equals(user)}">
							<a href="/courses/${course.id}/cancel">Remove</a>
						</c:when>
						<c:otherwise>
							<p> - </p>
						</c:otherwise>
					</c:choose>
			      </td>
			    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	
	</div>
	<br><br><br>
	<c:if test="${user.equals(course.host)}">
	<div class="aa">
	<form action="/courses/<c:out value="${course.id}"></c:out>/delete"> 
	<input type="submit" class="btn btn-danger" value="Delete">
	</form>
	<p id="ww"></p>
	<form action="/courses/${course.id}/edit">
		<input type="submit" class="btn btn-warning" value="Edit">
	</form>
	</div>
	</c:if>
	</div>
			
	
			
</body>
</html>