<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <%@ page language="java" contentType="text/html;charset=UTF-8"%>
    <head>

<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
  <link rel="stylesheet" type="text/css" href="css/main.css" />
  <link href="js/SpryAccordion.css" rel="stylesheet" type="text/css" />
  <script language="javascript">
     $(document).ready(function(){
     $(".menus a").click(function(){
      var aParent = $(this).parent();
      aParent.next().slideToggle('fast').siblings('.content').slideUp('hide');
     });
    });
   </script>
<title>目录列表</title>
</head>
	<body>
	<div class="table-left">
	<div id="Accordion1" class="Accordion">
		
	    <div class="AccordionPanel">
	    <div class="menus">
     		<a href="#">数据统计</a>
    	</div>
	    <div class="content">
	     <ul>
	      <li><a href="runningdataAction!loadRunningdataList.action" target="rightFrame">监测数据历史记录</a></li>
	      <li><a href="accidentrecordAction!getAccidentList.action" target="rightFrame">事故记录</a></li>
	      <li><a href="maintenancerecordAction!getMaintenanceList.action" target="rightFrame">保修记录</a></li>
	      <li><a href="handoverrecordAction!getHandoverrecordList.action" target="rightFrame">交接记录</a></li>
	     </ul>
	    </div>
	    </div>
	    
	     <div class="AccordionPanel">
	    <div class="menus">
     		<a href="#">视频监控</a>
    	</div>
	    <div class="content">
	     <ul>
	      <li><a href="videoAction!getVideoinfoList.action" target="rightFrame"> 视频列表</a></li>
	     </ul>
	    </div>
	    </div>
	    
	    <div class="AccordionPanel">
		<div class="menus">
     		<a href="#">系统维护</a>
    	</div>
		<div class="content">
	     <ul>
		 <li><a href="systemroleAction!getSystemroleList.action" target="rightFrame">角色记录</a></li>
		 <li><a href="userAction!getUserList.action" target="rightFrame">用户记录</a></li>
		 </ul>
	    </div>
	    </div>
	    
	    <div class="AccordionPanel">
		<div class="menus">
     		<a href="#">机构登记</a>
    	</div>
		<div class="content">
	     <ul>	     
		 <li><a href="projectAction!loadProjectList.action" target="rightFrame">项目登记</a></li>
		  <li><a href="unitAction!loadUnitList.action" target="rightFrame">单位登记</a></li>
		 <li><a href="deviceAction!getDeviceList.action" target="rightFrame">设备登记</a></li>		
		 </ul>
	    </div>
	     </div>
	     <div class="AccordionPanel">
		<div class="menus">
		<a href="#">统计报表</a></div>
		<div class="content">
	     <ul>
		 <li><a href="html/danji.html" target="rightFrame">设备维修报销明细表</a></li>
		 <li><a href="html/gongdi.html" target="rightFrame">工地设备维修周报表</a></li>
		 <li><a href="html/xiulichang.html" target="rightFrame">修理厂月报完成表</a></li>
		 <li><a href="html/shebei.html" target="rightFrame">设备信息</a></li>
		 </ul>
	    </div>
	     </div>
	     <div class="AccordionPanel">
		<div class="menus"><a href="#">数据字典</a></div>
	     </div>
	 
	</div>
	</div>
	
	</body>
</html>
