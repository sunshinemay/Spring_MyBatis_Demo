<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>enroll list page</title>
        <script>
            function del() { return confirm('REMOVE?'); }
        </script>
    </head>
    <body>
        <h1>Enroll List Page</h1>
        <form action="${ctx}/enroll/fuzzy" method="post">
            SNO <input name="sno">
            SNAME <input name="sname">
            ACTIVITYID <input name="activityId">
            <input type="submit" value="QUERY">
        </form>
        <hr/>
        <table border="1">
            <tr>
                <th>INDEX</th>
                <th>ID</th>
                <th>SNO</th>
                <th>SNAME</th>
                <th>ACTIVITYID</th>
                <th colspan="2">OPERATION</th>
            </tr>
            <c:forEach var="enroll" items="${sessionScope.list}" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${enroll.id}</td>
                <td>${enroll.sno}</td>
                <td>${enroll.sname}</td>
                <td>${enroll.activityId}</td>
                <td><a href="${ctx}/enroll/search/${enroll.id}">EDIT</a></td>
                <td><a class="delete" href="${ctx }/enroll/remove/${enroll.id}" onclick="return del()">REMOVE</a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>