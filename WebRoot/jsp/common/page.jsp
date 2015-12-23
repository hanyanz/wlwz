<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>    

<%@ taglib prefix="s" uri="/struts-tags"%>    
<style type="text/css">
<!--
a{text-decoration:underline;}
a:active{color:#00f;}
a:visited{color:#00f;}
-->
</style>
<SCRIPT type="text/javascript">
function trim(str){
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
function selectPage(input){
	var value = trim(input.value);
	if(value == ""){
		return;
	}
	if(/\d+/.test(value)){
		input.form.submit();
		return;
	}
	alert("请输入正确的页数");
	input.focus();
}
</SCRIPT>    
<div class="pagech">    

<s:if test="#session.totalPage != 0">
	
	<s:url action="%{#session.url}" id="first">
		<s:param name="currentPage" value="1"></s:param>
	</s:url>
	<s:url action="%{#session.url}" id="next" >
		<s:param name="currentPage" value="#session.currentPage+1"></s:param>
	</s:url>
	<s:url action="%{#session.url}" id="prior" >
		<s:param name="currentPage" value="#session.currentPage-1"></s:param>
	</s:url>
	<s:url action="%{#session.url}" id="last">
		<s:param name="currentPage" value="#session.totalPage"></s:param>
	</s:url>
	<s:url action="%{#session.url}" id="cur">
		<s:param name="currentPage" value="#session.currentPage"></s:param>
	</s:url>

	<!--  #session.currentPage-->
	<s:if test="#session.currentPage==1">
		<span class="current">首页</span>
		<span class="current">上一页</span>
	</s:if>
	
	<s:else>
		<s:a href="%{first}">首页</s:a>
		<s:a href="%{prior}">上一页</s:a>&nbsp;&nbsp;
	</s:else>    
	<s:if    test="#session.currentPage == #session.totalPage || #session.totalPage == 0">    
		<span class="current">下一页</span>
		<span class="current">末页</span>
	</s:if>
	<s:else>
		<s:a href="%{next}">下一页</s:a>&nbsp;
		<s:a href="%{last}">末页</s:a>
	</s:else>
		<s:a href="%{cur}">刷新</s:a>
	<span class="jumplabel">跳转到</span>
	<s:form action="#session.url" theme="simple" cssStyle="display:inline">
		<s:hidden name="totalPage" value="#session.totalPage"></s:hidden>
		<input type="text" name="currentPage" size="2" onblur="selectPage(this)" />
	</s:form>
	<span class="jumplabel">页</span>
	
	<span class="jumplabel">共${totalRecord }条</span>
	<span class="jumplabel">当前是第${currentPage }/${totalPage}页</span>
</s:if>
</div> 
