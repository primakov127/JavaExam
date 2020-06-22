package Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class Submit extends TagSupport {
    private String label;

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            String outputText = String.format("<input type=\"submit\" value=\"%s\">", label);
            pageContext.getOut().println(outputText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
