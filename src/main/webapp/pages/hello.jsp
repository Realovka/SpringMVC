<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<f:form action="/user-home-page/get" method="post">
Hello, ${sessionScope.userAuth.name}
    <br>
    <a href="/update-user/update">Update user</a>
    <br>
    <a href="/delete/deleteUser">Delete user</a>
    <br>
    <a href="/calc/calc-page">Calculator</a>

</f:form>
</body>
</html>
