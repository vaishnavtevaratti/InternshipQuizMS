<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Auth</title>
</head>
<body bgcolor="${initParam.theme}">
	<h1>${initParam.appTitle}</h1>
	<jsp:useBean id="lb" class="com.app.beans.LoginBean" scope="session" />
	<jsp:setProperty name="lb" property="*" />
	${lb.authenticate()}
	<c:choose>
		<c:when test="${empty lb.user}">
			<h3>Login Failed.</h3>
			<p>Invalid email or password.</p>
			<a href="index.jsp">Login Again</a>
		</c:when>
		<c:when test="${lb.user.role == 'ADMIN'}">
			<c:redirect url="adminMenu.jsp" />
		</c:when>
		<c:when test="${lb.user.role == 'STUDENT'}">
			s<c:redirect url="studentMenu.jsp" />
		</c:when>
		
	</c:choose>
</body>
</html>
