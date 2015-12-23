<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>找回用户登录的密码</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function check(){
		if(document.getElementById("userName").value==""){
			alert("请输入用户名！");
			document.getElementById("userName").focus();
			return (false);
		}
		if(document.getElementById("mobilephone").value==""){
			alert("请输入手机号码！");
			document.getElementById("mobilephone").focus();
			return (false);
		}
		if(document.getElementById("email").value==""){
			alert("请输入邮箱！");
			document.getElementById("email").focus();
			return (false);
		}
		return true;
	}
	</script>
  </head>
  
  <body>
  	<form name="retrieveForm" action="loginAction!retrieve.action" method="post" >
  	<center>
	 <table border="5" align="center">
	  <tr>
		<td>用户名:</td>
		 <td> <input type="text" name="userName" id="userName"></td>
			</tr>
			<tr>
			<td>手机号码:</td>
			<td><input type="text" name="mobilephone" id="mobilephone"></td>
			</tr>
			<tr>
			<td>邮箱:</td>
			<td><input type="text" name="email" id="email"></td>
			</tr>
			<tr>
			<td></td>
			<td><input type="Submit" name="Submit" value="找回密码" onclick="return check();"/>
			&nbsp;&nbsp;&nbsp;
			<input type="reset" name="reset" value="重置"/></td>
		 </tr>
		</table>
	 </center>	
	</form>
    	
  </body>
</html>
