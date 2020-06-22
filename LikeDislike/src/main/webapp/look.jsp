<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<html>
<head>
    <title>LOOK</title>
</head>
<body>
<table>
    <thead>
        <tr>
            <th>Text</th>
            <th>Like</th>
            <th>Dislike</th>
        </tr>
    </thead>
    <tbody>
    <%
        String hostName = "primakov.database.windows.net";
        String dbName = "JavaLab";
        String user = "primakov127";
        String password = "fDj_32srGF2sotF1";
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
                + "trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(url);
        statement = connection.createStatement();
        String data = "SELECT * FROM LikeDislike";
        resultSet = statement.executeQuery(data);
        while (resultSet.next()) {
    %>
    <tr>
        <td><%= resultSet.getString("text")%></td>
        <td><%= resultSet.getInt("like")%></td>
        <td><%= resultSet.getInt("dislike")%></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<form action="Like" method="post">
    <input type="submit" value="like"/>
</form>
<form action="Like" method="get">
    <input type="submit" value="dislike"/>
</form>
</body>
</html>
