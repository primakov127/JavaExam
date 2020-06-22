import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class Login extends HttpServlet {

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

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            String data = "SELECT * FROM Users";
            resultSet = statement.executeQuery(data);

            while (resultSet.next()) {

                if (resultSet.getString("login").equals(login) &&
                        resultSet.getString("password").equals(password)) {

                    req.getSession().setAttribute("name", login);
                    resp.sendRedirect(req.getContextPath() + "/operation.jsp");
                    return;
                }
            }

            throw new IOException("Wrong login or password");


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
