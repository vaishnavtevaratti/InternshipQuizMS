<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz List</title>
</head>
<body bgcolor="${initParam.theme}">
    <h1>${initParam.appTitle}</h1>


    <jsp:useBean id="lb" class="com.app.beans.LoginBean" scope="session" />
    <jsp:useBean id="ql" class="com.app.beans.QuizBean" scope="request" />
    <jsp:setProperty name="ql" property="user" value="${lb.user}" />
    

   
    ${ql.listQuizzes()}

    <h2>Available Quizzes</h2>
    <c:if test="${not empty sessionScope.message}">
        <p style="color:green">${sessionScope.message}</p>
        <c:remove var="message" scope="session"/>
    </c:if>
    <c:if test="${empty ql.qlist}">
        <p>No quizzes found.</p>
    </c:if>
    <c:if test="${not empty ql.qlist}">
    <table>
        <tr>
            <th>Quiz ID</th>
            <th>Quiz Title</th>
            <c:if test="${lb.user.role == 'ADMIN'}">
                <th>Function</th>
            </c:if>
			<c:if test="${lb.user.role == 'STUDENT'}">
                <th>Action</th>
            </c:if>
        </tr>

        <c:forEach var="q" items="${ql.qlist}">
        <tr>
            <td>${q.id}</td>
            <td>${q.title}</td>

            <c:if test="${lb.user.role == 'ADMIN'}">
                <td>
                    <a href="deletequiz.jsp?id=${q.id}"
                        onclick="return confirm('Are you sure you want to delete this quiz?');">
                        Delete
                    </a>
                </td>
            </c:if>
            <c:if test="${lb.user.role == 'STUDENT'}">
                <td>
                    <a href="takequiz.jsp?quizId=${q.id}">
                        Take Quiz
                    </a>
                </td>
            </c:if>
        </tr>
        </c:forEach>
    </table>
    </c:if>

</body>
</html>
