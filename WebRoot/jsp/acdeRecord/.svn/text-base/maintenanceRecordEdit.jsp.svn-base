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

window.onload = function init(){
	document.getElementById("mc").value = "${m.maintenanceContent}";
	document.getElementById("am").value = "${m.attentionMatters}";
}

$(document).ready(function(){
	$('.date').datepick({dateFormat: 'yy-mm-dd'}); 
});
</script>
	<title>修改记录</title>
</head>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="24" bgcolor="#7B68EE "><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="98%" valign="bottom" align="left"><span class="STYLE1">修改记录</span></td>
              </tr>
            </table></td>
              </tr>
        </table></td>
      </tr>
  <tr>
   <td>
   <form  method="post"  action="maintenancerecordAction!saveEdit.action">
   <input type="hidden" name="maintenanceRecordId" value="${m.maintenanceRecordId}"/>
<table class="STYLEE23" width="100%">
  <tr>
    <td width="10%" style="text-align: right;background-color: #d3eaef; ">设备编码</td>
    <td width="30%" style="text-align: left;">${m.device.deviceNumber }</td>
    <td width="10%" style="text-align: right;background-color: #d3eaef;">保修类型</td>
    <td width="30%" style="text-align: left;">
    <select name="maintenanceKind" >
	    <option value="0">--请选择--</option>
	    <option value="1">小修</option>
	    <option value="2">中修</option>
	    <option value="3">大修</option>
    </select>
    </td>
  </tr>
  <tr>
    <td style="text-align: right;background-color: #d3eaef;">修理地点</td>
    <td style="text-align: left;"><input type="text" name="maintenancePlace" value="${m.maintenancePlace}"/></td>
    <td style="text-align: right;background-color: #d3eaef;">保修日期</td>
    <td style="text-align: left;"><input type="text" name="createTime" value="${m.createTime}"/></td>
  </tr>
  <tr>
    <td style="text-align: right;background-color: #d3eaef;">修理内容</td>
    <td style="text-align: left;"><textarea id="mc"name="maintenanceContent" style="width:95%;overflow:auto" rows=""></textarea></td>
  </tr>
  <tr>
    <td style="text-align: right;background-color: #d3eaef;">注意事项</td>
    <td style="text-align: left;"><textarea id="am"name="attentionMatters" style="width:95%;overflow:auto" rows=""></textarea></td>
  </tr>
  <tr>
    <td colspan="3" style="text-align: center;">
      <label>
        <input type="submit" name="Submit" value="提交"/>
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