<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/30/2023
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <table>
        <tr>
            <td>từ khóa bạn nhập là ${key}</td>
        </tr>
        <tr>
            <td>từ khóa tra ra được là ${value}</td>
        </tr>
    </table>

</fieldset>
<form action="/dictionary/enterList" method="get">
    <input type="submit" value="Quay trở lại từ điển">
</form>
</body>
</html>