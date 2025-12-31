<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete quiz</title>
</head>
<body bgcolor="${initParam.theme}">
	<h1>${initParam.appTitle}</h1>
<jsp:useBean id="db" class="com.app.beans.QuizBean" scope="request" />
<jsp:setProperty name="db" property="quizId" param="id"/>
<c:set var="message" value="${db.deleteQuiz()}" scope="session"/>
<c:redirect url="listquiz.jsp"/>
</body>
</html>