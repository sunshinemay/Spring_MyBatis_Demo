<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="/commons/inc.jsp" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>message add page</title>
    <script>
        function check() {
            if (document.getElementById('name').value == '' || document.getElementById('content').value == '') {
                alert('name and password can not be null.');
                return false;
            } else {
                return true
            }
        }
    </script>
</head>
<body>
<h1>Message Add Page</h1>

<form action="${ctx}/message/add" method="post" onsubmit="return check()">
    NAME: <input id="name" name="name"><br>
    CONTENT: <textarea id="content" name="content" cols="100" rows="5"></textarea><br>
    <input type="submit" value="ADD">
</form>
</body>
</html>