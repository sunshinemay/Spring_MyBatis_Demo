<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>message edit page</title>
    </head>
    <body>
        <h1>Message Edit Page</h1>
        <form action="${ctx}/message/modify" method="post">
            <input type="hidden" name="id" value="${sessionScope.message.id}">
            NAME: <input name="name" value="${sessionScope.message.name}"><br>
            CONTENT: <input name="content" value="${sessionScope.message.content}"><br>
            TIME: <input name="time" value="${sessionScope.message.time}"><br>
            <input type="submit" value="UPDATE">
        </form>
    </body>
</html>