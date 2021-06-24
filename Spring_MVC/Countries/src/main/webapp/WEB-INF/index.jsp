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
	<header>
		
		
		
		
	</header>
	<h2><a href="/1"> 1st Q </a></h2>
	<c:forEach items="${arr}" var="speak">


       <c:out value="${speak[1]}"></c:out>
           <c:out value="${speak[2]}"></c:out>
	       <c:out value="${speak[0]}"></c:out>
	       <br><br>
       </c:forEach>
            <h2><a href="/2"> 2nd Q </a></h2>
       <c:forEach items="${arr2}" var="x">
       		<c:out value="${x[1]}"></c:out>
       		<c:out value="${x[0]}"></c:out>
       		<br><br>
       </c:forEach>
       		<h2><a href="/3"> 3rd Q </a></h2>
       		<c:forEach items="${arr3}" var="y">
       		<c:out value="${y[1]}"></c:out>
       		<c:out value="${y[0]}"></c:out>
       		<c:out value="${y[2]}"></c:out>
       		<br><br>
       </c:forEach>
       		<h2><a href="/4"> 4th Q </a></h2>
       		<c:forEach items="${arr4}" var="y">
       		<c:out value="${y[1]}"></c:out>
       		<c:out value="${y[0]}"></c:out>
       		<c:out value="${y[2]}"></c:out>
       		<br><br>
       </c:forEach>
       <h2><a href="/5"> 5th Q </a></h2>
       		<c:forEach items="${arr5}" var="y">
       		<c:out value="${y[1]}"></c:out>
       		<c:out value="${y[0]}"></c:out>
       		<c:out value="${y[2]}"></c:out>
       		<br><br>
       </c:forEach>
       <h2><a href="/6"> 6th Q </a></h2>
       		<c:forEach items="${arr6}" var="y">
       		<c:out value="${y[1]}"></c:out>
       		<c:out value="${y[0]}"></c:out>
       		<c:out value="${y[2]}"></c:out>
       		<c:out value="${y[3]}"></c:out>
       		<br><br>
       </c:forEach>
       <h2><a href="/7"> 7th Q </a></h2>
       		<c:forEach items="${arr7}" var="y">
       		<c:out value="${y[1]}"></c:out>
       		<c:out value="${y[0]}"></c:out>
       		<c:out value="${y[2]}"></c:out>
       		<c:out value="${y[3]}"></c:out>
       		<br><br>
       </c:forEach>
       <h2><a href="/8"> 8th Q </a></h2>
       		<c:forEach items="${arr8}" var="y">
       		<c:out value="${y[1]}"></c:out>
       		<c:out value="${y[0]}"></c:out>
       		<br><br>
       </c:forEach>
</body>
</html>