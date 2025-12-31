<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scores</title>
</head>
<body bgcolor="${initParam.theme}">
<h1>${initParam.appTitle}</h1>

<jsp:useBean id="lb" class="com.app.beans.LoginBean" scope="session" />
<jsp:useBean id="vs" class="com.app.beans.AttemptBean" scope="session" />
<jsp:setProperty name="vs" property="user" value="${lb.user}" />

<c:choose>
    <c:when test="${lb.user.role == 'ADMIN'}">
        ${vs.viewScoreAdmin()}
    </c:when>
    <c:otherwise>
        ${vs.viewScoreStudent()}
    </c:otherwise>
</c:choose>

<h2>Scores</h2>

<c:if test="${empty vs.list}">
   <p>No Records Found</p>
</c:if>

<c:if test="${not empty vs.list}">
    <table>
        <tr>
            <th>Quiz ID</th>
            <th>Score</th>
            <th>Total Questions </th>

          
            <c:if test="${lb.user.role == 'ADMIN'}">
                <th>Attempt ID</th>
                <th>Student ID</th>
            </c:if>
        </tr>

        <c:forEach var="s" items="${vs.list}">
            <tr>
                <td>${s.quizId}</td>
                <td>${s.score}</td>
                <td>${s.total}</td>

                <c:if test="${lb.user.role == 'ADMIN'}">
                    <td>${s.id}</td>
                    <td>${s.student_id}</td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
