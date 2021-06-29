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
		body {
			background-color: rosybrown;
        	padding: 20px;
		}
	</style>
</head>
<body>
	<h1 class="col">Welcome, <c:out value="${user.firstName}"></c:out></h1>	<a href="/logout">Logout</a>
	<br>
	<h2>Events in your state:</h2>
	<table class="table table-hover">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Name</th>
	      <th scope="col">Date</th>
	      <th scope="col">Location</th>
	      <th scope="col">Host</th>
	      <th scope="col">Action / Status</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${events}" var="event">
		  	<c:if test="${event.state.equals(user.state)}">
			    <tr>
			      <th scope="row"><c:out value="${event.id}"></c:out></th>
			      <td>
			      	<a href="/events/${event.id}">
						<c:out value="${event.name}"></c:out>
					</a>
			      </td>
			      <td>
			      	<fmt:formatDate pattern = "MMMM d, yyyy" dateStyle = "long" value = "${event.date}" />
			      </td>
			      <td> <c:out value="${event.city}"></c:out> </td>
			      <td> <c:out value="${event.getHost().getFirstName()}"></c:out> </td>
			      <td>
			      	<c:choose>
						<c:when test="${event.host.equals(user)}">
							<a href="/events/${event.id}/edit">Edit</a> | 
							<a href="/events/${event.id}/delete">Delete</a>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${user.getJoinedEvents().contains(event)}">
									<span>Joining</span> | 
									<a href="/events/${event.id}/cancel">Cancel</a>
								</c:when>
								<c:otherwise>
									<a href="/events/${event.id}/join">Join</a>			
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
			      </td>
			    </tr>
		    </c:if>
	    </c:forEach>
	  </tbody>
	</table>
	<br>
	
	
	
	<br>
	<h2>Events in other states:</h2>
	<table class="table table-hover">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Name</th>
	      <th scope="col">Date</th>
	      <th scope="col">Location</th>
	      <th scope="col">State</th>
	      <th scope="col">Host</th>
	      <th scope="col">Action / Status</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${events}" var="event">
		  	<c:if test="${!event.state.equals(user.state)}">
			    <tr>
			      <th scope="row"><c:out value="${event.id}"></c:out></th>
			      <td>
			      	<a href="/events/${event.id}">
						<c:out value="${event.name}"></c:out>
					</a>
			      </td>
			      <td>
			      	<fmt:formatDate pattern = "MMMM d, yyyy" dateStyle = "long" value = "${event.date}" />
			      </td>
			      <td> <c:out value="${event.city}"></c:out> </td>
			      <td> <c:out value="${event.state}"></c:out> </td>
			      <td> <c:out value="${event.getHost().getFirstName()}"></c:out> </td>
			      <td>
			      	<c:choose>
						<c:when test="${event.host.equals(user)}">
							<a href="/events/${event.id}/edit">Edit</a> | 
							<a href="/events/${event.id}/delete">Delete</a>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${user.getJoinedEvents().contains(event)}">
									<span>Joining</span> | 
									<a href="/events/${event.id}/cancel">Cancel</a>
								</c:when>
								<c:otherwise>
									<a href="/events/${event.id}/join">Join</a>			
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
			      </td>
			    </tr>
		    </c:if>
	    </c:forEach>
	  </tbody>
	</table>
	<br><br>
	<h2>Create an Event</h2>
	<br>
<form:form method="POST" action="/events" modelAttribute="newEvent">
<div class="form-group">
	<form:label path="name">Name</form:label>
	<form:errors path="name"></form:errors>
	<form:input path="name" class="form-control" placeholder="Name" required="true"></form:input>
	</div>
	<br />
	<div class="form-group">
	<form:label path="date">Date</form:label>
	<form:errors path="date"></form:errors>
	<form:input type="date" path="date" class="form-control" placeholder="Date" required="true"></form:input>
	</div>
	<br />
	<div class="form-group">
	<form:label path="city">Location:</form:label>
	<form:errors path="city"></form:errors>
	<form:input path="city" class="form-control" placeholder="City" required="true"></form:input>
	<br><br>
	<form:select path="state" class="form-control" placeholder="State" required="true">
		<form:option value="State" selected="true">State</form:option>
		<form:options items="${states}"/>
	</form:select>
	</div>
	<br />
	<input type="submit" value="Create Event" class="btn btn-primary"/>
</form:form>
	
</body>
</html>