<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>center</title>
        <script type="text/javascript">
        /*function set(){
        	if(document.getElementById("left").style.width=="147px"){
        		document.getElementById("left").style.width="0px";
        		document.getElementById("ima").src="images/menu_right.gif";
        	}else{
        		document.getElementById("left").style.width="147px";
        		document.getElementById("ima").src="images/menu_left.gif";
        	}
        }*/
        </script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow:hidden;
}

#left{
	style:width:147px;
}
-->
</style>
    </head>
    <body>
       <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td width="8" bgcolor="#353c44">&nbsp;</td>
		    <td style="width:217px;" valign="top" id="left">
		    <iframe height="100%" width="100%" frameborder="0" src="userAction!getRightList.action" name="leftFrame" id="leftFrame" title="leftFrame">
		    </iframe>
		    </td>
		   <!--   <td width="4" valign="top"><input type="image" src="images/menu_left.gif" id="ima" onclick="set();"/></td>-->
		    <td width="10" bgcolor="#add2da">&nbsp;</td>
		    <td valign="top">
		    <iframe height="100%" width="100%" frameborder="0" src="firstMain.jsp" name="rightFrame" id="rightFrame" title="rightFrame">
		    </iframe></td>
		    <td width="8" bgcolor="#353c44">&nbsp;</td>
		  </tr>
		</table>
    </body>
</html>
