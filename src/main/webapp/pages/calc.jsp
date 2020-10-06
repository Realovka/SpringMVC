<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<f:form method="post" action="/calc/calc-page/" modelAttribute="operation">
    Num1 <f:input path="num1"/>
    <br>
    <f:errors path="num1"/>
    <br>
    Num2 <f:input path="num2"/>
    <br>
    <f:errors path="num2"/>
    <br>
    Operation <f:input path="operationType"/>
    <br>
    <f:errors path="operationType"/>
    <br>
    <f:button>Submit</f:button>
    <br>
    ${result}
    <br>
    <a href="/history/history-get">History</a>
</f:form>
</body>
</html>
