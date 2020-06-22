package Tags;

import java.io.IOException;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class Passport extends TagSupport{

    private String myPasport;

    public void setMyPasport(String myPasport) {
        this.myPasport = myPasport;
    }

    public int doStartTag() throws JspException {
        try {
            //Выводим паспорт на my.jsp
            pageContext.getOut().println(this.myPasport);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
