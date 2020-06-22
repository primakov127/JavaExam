<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="my" uri="/WEB-INF/tags.tld" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <my:TagPasport myPasport="${Correct}"/>
    <br>
    <my:TagDay myDay="${day}" myMonth="${month}" myYear="${year}"/>
    <br>
    <my:Table  objects="${list}" sum="${sum}"/>
    <br>
    <my:CreateTable   myCol="${column}" myRow="${row}"/>
</form>
</body>
</html>
