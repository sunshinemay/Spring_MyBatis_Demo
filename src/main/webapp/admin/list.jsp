<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>admin list page</title>
        <script>
            function del() { return confirm('REMOVE?'); }
        </script>
    </head>
    <body>
        <h1>Admin List Page</h1>
        <hr/>
        <c:import url="add.jsp"/>
        <hr/>
        <form action="${ctx}/admin/fuzzy" method="post">
            USERNAME <input name="username">
            PASSWORD <input name="password">
            <input type="submit" value="QUERY">
        </form>
        <hr/>
        <table border="1">
            <tr>
                <th>INDEX</th>
                <th>ID</th>
                <th>USERNAME</th>
                <th>PASSWORD</th>
                <th colspan="2">OPERATION</th>
            </tr>
            <c:forEach var="admin" items="${sessionScope.list }" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${admin.id}</td>
                <td>${admin.username}</td>
                <td>${admin.password}</td>
                <td><a href="${ctx}/admin/search/${admin.id}">EDIT</a></td>
                <td><a class="delete" href="${ctx }/admin/remove/${admin.id}" onclick="return del()">REMOVE</a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>