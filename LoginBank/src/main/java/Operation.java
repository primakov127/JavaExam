import org.apache.log4j.Logger;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class Operation extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(Servlet.class);

    String hostName = "primakov.database.windows.net";
    String dbName = "JavaLab";
    String user = "primakov127";
    String password = "fDj_32srGF2sotF1";
    String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
            + "trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection connection;
        Statement statement;
        ResultSet resultSet;

        int balance;
        int amount = Integer.parseInt(req.getParameter("amount"));
        String login = req.getSession().getAttribute("name").toString();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            String data = "SELECT balance FROM Users WHERE login = " + "'" + login + "'";
            resultSet = statement.executeQuery(data);
            resultSet.next();
            balance = resultSet.getInt("balance");

            if (balance >= amount) {
                statement.executeUpdate("UPDATE Users SET [balance] = " + (balance - amount) + " WHERE [login] = " + "'" + login + "'");
                LOGGER.info(new java.util.Date().toString() + " " + login + " took " + amount + ". Balance: " + (balance - amount));
            }

            resp.sendRedirect(req.getContextPath() + "/operation.jsp");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
