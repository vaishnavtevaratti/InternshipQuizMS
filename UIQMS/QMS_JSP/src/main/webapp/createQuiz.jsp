<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Quiz</title>
</head>
<body bgcolor="${initParam.theme}">
	<h1>${initParam.appTitle}</h1>
<h2>Create New Quiz</h2>

<form method="post" action="createQuizResult.jsp">
Quiz Title : <input type="text" name="title"/><br/><br/>
Questions File Path : <input type="text" name="filePath"/><br/><br/>
<input type="submit" value="Create Quiz"/>

</form>

</body>
</html>