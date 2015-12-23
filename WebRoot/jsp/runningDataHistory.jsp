<%@ page language="java" import="java.util.*,java.io.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <%@ page language="java" contentType="text/html;charset=UTF-8"%>
    <%@ page import="com.opensymphony.xwork2.util.*"%>  
    <head>
<style type="text/css">
<!--
body {
	margin:0px;
	padding:0px;
	font-size: 12px;
}

#navigation {
	margin:0px;
	padding:0px;
	width:147px;
}
#navigation a.head {
	cursor:pointer;
	background:url(images/main_34.gif) no-repeat scroll;
	display:block;
	font-weight:bold;
	margin:0px;
	padding:5px 0 5px;
	text-align:center;
	font-size:12px;
	text-decoration:none;
}
#navigation ul {
	border-width:0px;
	margin:0px;
	padding:0px;
	text-indent:0px;
}
#navigation li {
	list-style:none; display:inline;
}
#navigation li li a {
	display:block;
	font-size:12px;
	text-decoration: none;
	text-align:center;
	padding:3px;
}
#navigation li li a:hover {
	background:url(images/tab_bg.gif) repeat-x;
		border:solid 1px #adb9c2;
}
-->
</style>

		<%
			Integer userGroup = (Integer) session.getAttribute("userGroup");

			Properties pro = new Properties();

			try{
				//读取配置文件
				FileInputStream in = new FileInputStream("D:/test/wlwz_"+ userGroup+".properties");
				System.out.print(in);
				pro.load(in);
			}
			catch(FileNotFoundException e){
				out.println(e);
			}
			catch(IOException e){out.println(e);}

			//通过key获取配置文件
			int depolyNum = Integer.valueOf(pro.getProperty("depolyNum"));
			String[] depolys = new String[depolyNum];
			for(int i = 0; i < depolyNum; i++){
				depolys[i] = pro.getProperty("depolyName_"+(i+1));
			}
		%>

<title>运行数据</title>
</head>
	<body>
	
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/chili-1.7.pack.js"></script>
	<script type="text/javascript" src="js/jquery.easing.js"></script>
	<script type="text/javascript" src="js/jquery.dimensions.js"></script>
	<script type="text/javascript" src="js/jquery.accordion.js"></script>
	<input type="hidden" value="${pageContext.request.contextPath }" id="path"/>
	<form action="runningdataAction!loadRunningdataList.action" method="post">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr>
         <td width="50px" height="29" align="center">设备编号</td>
         <td width="200px" ><input name="deviceId" type="text"/>
         <input type="submit" value="查询"/></td>
       </tr>
    </table>
    </form>
	<table>
	 <thead>
	   <tr>
           <td width=auto height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align: center;background-color: #d3eaef;">序列号</td>
	    <td width=auto height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align: center;background-color: #d3eaef;">设备编号</td>
	    <td width=auto height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align: center;background-color: #d3eaef;">时间</td>
		<c:forEach items='<%=depolys%>' var = "temp">
			<td width=auto height="20" bgcolor="#FFFFFF" class="STYLE19" style="text-align: center;background-color: #d3eaef;">${temp}</td>
		</c:forEach>

	   </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${queryList}" var="temp" varStatus="i">
	  		<tr onMouseOver="this.style.background='#d3eaef'" onMouseOut="this.style.background='#ffffff'">	
				 <td align="center">${i.count}</td>
				 <td align="center">${temp[1]}</td>
				 <td align="center">${temp[2]}</td>
				<c:forEach items='<%=depolys%>' varStatus="j">
					 <td align="center">${temp[j.count+2]}</td>
				</c:forEach>
			</tr>
	 	</c:forEach>
     </tbody>
	   <tr>
		 <td colspan="8">
		  	<%@include file="/jsp/common/page.jsp"%>
		 </td>
	  </tr>
	</table>
	
	</body>
</html>
