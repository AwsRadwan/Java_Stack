<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<style>
        * {
            align-items: center;
            text-align: center;
        }
        body {
            background-image: radial-gradient(rgb(197, 188, 188), rgb(218, 206, 175));
        }
        section {
            display: flex;
        }
        div {
            flex: 1;
        }
        body h2 {
            text-decoration: underline;
        }
    </style>
	</head>
	<body>
		<h2>Your Gold: <c:out value="${count}"/> </h2>
    <br><br><br><br><br>
    <section>
        <div>
            <form action="/add" method="POST">
                <input type="hidden" name="hidden" value="hidden1">
                <h3>Form</h3>
                <p> (earns 10-20 golds) </p>
                <input type="submit" value="Find Gold!">
            </form>
        </div>
        <div>
            <form action="/add" method="POST">
                <input type="hidden" name="hidden" value="hidden2">
                <h3>Cave</h3>
                <p> (earns 5-10 golds) </p>
                <input type="submit" value="Find Gold!">
            </form>
        </div>
        <div>
            <form action="/add" method="POST">
                <input type="hidden" name="hidden" value="hidden3">
                <h3>House</h3>
                <p> (earns 2-5 golds) </p>
                <input type="submit" value="Find Gold!">
            </form>
        </div>
        <div>
            <form action="/add" method="POST">
                <input type="hidden" name="hidden" value="hidden4">
                <h3>Casino</h3>
                <p> (earns/takes 0-50 golds) </p>
                <input type="submit" value="Find Gold!">
            </form>
        </div>
    </section>
    <br><br><br><br>
    <p>Activites: </p>
    <c:forEach items="${list}" var="x">
    	<p> ${x} </p>
    </c:forEach>
    <form action="/reset" method="POST">
        <input type="submit" value="Reset">
    </form>
	</body>
</html>