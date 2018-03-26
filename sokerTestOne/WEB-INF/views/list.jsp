<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/5
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Show Page</title>
</head>
<body>
request:${requestScope.persons}<br/>
<table border="1" cellspacing="0" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>LastName</th>
        <th>Email</th>
    </tr>

    <c:forEach items="${persons}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <th>${p.email}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
