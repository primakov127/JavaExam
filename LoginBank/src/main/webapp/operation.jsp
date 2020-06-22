<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Balance</title>
</head>
<body>
<form action="Operation" method="post">
    <input type="text" name="amount" placeholder="amount"/>
    <input type="submit" value="operation"/>
</form>
<button onclick="location.href='balance.jsp'">Check balance</button>
<button onclick="location.href='/Bank'">Exit</button>
</body>
</html>
