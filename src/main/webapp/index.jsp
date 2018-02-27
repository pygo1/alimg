<%--
  Created by IntelliJ IDEA.
  User: zhengfeng
  Date: 2018/2/25
  Time: 02:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String appContext = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + appContext;
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
</head>
<body>

</body>
</html>
