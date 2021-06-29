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
	body {
		display: flex;
		background-color: rosybrown;
        padding: 20px;
	}
	.col{
		flex: 1;
		vertical-align:top;
	}
	#wall{
		height:300px;
		overflow-y:scroll;
	}
</style>

</head>
<body>
	<div class="col">
		<h1>
			<c:out value="${event.getName()}"></c:out>
		</h1>
		<p>
			Host: <c:out value="${event.host.getFirstName()}"></c:out>
		</p>
		<p>
			Date: <fmt:formatDate pattern = "MMMM d, yyyy" dateStyle = "long" value = "${event.getDate()}" />
		</p>
		<p>
			Location: <c:out value="${event.getCity()}"></c:out>, <c:out value="${event.getState()}"></c:out>
		</p>
		<p>
			People who are attending this event: <c:out value="${event.joiners.size()}"></c:out>
		</p>
		<table class="table table-hover">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Name</th>
	      <th scope="col">Location</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${event.joiners}" var="joiner">
			    <tr>
			      <th scope="row"><c:out value="${joiner.id}"></c:out></th>
			      <td>
			      	<c:out value="${joiner.getFirstName()}"></c:out> <c:out value="${joiner.getLastName()}"></c:out>
			      </td>
			      <td>
			      	<c:out value="${joiner.getCity()}"></c:out>
			      </td>
			    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	</div>
			<div class="col">
				<h1>Message Wall</h1>
				<div id="wall">
					<c:forEach items="${event.getMessages()}" var="message">
						<p class="message">
							<c:out value="${message.author.getFirstName()}"></c:out> says:  <c:out value="${message.getText()}"></c:out>
						</p>
					</c:forEach>
				</div>
			</div>
		<form action="/events/${event.getId()}" method="post">
			<div class="form-group">
			<label for="text">New Comment</label>
			<input type="text" name="text" class="form-control" placeholder="Add Comment ..." required/>
			</div>
			 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="submit" value="Post" class="btn btn-primary"/>
		</form>
</body>
</html>