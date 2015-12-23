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

 	function add(){
  		
 		frm.submit();
 		alert("添加成功！");
 		window.close();
 	}
</script>
	<title>新增设备</title>
</head>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="24" bgcolor="#7B68EE "><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="98%" valign="bottom" align="left"><span class="STYLE1">新增设备</span></td>
              </tr>
            </table></td>
              </tr>
        </table></td>
      </tr>
  <tr>
   <td>
    <form name="frm" id="frm" method="post"  action="deviceAction!createDevice.action">
<table class="STYLEE23" width="100%">
  <tr>
    <td width="30%" style="text-align: right;background-color: #d3eaef; ">设备编号</td>
    <td width="70%" style="text-align: left;">
      <input type="text" name="deviceNumber" /></td>
  </tr>
  <tr>
    <td style="text-align: right;background-color: #d3eaef;">设备种类</td>
    <td style="text-align: left;">
    <select name="deviceBigKind">
    	<option value="1">吊管机</option>
    	<option value="2">移动电机</option>
    </select>
    </td>
  </tr>
  <tr>
    <td style="text-align: right;background-color: #d3eaef;">所属中队</td>
    <td style="text-align: left;">
    <select name="midteamId">
    	<option>--请选择--</option>
    	<c:forEach items="${m}" var="m">
    		<option value="${m.midteamId}">${m.midteamName}</option>
    	</c:forEach>
    </select>
    </td>
  </tr>
  <tr>
    <td style="text-align: right;background-color: #d3eaef;">所属项目</td>
    <td style="text-align: left;">
    <select name="projectId">
    	<option>--请选择--</option>
    	<c:forEach items="${p}" var="p">
    		<option value="${p.projectId}">${p.projectName}</option>
    	</c:forEach>
    </select>
    </td>
  </tr>
  <tr>
    <td colspan="2" style="text-align: center;">
      <label>
        <input type="submit" name="Submit" value="提交" onclick="add();" />
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