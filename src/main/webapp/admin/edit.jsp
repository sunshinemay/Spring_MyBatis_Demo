<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>admin edit page</title>
    </head>
    <body>
        <h1>Admin Edit Page</h1>
        <form action="${ctx}/admin/modify" method="post">
            <input type="hidden" name="id" value="${sessionScope.admin.id}">
            USERNAME: <input name="username" value="${sessionScope.admin.username}"><br>
            PASSWORD: <input name="password" value="${sessionScope.admin.password}"><br>
            <input type="submit" value="UPDATE">
        </form>
    </body>
</html>