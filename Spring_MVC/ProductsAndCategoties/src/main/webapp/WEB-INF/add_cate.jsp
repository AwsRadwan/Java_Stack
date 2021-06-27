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
		<h1>Add Categoies to <c:out value="${p.name}"/> </h1>
		<article>
			<section>
				<h3>Categories: </h3>
				<ul>
					<c:forEach items="${cate}" var="c">
						<li> ${c.name} </li>
					</c:forEach>
				</ul>
			</section>
			<section>
				<form action="/setcate/${p.id}" method="post" class="ff">
				  <select name="cate" id="cate">
						<c:forEach items="${cates}" var="c">
					    	<option value="${c.id}"> ${c.name} </option>
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