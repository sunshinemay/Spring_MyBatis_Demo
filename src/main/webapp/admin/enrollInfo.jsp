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
${sessionScope.activityEnrollList}
<table border="1">
    <tr>
        <th>STUDENT NO</th>
        <th>STUDENT NAME</th>
        <th>ACTIVITY NAME</th>
    </tr>
    <c:forEach var="enrollInfo" items="${sessionScope.activityEnrollList}">
        <tr>
            <td>${enrollInfo.enrolls[0].sno}</td>
            <td>${enrollInfo.enrolls[0].sname}</td>
            <td>${enrollInfo.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
