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
	<title>修改监控参量信息</title>
</head>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="24" bgcolor="#7B68EE "><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="98%" valign="bottom" align="left"><span class="STYLE1">修改监控参量信息</span></td>
              </tr>
            </table></td>
              </tr>
        </table></td>
      </tr>
  <tr>
   <td>
   <form  method="post"  action="depolyAction!saveEdit.action">
   <input type="hidden" name="depolyId" value="${m.depolyId}"/>
<table class="STYLEE23" width="100%">
<tr>
    <td width="30%" style="text-align: right;background-color: #d3eaef; ">参量名</td>
    <td width="70%" style="text-align: left;"><input name="depolyName" value="${m.depolyName}"/></td>
  </tr>
 <tr>
    <td style="text-align: right;background-color: #d3eaef;">数据类型</td>
    <td style="text-align: left;"><select name="depolyDataType" value="${m.depolyDataType}">
          <option selected>varchar</option> <option>int</option>
          <option>tinyint</option><option>float</option>
          <option>timestamp</option> </select></td>
  </tr>
  <tr>
    <td style="text-align: right;background-color: #d3eaef;">数据长度（字节）</td>
    <td style="text-align: left;"><input type="text" name="depolyDataLength" value="${m.depolyDataLength}"/></td>
  </tr>
  <tr>
    <td style="text-align: right;background-color: #d3eaef;">数值上限</td>
    <td style="text-align: left;"><input type="text" name="depolyUpper" value="${m.depolyUppere}"/></td>
  </tr>
  <tr>
    <td style="text-align: right;background-color: #d3eaef;">数值下限</td>
    <td style="text-align: left;"><input type="text" name="depolyLower" value="${m.depolyLower}"/></td>
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