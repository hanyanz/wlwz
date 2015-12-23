<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <%@ page language="java" contentType="text/html;charset=UTF-8"%>
    <%@ page import="com.opensymphony.xwork2.util.*"%>  
    <head>
<style type="text/css">
</style>
<title>用户</title>
<script language="JavaScript" type="text/JavaScript">
  function add(){
       window.open('jsp/system/userAdd.jsp','新增',
       'height=300,width=500,top=200,left=400,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
   }
   function check(str){
             var count = 0;
                 $("input:checked").each(function(){
                      count++;
                  });
                  if(count>1){
                 	 alert("只能选择一条记录");
                 	 return false;
                  }
                  else if(count<1){
                  	alert("请选择一条记录");
                  	return false;
                  }
                  else if(str=='delete'){
                  	return confirm('确定要删除该条记录吗？');
                  }
             }
	
	function box1(){
  		  $("#tb tr").click(function (e) {
  		  $(this).toggleClass('selected');
  		  if(e.target.type!="checkbox"){
  		  	$(':checkbox',this).attr('checked',function(){
  		  		return !this.checked;
  		  	});
  		  	if (window.event) {  
				// Chrome,IE6,Opera
				window.event.cancelBubble = true;  
			} else {   
				// FireFox 3
				evt.stopPropagation();  
			}
  		  }
   		 });
 	 	}
             
</script>
</head>
	<body>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/chili-1.7.pack.js"></script>
	<script type="text/javascript" src="js/jquery.easing.js"></script>
	<script type="text/javascript" src="js/jquery.dimensions.js"></script>
	<script type="text/javascript" src="js/jquery.accordion.js"></script>
	<input type="hidden" value="${pageContext.request.contextPath }" id="path"/>
	<s:form action="userAction.action" theme="simple">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr>
       	 <td width="20"><s:submit name="add" value="新增" method="getSystemroleName"/></td>
       	 <td width="20"><s:submit name="check" value="查看" align="left" method="check" onclick="return check('check');"/></td>
       	 <td width="20"><s:submit name="delete" value="删除" align="left" method="delete" onclick="return check('delete');"/></td>
       	 <td width="20"><s:submit name="edit" value="修改" align="left" method="edit" onclick="return check('edit');"/></td>
       	 <td width="50px" height="29" align="center">用户名:</td>
         <td width="200px" ><input name="userNameTop" type="text"/><s:submit value="查询" method ="getUserList"/></td>
       </tr>
    </table>
	<table>
	 <thead>
	   <tr>
	   <td width="50" style="background-color: #d3eaef;">选择</td>
	    <td width="70" height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align: center;background-color: #d3eaef;">序号</td>
	    <td width="200" height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align: center;background-color: #d3eaef;">用户名</td>
	    <td width="400" height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align: center;background-color: #d3eaef;">用户角色</td>
	    <td width="500" height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align: center;background-color: #d3eaef;">所属单位</td>
	    <td width="500" height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align: center;background-color: #d3eaef;">邮箱</td>
	   </tr>
	  </thead>
	  <tbody id="tb">
	  	<c:forEach items="${queryList}" var="temp" varStatus="i">
	  		<tr onMouseOver="this.style.background='#d3eaef'" onMouseOut="this.style.background='#ffffff'" onclick="box1()">	
	  			<td><input type="checkbox" class="checkbox" value="${temp.userId}" name="userId"/></td>
				 <td align="center">${i.count}</td>
				 <td align="center">${temp.userName}</td>
				 <td align="center">${temp.systemrole.roleName}</td>
				 <td align="center">${temp.unit}</td>
				 <td align="center">${temp.email}</td>
			</tr>
	 	</c:forEach>
     </tbody>
	   <tr>
		 <td colspan="8">
		  	<%@include file="/jsp/common/page.jsp"%>
		 </td>
	  </tr>
	</table>
	</s:form>
	</body>
</html>
