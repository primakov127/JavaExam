package Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.ArrayList;

public class Table extends TagSupport {
    private ArrayList<Object> objects;
    private int sum;

    public void setObjects(ArrayList<Object> objects) {
        this.objects = objects;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


    @Override
    public int doStartTag() throws JspException {
        try {
            String outputText = "<table>";
            for (Object obj : objects
            ) {
                outputText += "<tr><td>" + obj.toString() + "<hr></td></tr>";
            }
            outputText += "<tr><td>Sum: " + sum + "</tr></td>";
            outputText += "</table>";
            pageContext.getOut().write(outputText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
