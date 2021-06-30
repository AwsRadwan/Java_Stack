<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<style>
		* {
			margin: auto;
			text-align: center;
			
		}
		body {
			background-color: rosybrown;
        	padding: 20px;
		}
		h3 {
			text-align: right;			
		}
		h2 {
			}
		.ttt {
			padding: 20px;
			background-color: white;
			margin: auto;
			width: 80%;
		}
	</style>
</head>
<body>
	<h1 class="col">Welcome, <c:out value="${user.name}"></c:out></h1>	
	<h3 id="lll"><a href="/logout">Logout</a></h3><br>
	<br>
	<h2>Courses</h2>
	<div class="ttt">
	<table class="table table-hover">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Course</th>
	      <th scope="col">Instructor</th>
	      <th scope="col">Sign ups</th>
	      <th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${courses}" var="c">
			    <tr>
			      <th scope="row"><c:out value="${c.id}"></c:out></th>
			      <td>
			      	<a href="/courses/${c.id}">
						<c:out value="${c.name}"></c:out>
					</a>
			      </td>
			      <td>
			      	<c:out value="${c.instructer}"></c:out>
			      </td>
			      <td> <c:out value="${c.joiners.size()}"></c:out> / <c:out value="${c.capacity}"></c:out> </td>
			      <td>
			      	<c:choose>
						<c:when test="${c.joiners.size() == c.capacity}">
							Full
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${user.getJoinedCourses().contains(c)}">
									<span>Already Added</span> | 
									<a href="/courses/${c.id}/cancel">Cancel</a>
								</c:when>
								<c:otherwise>
									<a href="/courses/${c.id}/join">Add</a>			
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
			      </td>
			    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	</div>
	<br><br>
	<form action="/courses/new">
	<input class="btn btn-success" type="submit" value="Add Course">
	</form>
	
	
	
	
</body>
</html>