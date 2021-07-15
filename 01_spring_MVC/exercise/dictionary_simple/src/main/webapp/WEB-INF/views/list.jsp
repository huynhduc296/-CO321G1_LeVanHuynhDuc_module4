<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14/07/2021
  Time: 5:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="convert" method="post">
    <table border="1">
        <tr>
            <th>English</th>
            <th>convert</th>
            <th>Vietnamese</th>
        </tr>
        <tr>
            <th><input type="text" name="input"></th>
            <th><input type="submit" value="translate"></th>
            <th><input type="text" readonly value="${result}"></th>
        </tr>
    </table>
</form>
</body>
</html>