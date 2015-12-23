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
 		var re1;
        var tel = document.getElementById('text1').value;
        re1= /^0(([1-9]/d)|([3-9]/d{2}))/d{8}$/;
     //   var phone = document.getElementById('text2').value;
		//var re2 = /^0(([1-9]/d)|([3-9]/d{2}))/d{8}$/;
        if(!re1.test(tel)){
        //	if(re2.test(phone)){
        //		alert("确认添加？");
  		//		frm.submit();
  		//		window.close();
       // 	}else
      //  	{
      //  		document.getElementById('text2').innerText="请输入正确的手机号码！";
      //  	}
   //     }else
    //    {
			alert("请输入正确的手机号码！");
        // document.getElementById('imagebutton1').disabled=true; //禁用Button用disabled
        }
 		


  
 		
 	}
</script>
	<title>新增用户</title>
</head>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="24" bgcolor="#7B68EE "><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="98%" valign="bottom" align="left"><span class="STYLE1">新增用户</span></td>
              </tr>
            </table></td>
              </tr>
        </table></td>
      </tr>
  <tr>
   <td>
    <form name="frm" id="frm" method="post"  action="userAction!createUser.action">
<table class="STYLEE23" width="100%">
  <tr>
    <td width="10%" style="text-align: right;background-color: #d3eaef; ">用户名</td>
    <td width="30%" style="text-align: left;"><input type="text" name="userName" /></td>
    <td width="10%" style="text-align: right;background-color: #d3eaef; ">角色</td>
    <td width="30%" style="text-align: left;">
    <select name="systemRoleId">
    	<option>--请选择--</option>
    	<c:forEach items="${queryList}" var="temp">
    		<option value="${temp.systemRoleId}">${temp.roleName}</option>
    	</c:forEach>
    </select>
	</td>
  </tr>
   <tr>
    <td width="10%" style="text-align: right;background-color: #d3eaef; ">真实姓名</td>
    <td width="30%" style="text-align: left;"><input type="text" name="realName" /></td>
    <td width="10%" style="text-align: right;background-color: #d3eaef; ">所在单位</td>
    <td width="30%" style="text-align: left;"><input type="text" name="unit" /></td>
  </tr>
   <tr>
    <td width="10%" style="text-align: right;background-color: #d3eaef; ">联系手机</td>
    <td width="30%" style="text-align: left;"><input id="text1" type="text" name="mobilephone" /></td>
    <td width="10%" style="text-align: right;background-color: #d3eaef; ">联系电话</td>
    <td width="30%" style="text-align: left;"><input id="text2" type="text" name="telephone" /></td>
  </tr>
  <tr>
  	<td width="10%" style="text-align: right;background-color: #d3eaef; ">邮箱</td>
    <td width="30%" style="text-align: left;"><input type="text" name="email" /></td>
  	<td width="10%" style="text-align: right;background-color: #d3eaef; ">所在地区</td>
    <td width="30%" style="text-align: left;"><input type="text" name="area" /></td>
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