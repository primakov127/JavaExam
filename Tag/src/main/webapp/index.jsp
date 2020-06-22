<%@taglib prefix="my" uri="/WEB-INF/tags.tld" %>
<html>
<body>
<h2>Hello World!</h2>
</body>
<form action="Servlet" method="get">
    <my:LabledTextField label="HB0000000" name="passport"/>
    <br>
    <my:LabledTextField label="enter day" name="txbDay"/>
    <br>
    <my:LabledTextField label="enter month" name="txbMonth"/>
    <br>
    <my:LabledTextField label="enter year" name="txbYear"/>
    <br>
    <input type="text" name="row" placeholder="row"/>
    <br>
    <input type="text" name="column" placeholder="col"/>
    <br/>
    <my:Submit label="Check"/>
</form>
</html>
