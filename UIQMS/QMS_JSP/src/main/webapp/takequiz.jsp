<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="lb" class="com.app.beans.LoginBean" scope="session"/>
<jsp:useBean id="quiz" class="com.app.beans.AttemptBean" scope="request"/>

<jsp:setProperty name="quiz" property="quizId" param="quizId"/>
<jsp:setProperty name="quiz" property="studentId" value="${lb.user.id}"/>
<jsp:setProperty name="quiz" property="user" value="${lb.user}"/>

<c:set var="status" value="${quiz.takeQuiz()}"/>

<html>
<body bgcolor="${initParam.theme}">
<h1>${initParam.appTitle}</h1>

<c:choose>
    <c:when test="${status=='already'}">
        <h3>You already attempted this quiz.</h3>
    </c:when>

    <c:when test="${status=='showquiz'}">
        <form method="post" action="result.jsp">
            <input type="hidden" name="quizId" value="${quiz.quizId}"/>

            <c:forEach var="q" items="${quiz.questions}" varStatus="st">
    <p><b>Q${st.index + 1}:</b> ${q.text}</p>

    <input type="radio" name="answers[${st.index}]" value="A"/> ${q.a}<br>
    <input type="radio" name="answers[${st.index}]" value="B"/> ${q.b}<br>
    <input type="radio" name="answers[${st.index}]" value="C"/> ${q.c}<br>
    <input type="radio" name="answers[${st.index}]" value="D"/> ${q.d}<br><br>
</c:forEach>


            <input type="submit" value="Submit Quiz"/>
        </form>
    </c:when>

    <c:otherwise>
        <h3>Error: ${quiz.error}</h3>
    </c:otherwise>
</c:choose>
</body>
</html>
