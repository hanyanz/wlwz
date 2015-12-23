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
	<title>修改项目</title>
</head>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="24" bgcolor="#7B68EE "><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="98%" valign="bottom" align="left"><span class="STYLE1">修改项目</span></td>
              </tr>
            </table></td>
              </tr>
        </table></td>
      </tr>
  <tr>
   <td>
   <form  method="post"  action="projectAction!saveEdit.action">
   <input type="hidden" name="projectId" value="${p.projectId}"/>
<table class="STYLEE23" width="100%">
 <tr>
    <td width="30%" style="text-align: right;background-color: #d3eaef; ">项目名</td>
    <td width="70%" style="text-align: left;"><input name="projectName" value="${p.projectName}"/></td>
  </tr>
  <tr>
    <td style="text-align: right;background-color: #d3eaef;">项目地址</td>
    <td style="text-align: left;"><input name="projectAddress" value="${p.projectAddress}"/></td>
  </tr>
  <tr>
    <td style="text-align: right;background-color: #d3eaef;">项目负责人</td>
    <td style="text-align: left;"><input name="projectLeader" value="${p.projectLeader}"/></td>
  </tr>
  <tr>
    <td style="text-align: right;background-color: #d3eaef;">联系电话</td>
    <td style="text-align: left;"><input name="telephone" value="${p.telephone}"/></td>
  </tr>
  <tr>
    <td colspan="2" style="text-align: center;">
      <label>
        <input type="submit" name="Submit" value="提交"  />
        <input type="reset" name="reset" value="重置"/>
        </label>
	</td>
  </tr>
</table>
</form>
	</td>
	</tr>
	</table>
</body>
</html>