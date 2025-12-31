<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Quiz</title>
</head>
<body bgcolor="${initParam.theme}">
	<h1>${initParam.appTitle}</h1>
	<jsp:useBean id="qb" class="com.app.beans.QuizBean" scope="session" />
	<jsp:setProperty name="qb" property="*" />
	<jsp:setProperty name="qb" property="user" value="${lb.user}" />
	
	<c:set var ="yes" value = "${qb.createQuiz() }"/>
<c:choose>

  <c:when test="${yes}">
      <h3>Quiz Created Successfully!</h3>
      <a href="adminMenu.jsp">Go Back</a>
  </c:when>

  <c:otherwise>
      <h3>Quiz Creation Failed.</h3>
      <a href="createQuiz.jsp">Try Again</a>
  </c:otherwise>

</c:choose>
</body>
</html>
