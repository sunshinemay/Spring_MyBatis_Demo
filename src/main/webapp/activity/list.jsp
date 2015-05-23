<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>activity list page</title>
        <script>
            function del() { return confirm('REMOVE?'); }
        </script>
    </head>
    <body>
        <h1>Activity List Page</h1>
        <hr/>
        <c:import url="add.jsp"/>
        <hr/>
        <form action="${ctx}/activity/fuzzy" method="post">
            NAME <input name="name">
            <input type="submit" value="QUERY">
        </form>
        <hr/>
        <table border="1">
            <tr>
                <th>INDEX</th>
                <th>ID</th>
                <th>NAME</th>
                <th colspan="2">OPERATION</th>
            </tr>
            <c:forEach var="activity" items="${sessionScope.list }" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${activity.id}</td>
                <td>${activity.name}</td>
                <td><a href="${ctx}/activity/search/${activity.id}">EDIT</a></td>
                <td><a class="delete" href="${ctx }/activity/remove/${activity.id}" onclick="return del()">REMOVE</a></td>
            </tr>
            </c:forEach>
        </table>
        <hr/>
        <p><a href="${ctx}/admin/queryEnrollInfo">Query Enroll Info</a></p>
    </body>
</html>