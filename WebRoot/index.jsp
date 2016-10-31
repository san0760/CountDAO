<%@page import="item.user"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    当前在线人数：${userNumber }<br/>
    <%ArrayList<user> userList = (ArrayList<user>)request.getServletContext().getAttribute("userList");
    if(userList!=null){
    for(int i=0;i < userList.size();i++){
    	user user=userList.get(i);
    %>
    IP:<%=user.getIpString() %>
    首次访问：<%=user.getFirstTime() %>
   SessionId: <%=user.getSessionId() %><br/>
   <%}} %>
  </body>
</html>
