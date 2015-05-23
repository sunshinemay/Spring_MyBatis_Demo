<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="/commons/inc.jsp" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>enroll add page</title>
</head>
<body>
<h1>Enroll Add Page</h1>

<form action="${ctx}/enroll/add" method="post">
    ACTIVITY: <select name="activityId">
    <c:forEach var="activity" items="${sessionScope.list}">
        <option value="${activity.id}"/>
        ${activity.name}
    </c:forEach>
</select><br>
    SNO: <input name="sno"><br>
    SNAME: <input name="sname"><br>
    <input type="submit" value="ADD">
</form>
</body>
</html>