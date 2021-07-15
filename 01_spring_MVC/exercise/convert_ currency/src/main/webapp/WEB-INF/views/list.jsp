<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14/07/2021
  Time: 10:40 SA
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="abc" method="post" >
    <table border="1">
        <tr>
            <th>So Tien chuyen doi</th>
            <th>tien</th>
            <th>thanh tien</th>
            <th>ket qua</th>
        </tr>
        <tr>
            <th>
                <input type="number" name="money" placeholder="Tiền cần thay đổi">
            </th>
            <th>
                <select name="exchangeMoney">
                    <option value="23000">VND</option>
                    <option value="1">USD</option>
                </select>
            </th>
            <th>
                <select name="moneyChanged">
                    <option value="1">USD</option>
                    <option value="23000">VND</option>
                </select>
            </th>
            <th>
                <input type="submit" value="Convert">
                <input type="text" name="result" readonly value="${result}">
            </th>
        </tr>
    </table>
</form>
</body>
</html>