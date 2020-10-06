<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>History</title>
</head>
<body>
${sessionScope.history}
<%--<f:form action="/history/history-post" method="post">--%>
<%--    Operation<f:input path="operatinType"/>--%>
<%--    <f:button>Check operation</f:button>--%>
<%--</f:form>--%>
</body>
</html>
