<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>activity add page</title>
    </head>
    <body>
        <h1>Activity Add Page</h1>
        <form action="${ctx}/activity/add" method="post">
            NAME: <input name="name"><br>
            <input type="submit" value="ADD">
        </form>
    </body>
</html>