<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>message list page</title>
        <script>
            function del() { return confirm('REMOVE?'); }
        </script>
    </head>
    <body><c:if test="${sessionScope.admin eq null}"><c:redirect url="${ctx}/404.html"/></c:if>
        <h1>Message List Page</h1>
        <form action="${ctx}/message/fuzzy" method="post">
            NAME <input name="name">
            CONTENT <input name="content">
            TIME <input name="time">
            <input type="submit" value="QUERY">
        </form>
        <hr/>
        <table border="1">
            <tr>
                <th>INDEX</th>
                <th>ID</th>
                <th>NAME</th>
                <th>CONTENT</th>
                <th>TIME</th>
                <th>REMOVE</th>
            </tr>
            <c:forEach var="message" items="${sessionScope.list }" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${message.id}</td>
                <td>${message.name}</td>
                <td>${message.content}</td>
                <td><fmt:formatDate value="${message.time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><a class="delete" href="${ctx }/message/remove/${message.id}" onclick="return del()">REMOVE</a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>