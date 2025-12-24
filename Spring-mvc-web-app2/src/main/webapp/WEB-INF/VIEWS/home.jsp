<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1 style="color: green;">Welcome
  <%
  String hello = (String)request.getAttribute("hello");
    String user = (String)request.getAttribute("username");
    out.println(hello+""+user);
  %>
  </h1>
  
   <h3>Name : ${u.getUsername()}</h3>
</body>
</html>