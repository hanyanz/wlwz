<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>远程监控参数配置成功</title>
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
                参数配置成功！ <br>     
                请按 fe+ 0x11 + userName(varchar(20)) + IMEI(varchar(50))  + dataLength + dataBody + CRC的格式把数据发送到：IP+端口<br>
                如果您需要添加视频 监控，请。。。。。<br/>
                访问远程监控网站请点击链接：<a href="main.jsp">远程监控首页</a> <br/>
                重新登录请点击链接：<a href="login.jsp">登录</a><br>
                如有疑问，请联系 028-xxxxxxxx;
              
  </body>
</html>
