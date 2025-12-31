<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="lb" class="com.app.beans.LoginBean" scope="session"/>
<jsp:useBean id="quiz" class="com.app.beans.AttemptBean" scope="request"/>

<jsp:setProperty name="quiz" property="quizId" param="quizId"/>
<jsp:setProperty name="quiz" property="studentId" value="${lb.user.id}"/>
<jsp:setProperty name="quiz" property="user" value="${lb.user}"/>
<jsp:setProperty name="quiz" property="answers" param="answers"/>

<c:set var="status" value="${quiz.submitQuiz()}"/>

<html>
<body bgcolor="${initParam.theme}">
<h1>${initParam.appTitle}</h1>

<c:choose>
    <c:when test="${status=='saved'}">
        <h2>Your Score: ${quiz.score} / ${quiz.questions.size()}</h2>
    </c:when>

    <c:when test="${status=='error'}">
        <h3>Error: ${quiz.error}</h3>
    </c:when>

    <c:otherwise>
        <h3>Unexpected status: ${status}</h3>
    </c:otherwise>
</c:choose>
</body>
</html>
