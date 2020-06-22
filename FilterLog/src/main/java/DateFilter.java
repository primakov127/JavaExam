import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

public class DateFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(Servlet.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        Date date = new Date();
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        LOGGER.info(date.toString() + request.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
