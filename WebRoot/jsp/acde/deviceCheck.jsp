<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>设备信息</title>
	<link type="text/css" href="${pageContext.request.contextPath}/css/table.css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/calendar/jquery.datepick.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/calendar/jquery-1.3.2.min.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/calendar/jquery.datepick.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/calendar/jquery.datepick-zh-CN.js"></script>
<script language="javascript" type="text/javascript" >
		$(document).ready(function(){
			$('.datetime').datepick({dateFormat: 'yy-mm-dd'}); 
		});
	</script>
</head>

<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="88%" height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#7B68EE"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="98%" valign="bottom" align="left"><span class="STYLE1"> 设备详细信息</span></td>
              </tr>
            </table></td>
            <td>
              </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>
    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td width="12%" height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align:right;background-color: #d3eaef;">设备名称</td>
        <td  width="30%" height="20" bgcolor="#FFFFFF" class="STYLE19">
          <label>
          ${employeeDetail.entepriseInfo.comname}
          </label></td>
           <td width="12%" height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align:right;background-color: #d3eaef;">资产编号</td>
        <td width="30%" height="20" bgcolor="#FFFFFF" class="STYLE19">
          <label>
          	${employeeDetail.sex}
          </label>
          </td>
        </tr>
        <tr>
        <td width="12%" height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align:right;background-color: #d3eaef;">设备种类</td>
        <td  width="30%" height="20" bgcolor="#FFFFFF" class="STYLE19">
          <label>
          ${employeeDetail.entepriseInfo.users.unit}
          </label></td>
           <td width="12%" height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align:right;background-color: #d3eaef;">单位代码</td>
        <td width="30%" height="20" bgcolor="#FFFFFF" class="STYLE19">
          <label>
          	${employeeDetail.sex}
          </label>
          </td>
        </tr>
      <tr>
        <td width="12%" height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align:right;background-color: #d3eaef;">设备编码</td>
        <td width="30%" height="20" bgcolor="#FFFFFF" class="STYLE19">
          <label>
          ${employeeDetail.name}
          </label></td>
        <td width="12%" height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align:right;background-color: #d3eaef;">所属中队</td>
        <td width="30%" height="20" bgcolor="#FFFFFF" class="STYLE19">
          <label>
          	${employeeDetail.sex}
          </label>
          </td>
        </tr>
      <tr>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align:right;background-color: #d3eaef;">所属项目</td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19">${employeeDetail.idcard }</td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align:right;background-color: #d3eaef;">设备大类</td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19">
          ${employeeDetail.address}          </td></tr>
      <tr>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align:right;background-color: #d3eaef;">分类名称</td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19">
			${employeeDetail.fkaddress}	
            </td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align:right;background-color: #d3eaef;">型号</td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19">${employeeDetail.degree.education }</td>
      </tr>
      <tr>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align:right;background-color: #d3eaef;">职务</td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19">
            ${employeeDetail.duty }</td>
            <td height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align:right;background-color: #d3eaef;">工厂区域</td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19">
            <fmt:formatDate value="${employeeDetail.rztime }" pattern="yyyy-MM-dd"/>   </td>
        </tr>
      <tr>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align:right;background-color: #d3eaef;">居住证号</td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19">
             ${employeeDetail.zzznum}         </td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align:right;background-color: #d3eaef;">联系电话</td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19">
         ${employeeDetail.phone }
               </td>
        </tr>
	  <tr>
   	    <td height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align:right;background-color: #d3eaef;">从业人员照片 </td>
    	<td height="20" colspan="3" bgcolor="#FFFFFF" class="STYLE19">
    		 		  <c:choose>
						   <c:when test="${empty employeeDetail.imgpath }">
						   	<img alt="${employeeDetail.imgpath  }" src="${pageContext.request.contextPath}/images/nophoto.gif" align="middle" border="0" width="180" height="250"/>
						   </c:when>
						   <c:otherwise> 
						   	<img src="${pageContext.request.contextPath }/${employeeDetail.imgpath }" border="0" width="180" height="250" alt="${employeeDetail.name}"/>
						   </c:otherwise>
					   </c:choose>
    	</td>
       </tr>
    </table>
    </td>
  </tr>
</table>
</body>
</html>
