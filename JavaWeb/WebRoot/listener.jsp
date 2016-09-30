<%@ page language="java" import="java.util.*" import="cn.tla001.listener.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>listener</title>
    
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
  test
    <%
  	
  		request.setAttribute("cn","China");
  		//session.invalidate();  //销毁session
  		
  		session.setAttribute("userName","Jack");
  		session.removeAttribute("userName");
  		session.setAttribute("userName","Jack_new");
  		
  		session.setAttribute("userInfo",new MySessionBind());
  		session.removeAttribute("userInfo");
  	%>
  </body>
</html>
