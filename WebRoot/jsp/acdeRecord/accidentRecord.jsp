<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <%@ page language="java" contentType="text/html;charset=UTF-8"%>
    <%@ page import="com.opensymphony.xwork2.util.*"%>  
    <head>
<style type="text/css">
	.inButtonColor {
 background-color: #00ff8e;
 width:67px;
 height:32px;
}
</style>
<title>事故列表</title>
<script language="JavaScript" type="text/JavaScript">
   function add(){
       window.open('jsp/acdeRecord/accidentRecordAdd.jsp','新增',
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
  	//	  $(this).toggleClass('selected');
  		  if(e.target.type!="checkbox"){
  		  	$(':checkbox',this).attr('checked',function(){
  		  		return !this.checked;
  		  	});
  		  	if (window.event) {
				// Chrome,IE6,Opera
				window.event.cancelBubble = true;
			} else {
				// FireFox 3
				e.stopPropagation();
			}
  		  }
   		 });
 	 	}
     
</script>
</head>
	<body>
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="js/chili-1.7.pack.js"></script>
	<script type="text/javascript" src="js/jquery.easing.js"></script>
	<script type="text/javascript" src="js/jquery.dimensions.js"></script>
	<script type="text/javascript" src="js/jquery.accordion.js"></script>
	<input type="hidden" value="${pageContext.request.contextPath }" id="path"/>
	<s:form action="accidentrecordAction.action" theme="simple">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr>
       	 <td width="20"><input type="button" value="新增" onclick="add()"/></td>
       	 <td width="20"><s:submit name="check" value="查看" align="left" method="check" onclick="return check('check');"/></td>
       	 <td width="20"><s:submit name="delete" value="删除" align="left" method="delRecord" onclick="return check('delete');"/></td>
       	 <td width="20"><s:submit name="edit" value="修改" align="left" method="edit" onclick="return check('edit');"/></td>
       	 <td width="50px" height="29" align="center">设备编号:</td>
         <td width="200px" ><input name="deviceNumber" type="text"/><s:submit value="查询" method ="getAccidentList"/></td>
       </tr>
    </table>
	<table>
	 <thead>
	   <tr>
	   <td style="background-color: #d3eaef;">选择</td>
	    <td width="40" height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align: center;background-color: #d3eaef;">序号</td>
	    <td width="100" height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align: center;background-color: #d3eaef;">设备编码</td>
	    <td width="200" height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align: center;background-color: #d3eaef;">事故单位</td>
	    <td width="100" height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align: center;background-color: #d3eaef;">事故类型</td>
	   </tr>
	  </thead>
	  <tbody  id="tb">
	  
	  	<tr onMouseOver="this.style.background='#d3eaef'" onMouseOut="this.style.background='#ffffff'" onclick="box1()">
	  		<td><input type="checkbox" class="checkbox"/></td>
	  		<td>111</td>
	  		<td>111</td>
	  		<td>111</td>
	  		<td>111</td>
	  	</tr>
	  	<tr onMouseOver="this.style.background='#d3eaef'" onMouseOut="this.style.background='#ffffff'" onclick="box1()">
	  		<td><input type="checkbox" class="checkbox"/></td>
	  		<td></td>
	  		<td></td>
	  		<td></td>
	  		<td></td>
	  	</tr>
	  
	  <!--  	<c:forEach items="${queryList}" var="temp" varStatus="i">
	  	<label for="c"></label>
	  		<tr id="c" onMouseOver="this.style.background='#d3eaef'" onMouseOut="this.style.background='#ffffff'" onclick="box1()">
	  			<td><input type="checkbox" class="checkbox" value="${temp.accidentRecordId}" name="accidentRecordId"/></td>
				 <td align="center">${i.count}</td>
				 <td align="center">${temp.device.deviceNumber}</td>
				 <td align="center">${temp.accidentUint }</td>
				 <td align="center">${temp.accidentType }</td>
			</tr>
			
	 	</c:forEach>-->
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
