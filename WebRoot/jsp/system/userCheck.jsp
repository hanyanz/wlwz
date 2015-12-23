<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<link type="text/css" href="${pageContext.request.contextPath}/css/table.css" rel="stylesheet"/>
	 <script src="${pageContext.request.contextPath}/js/qq_alert/jquery-1.2.6.pack.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/select.js"></script>
	<link href="${pageContext.request.contextPath}/calendar/jquery.datepick.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/calendar/jquery.datepick.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/calendar/jquery.datepick-zh-CN.js"></script>
<script language="javascript" type="text/javascript" >

$(document).ready(function(){
	$('.date').datepick({dateFormat: 'yy-mm-dd'});
});
</script>
	<title>查看用户信息</title>
</head>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="24" bgcolor="#7B68EE "><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="98%" valign="bottom" align="left"><span class="STYLE1">查看用户信息</span></td>
              </tr>
            </table></td>
              </tr>
        </table></td>
      </tr>
  <tr>
   <td>
<table class="STYLEE23" width="100%">
    <tr>
    <td width="10%" style="text-align: right;background-color: #d3eaef; ">用户名</td>
    <td width="30%" style="text-align: left;">${user.userName}</td>
    <td width="10%" style="text-align: right;background-color: #d3eaef; ">角色</td>
    <td width="30%" style="text-align: left;">${user.systemrole.roleName}</td>
  </tr>
   <tr>
    <td width="10%" style="text-align: right;background-color: #d3eaef; ">真实姓名</td>
    <td width="30%" style="text-align: left;">${user.realName}</td>
    <td width="10%" style="text-align: right;background-color: #d3eaef; ">所在单位</td>
    <td width="30%" style="text-align: left;">${user.unit }</td>
  </tr>
   <tr>
    <td width="10%" style="text-align: right;background-color: #d3eaef; ">联系手机</td>
    <td width="30%" style="text-align: left;">${user.mobilephone}</td>
    <td width="10%" style="text-align: right;background-color: #d3eaef; ">联系电话</td>
    <td width="30%" style="text-align: left;">${user.telephone}</td>
  </tr>
  <tr>
  	<td width="10%" style="text-align: right;background-color: #d3eaef; ">邮箱</td>
    <td width="30%" style="text-align: left;">${user.email}</td>
  	<td width="10%" style="text-align: right;background-color: #d3eaef; ">所在地区</td>
    <td width="30%" style="text-align: left;">${user.area}</td>
  </tr>
</table>
	</td>
	</tr>
	</table>
</body>
</html>