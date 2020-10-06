<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<f:form method="post" action="/update-user/update" modelAttribute="userUpdate">
    Name <f:input type="text" path="name"/>
    <br>
    <f:errors path="name"/>
    <br>
    Password <f:input type="password" path="password"/>
    <br>
    <f:errors path="password"/>
    <br>
    <f:button>Update</f:button>
</f:form>
</body>
</html>
