<%
    String message = pageContext.getException().getMessage();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <h2 style="color: red">Ooops... Exception occurred while processing the request</h2>
    <p class="information">Message: <%= message %></p>

</html>