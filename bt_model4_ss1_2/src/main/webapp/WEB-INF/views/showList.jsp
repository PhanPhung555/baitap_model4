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