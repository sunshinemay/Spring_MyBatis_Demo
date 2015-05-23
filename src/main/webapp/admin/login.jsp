<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>admin login page</title>
    </head>
    <body>
        <h1>Admin Login Page</h1>
        <form action="${ctx}/admin/login" method="post">
            USERNAME <input name="username" value="admin"><br/>
            PASSWORD <input type="password" name="password" value="admin"><br/>
            <input type="submit" value="LOGIN">
        </form>
        <p>${requestScope.msg}</p>
    </body>
</html>