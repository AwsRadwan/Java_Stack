<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Submitted Info. :</h2>
    <section>
        <article>
            <form action="/">
            <p>Name: <c:out value="${name}"/></p>
            <br>
            <p>Dojo Location: <c:out value="${location}"/></p>
            <br>
            <p>Favorite Language: <c:out value="${language}"/></p>
            <br>
            <p>Comment: <c:out value="${comment}"/></p>
            <br>
            
            <button href= '/' name="go">Go back</button>
            </form>
        </article>
    </section>
    <style>
        body {
            padding-top: 50px;
            padding-left: 200px;
        }
        p {
            width: fit-content;
        }
        h2 {
            text-decoration: underline;
        }
        section {
            display: flex;
            background-color: antiquewhite;
            padding: 30px;
            justify-content: space-between;
            width: 300px;
            border: 5px solid black;
            margin: auto;
        }
        article {
            flex: 1;
            background-color: burlywood;
            padding-left: 30px;
            width: fit-content;
            padding-bottom: 3px;
        }
        main {
            flex: 1;
        }
    </style>
</body>
</html>