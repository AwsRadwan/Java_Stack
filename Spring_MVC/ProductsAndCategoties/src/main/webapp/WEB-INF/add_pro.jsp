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
</head>
<body>
	<main>
		<h1>Add Products to <c:out value="${c.name}"/> </h1>
		<article>
			<section>
				<h3>Products: </h3>
				<ul>
					<c:forEach items="${pro}" var="p">
						<li> ${p.name} </li>
					</c:forEach>
				</ul>
			</section>
			<section>
				<form action="/setpro/${c.id}" method="post" class="ff">
				  <select name="pro" id="cate">
						<c:forEach items="${pros}" var="p">
					    	<option value="${p.id}"> ${p.name} </option>
					 	</c:forEach>
					</select>
				  <input type="submit" value="Add">
				</form>
			</section>
		</article>
		<h3><a  href="/"> Dashboard </a></h3>
	</main>
</body>
</html>