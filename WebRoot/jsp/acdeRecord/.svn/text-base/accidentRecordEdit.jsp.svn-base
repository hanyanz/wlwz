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
	document.getElementById("ar").value = "${a.accidentReason}";
	document.getElementById("ada").value = "${a.damageAssessment}";
	document.getElementById("ad").value = "${a.disposeRecord}";
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
   <form  method="post"  action="accidentrecordAction!saveEdit.action">
   <input type="hidden" name="accidentRecordId" value="${a.accidentRecordId}"/>
<table class="STYLEE23" width="100%">
  <tr>
    <td width="10%" style="text-align: right;background-color: #d3eaef; ">设备编码</td>
    <td width="30%" style="text-align: left;">${a.device.deviceNumber }</td>
    <td width="10%" style="text-align: right;background-color: #d3eaef;">事故类型</td>
    <td width="30%" style="text-align: left;"><input type="text"  name="accidentType" value="${a.accidentType }"/></td>
  </tr>
  <tr>
    <td style="text-align: right;background-color: #d3eaef;">事故单位</td>
    <td style="text-align: left;"><input type="text" name="accidentUint" value="${a.accidentUint}"/></td>
    <td style="text-align: right;background-color: #d3eaef;">事故负责人</td>
    <td style="text-align: left;"><input type="text" name="responsiblePerson" value="${a.responsiblePerson }"/></td>
  </tr>
  <tr>
    <td style="text-align: right;background-color: #d3eaef;">事故原因</td>
    <td style="text-align: left;"><textarea id="ar" name="accidentReason" style="width:95%;overflow:auto" rows=""></textarea></td>
    <td style="text-align: right;background-color: #d3eaef;">事故日期</td>
    <td style="text-align: left;"><input type="text" name="createTime" value="${a.createTime}"/></td>
  </tr>
  <tr>
    <td style="text-align: right;background-color: #d3eaef;">损坏情况</td>
    <td style="text-align: left;"><textarea id="ada"name="damageAssessment" style="width:95%;overflow:auto" rows=""></textarea></td>
    <td style="text-align: right;background-color: #d3eaef;">损坏价值</td>
    <td style="text-align: left;"><input type="text" name="damageValue" value="${a.damageValue}"/></td>
  </tr>
  <tr>
    <td style="text-align: right;background-color: #d3eaef;">处理记录</td>
    <td style="text-align: left;"><textarea id="ad"name="disposeRecord" style="width:95%;overflow:auto" rows=""></textarea></td>
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