<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="${initParam.theme}">
	<h1>${initParam.appTitle}</h1>
<h2>Admin Menu</h2>

<a href="createQuiz.jsp">Create Quiz</a><br/>
<a href="listquiz.jsp">List Quizzes</a><br/>
<a href="viewscore.jsp">View Score </a><br/>
<a href="logout.jsp">Logout</a>

</body>
</html>