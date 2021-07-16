<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15/07/2021
  Time: 4:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator">
    <h3>Calculator</h3>

    <input type="number" name="numberOne" placeholder="input number">
    <input type="number" name="numberSecond" placeholder="input number">

    <br>
    <br>
    <br>

    <div>
        <button type="submit" value="+" name="calculator">Addition</button>
        <button type="submit" value="-" name="calculator">Subtraction</button>
        <button type="submit" value="*" name="calculator">Multiplication</button>
        <button type="submit" value="/" name="calculator">Division</button>
        </br></br>
        <span>Result ${result}</span>
    </div>
</form>
</body>
</html>