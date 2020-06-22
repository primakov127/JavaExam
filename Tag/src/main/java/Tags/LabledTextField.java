package Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class LabledTextField extends TagSupport {

    private String label;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            String outputText = String.format("<input type=\"text\" name=\"%s\" placeholder=\"%s\">", name, label);
            pageContext.getOut().write(outputText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

}
