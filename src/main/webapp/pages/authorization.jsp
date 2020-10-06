<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<f:form  method="post" action="/auth-user/auth/" modelAttribute="userAuth">
    Login <f:input type="text" path="login"/>
    <br>
    <f:errors path="login"/>
    <br>
    Password <f:input type="password" path="password"/>
    <br>
    <f:errors path="password"/>
    <br>
    <f:button>Authorization</f:button>
</f:form>
</body>
</html>
