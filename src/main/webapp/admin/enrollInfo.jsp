<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/5/23
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<hr/>
<form action="${ctx}/admin/queryEnrollInfoByActivityId" method="post">
    活动名称：<select name="activityId">
    <c:forEach var="activity" items="${sessionScope.list}">
        <c:choose>
            <c:when test="${activity.id eq sessionScope.activities[0].id}">
                <option value="${activity.id}" selected="selected"/>
                ${activity.name}
            </c:when>
            <c:otherwise>
                <option value="${activity.id}"/>
                ${activity.name}
            </c:otherwise>
        </c:choose>
    </c:forEach>
</select>
    <input type="submit" value="查询按钮"/>
</form>
<hr/>
<table border="1">
    <tr>
        <th>STUDENT NO</th>
        <th>STUDENT NAME</th>
        <th>ACTIVITY NAME</th>
    </tr>
    <c:forEach var="activity" items="${sessionScope.activities}">
        <c:forEach var="enroll" items="${activity.enrolls}">
            <tr>
                <td>${enroll.sno}</td>
                <td>${enroll.sname}</td>
                <td>${activity.name}</td>
            </tr>
        </c:forEach>
    </c:forEach>
</table>
</body>
</html>
