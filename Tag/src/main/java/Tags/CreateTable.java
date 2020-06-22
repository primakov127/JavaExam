package Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class CreateTable extends TagSupport {
    private String myRow;
    private String myCol;

    public void setMyRow(String myRow) {
        this.myRow = myRow;
    }

    public void setMyCol(String myCol) {
        this.myCol = myCol;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            //pageContext.getOut().println(Integer.parseInt(myCol) + " " + Integer.parseInt(myRow));
            pageContext.getOut().println("<html>");
            pageContext.getOut().println("<table border=1>");
            for (int i = 0; i < Integer.parseInt(myRow); i++){
                pageContext.getOut().println("<tr>");
                for(int j = 0; j < Integer.parseInt(myCol); j++){
                    pageContext.getOut().println("<td>" + (j + 1) + "</td>");
                }
            }   pageContext.getOut().println("</tr>");
            pageContext.getOut().println("</table>");
            pageContext.getOut().println("</html>");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
