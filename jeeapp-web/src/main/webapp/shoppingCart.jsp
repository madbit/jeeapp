<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>J2EE app</title>
</head>
<body>

	<c:choose>
		<c:when test="${empty count}">Count: 0 - SimpleCount: 0</c:when>
		<c:otherwise>Count: <c:out value="${count}" /> - SimpleCount: <c:out value="${simpleCount}" /></c:otherwise>
	</c:choose>
	<br />
	<a href="index.jsp">Index</a> | <a href="shoppingCart?op=add">Add to shopping cart</a> | <a href="shoppingCart?op=checkout">Check out</a>
</body>
</html>