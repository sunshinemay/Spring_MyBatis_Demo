<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>admin add page</title>
    </head>
    <body>
        <h1>Admin Add Page</h1>
        <form action="${ctx}/admin/add" method="post">
            USERNAME: <input name="username"><br>
            PASSWORD: <input name="password"><br>
            <input type="submit" value="ADD">
        </form>
    </body>
</html>