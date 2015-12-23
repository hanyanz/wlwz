<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta name="keywords" content="JS代码,菜单导航,JS广告代码,JS特效代码" />
<meta name="description" content="此代码内容为可折叠展开的导航菜单，属于站长常用代码，更多菜单导航代码请访问懒人图库JS代码频道。" />
<title>可折叠展开的导航菜单_懒人图库</title>
	<link rel="stylesheet" type="text/css" href="sdmenu/sdmenu.css" />
	<script type="text/javascript" src="sdmenu/sdmenu.js">
		/***********************************************
		* Slashdot Menu script- By DimX
		* Submitted to Dynamic Drive DHTML code library: http://www.dynamicdrive.com
		* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
		***********************************************/
	</script>
	<script type="text/javascript">
	// <![CDATA[
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
	// ]]>
	</script>
  </head>
  <body>
    <form action="#" style="font-family: sans-serif; font-size: .8em" onsubmit="return false">
      <fieldset><legend>Menu actions</legend>
        <label for="speed">Speed (1-5):</label>
        <input type="text" id="speed" value="3" size="1" onchange="myMenu.speed = parseInt(this.value)" />
        &nbsp;&nbsp;&nbsp;
        <label for="oneSmOnly">One submenu at a time:</label>
        <select id="oneSmOnly" onchange="myMenu.oneSmOnly = this.selectedIndex"><option>false</option><option>true</option></select>
        &nbsp;&nbsp;&nbsp;
        <select name="smNr"><option>1</option><option>2</option><option>3</option><option>4</option></select>
        <input type="button" value="Expand" onclick="myMenu.expandMenu(myMenu.submenus[smNr.selectedIndex])" />
        <input type="button" value="Collapse" onclick="myMenu.collapseMenu(myMenu.submenus[smNr.selectedIndex])" />
        <input type="button" value="Toggle" onclick="myMenu.toggleMenu(myMenu.submenus[smNr.selectedIndex])" />
        &nbsp;&nbsp;&nbsp;
        <input type="button" value="Expand all" onclick="myMenu.expandAll()" />
        <input type="button" value="Collapse all" onclick="myMenu.collapseAll()" />
      </fieldset>
    </form>

    <div style="float: left" id="my_menu" class="sdmenu">
      <div>
        <span><a href="midteamAction!getList.action" >tezhuangbu</a></span>
        
	      <c:forEach items="${mList}" var="m">
	       <li><a href="#">${m.midteamName }</a></li>
	      </c:forEach>
	     
       <!--   <a href="http://tools.dynamicdrive.com/imageoptimizer/">Image Optimizer</a>
        <a href="http://tools.dynamicdrive.com/favicon/">FavIcon Generator</a>
        <a href="http://www.dynamicdrive.com/emailriddler/">Email Riddler</a>
        <a href="http://tools.dynamicdrive.com/password/">htaccess Password</a>
        <a href="http://tools.dynamicdrive.com/gradient/">Gradient Image</a>
        <a href="http://tools.dynamicdrive.com/button/">Button Maker</a>-->
      </div>
      <div>
        <span>Support Us</span>
        <a href="http://www.dynamicdrive.com/recommendit/">Recommend Us</a>
        <a href="http://www.dynamicdrive.com/link.htm">Link to Us</a>
        <a href="http://www.dynamicdrive.com/resources/">Web Resources</a>
      </div>
      <div class="collapsed">
        <span>Partners</span>
        <a href="http://www.javascriptkit.com">JavaScript Kit</a>
        <a href="http://www.cssdrive.com">CSS Drive</a>
        <a href="http://www.codingforums.com">CodingForums</a>
        <a href="http://www.dynamicdrive.com/style/">CSS Examples</a>
      </div>
      <div>
        <span>Test Current</span>
        <a href="?foo=bar">Current or not</a>
        <a href="./">Current or not</a>
        <a href="index.html">Current or not</a>
        <a href="index.html?query">Current or not</a>
      </div>
    </div>
  </body>
</html>