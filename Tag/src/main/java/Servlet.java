import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Получаем данные, которые ты ввёл в поле
        String passport = request.getParameter("passport");

        String day = request.getParameter("txbDay");
        String month = request.getParameter("txbMonth");
        String year = request.getParameter("txbYear");

        String row = request.getParameter("row");
        String column = request.getParameter("column");

        //проверяем корректность, чтобы первые две буквы были HB и потом 7 цифр
        boolean result = passport.matches("HB\\d{7}");
        if (result == true) {
            request.setAttribute("Correct", passport);
        } else {
            request.setAttribute("Correct", "No correct");
        }

        //Проверяем корректнось введёных данных (день, месяц, год)
        if (Integer.parseInt(day) >= 0 && Integer.parseInt(day) <= 31) {
            if (Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 12) {
                if (Integer.parseInt(year) >= 1900) {
                    request.setAttribute("day", day);
                    request.setAttribute("month", month);
                    request.setAttribute("year", year);
                } else {
                    request.setAttribute("year", "Year error");
                }
            } else {
                request.setAttribute("month", "Month error");
            }
        } else {
            request.setAttribute("day", "Day error");
        }
        //таблица в столбик
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        request.setAttribute("list", list);
        request.setAttribute("sum", 6);
        //количество строк и столбцов таблицы
        request.setAttribute("row", row);
        request.setAttribute("column", column);
        //Переходим на custom.jsp, где вызывается пользовательский тег
        //для тега свой класс, который расположены в папке Tags
        getServletContext().getRequestDispatcher("/custom.jsp").forward(request, response);
    }
}

