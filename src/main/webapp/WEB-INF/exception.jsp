<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>服务器异常</title>
</head>
<body>
<% Exception ex = (Exception) request.getAttribute("Exception");%>
<H2>服务器出现异常:<%=ex.getMessage()%>
</H2>
</body>
</html>