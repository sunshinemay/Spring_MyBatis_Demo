<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>enroll edit page</title>
    </head>
    <body>
        <h1>Enroll Edit Page</h1>
        <form action="${ctx}/enroll/modify" method="post">
            <input type="hidden" name="id" value="${sessionScope.enroll.id}">
            SNO: <input name="sno" value="${sessionScope.enroll.sno}"><br>
            SNAME: <input name="sname" value="${sessionScope.enroll.sname}"><br>
            ACTIVITYID: <input name="activityId" value="${sessionScope.enroll.activityId}"><br>
            <input type="submit" value="UPDATE">
        </form>
    </body>
</html>