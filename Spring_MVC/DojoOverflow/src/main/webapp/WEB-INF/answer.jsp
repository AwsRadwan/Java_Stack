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
	main {
		margin: auto;
		text-align: center;
	}
	section {
		display: flex;
	}
	article {
		flex: 1;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<main>
		<header>
			<h1> <c:out value="${q.question}"/></h1>
			<br>
			<h3> Tags: <c:forEach items="${q.tags}" var="t"> <button> ${t.subject} </button> </c:forEach> </h3>
		</header>
		<br><br><br>
		<section>
			<article>
				<table class="table table-striped table-dark">
			        <thead>
			            <tr>
			            <th scope="col">Answer</th>
			            <th scope="col">Action</th>
			            </tr>
			        </thead>
			        <tbody>
			            <c:forEach items="${q.answers}" var="a">
				            <tr>
					            <td> <c:out value="${a.answer}"/></td>
					            <td>
					            	 <form action="/deleteq/${a.id}" method="post">
									    <input type="hidden" name="_method" value="delete">
									    <input type="submit" value="Delete">
									</form>
					             </td>
				            </tr>
			            </c:forEach>
			        </tbody>
			    </table>
			</article>
			<article>
				<h2>Add Your Answer</h2>
				<form:form action="/add_a/${q.id}" method="POST" modelAttribute="ans">
				    <p>
				        <form:label path="answer">Your Question: </form:label>
				        <form:errors path="answer"/>
				        <form:input path="answer" name="answer"/>
				  	</p>
				  	<p>
						<form:input  type="hidden" name="question" path="question" class="form-control text-center" value="${q.id}" />
					</p>
					<br>
				    <input type="submit" value="Add Answer"/>
				</form:form>
			</article>
		</section>
	</main>
</body>
</html>