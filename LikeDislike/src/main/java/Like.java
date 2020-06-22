import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class Like extends HttpServlet {

    String hostName = "primakov.database.windows.net";
    String dbName = "JavaLab";
    String user = "primakov127";
    String password = "fDj_32srGF2sotF1";
    String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
            + "trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    // + (like)
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {


        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            String data = "SELECT * FROM LikeDislike";
            resultSet = statement.executeQuery(data);
            resultSet.next();
            int count = resultSet.getInt("like");

            statement.executeUpdate("UPDATE LikeDislike SET [like] = " + (count+1) + "WHERE [like] = " + count);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }



        response.sendRedirect(request.getContextPath() + "/look.jsp");
    }

    // - (dislike)
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {


        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            String data = "SELECT * FROM LikeDislike";
            resultSet = statement.executeQuery(data);
            resultSet.next();
            int count = resultSet.getInt("dislike");

            statement.executeUpdate("UPDATE LikeDislike SET [dislike] = " + (count+1) + "WHERE [dislike] = " + count);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/look.jsp");
    }
}
