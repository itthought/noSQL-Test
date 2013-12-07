<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="Server.*" language="java" %>
<%@ page import="redis.clients.jedis.Jedis" language="java" %>
<title>Insert title here</title>
</head>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
 
<body>
<%
 
Jedis jedis = RedisManager.getInstance().getJedis();
jedis.set("foo", "bar");
String foobar = jedis.get("foo");
out.println(foobar);
RedisManager.getInstance().returnJedis(jedis);
 
%>
</body>
</html>