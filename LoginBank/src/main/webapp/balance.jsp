<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %><%
    String hostName = "primakov.database.windows.net";
    String dbName = "JavaLab";
    String user = "primakov127";
    String password = "fDj_32srGF2sotF1";
    String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
            + "trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    connection = DriverManager.getConnection(url);
    statement = connection.createStatement();
    String data = "SELECT * FROM Users WHERE [login] = " + "'" + request.getSession().getAttribute("name").toString() + "'";
    resultSet = statement.executeQuery(data);
    resultSet.next();
    int balance = resultSet.getInt("balance");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Balance</title>
</head>
<body>
<h1>Your balance: <%= balance%></h1>
<button onclick="location.href='operation.jsp'">Back</button>
</body>
</html>
