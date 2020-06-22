package Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Day extends TagSupport {
    //private static final long serialVersionUID = 1L;
    private String myDay;
    private String myMonth;
    private String myYear;

    public void setMyDay(String myDay) {
        this.myDay = myDay;
    }

    public void setMyMonth(String myMonth) {
        this.myMonth = myMonth;
    }

    public void setMyYear(String myYear) {
        this.myYear = myYear;
    }

    public int doStartTag() throws JspException {
        try {
            //Выводим день на my.jsp
            pageContext.getOut().println(this.myDay);
            pageContext.getOut().println(this.myMonth);
            pageContext.getOut().println(this.myYear);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
