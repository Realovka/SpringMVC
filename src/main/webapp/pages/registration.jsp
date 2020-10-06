<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<f:form  method="post" action="/reg-user/reg/" modelAttribute="user">
    Name <f:input type="text" path="name"/>
    <br>
    <f:errors path="name"/>
    <br>
    Login <f:input type="text" path="login"/>
    <br>
    <f:errors path="login"/>
    <br>
    Password <f:input type="password" path="password"/>
    <br>
    <f:errors path="password"/>
    <br>
    <f:button>Registration</f:button>
</f:form>
</body>
</html>
