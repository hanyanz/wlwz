
/**
 * 打开新窗口
 * 
 * @param page
 * @return
 */
function addwindow(page,width,height){
	if(page!=null&&page!=""){
		if(null==width||width==""){
			var iWidth=700;                          // 弹出窗口的宽度;
		}
		else{
			var iWidth= width;
		}
		if(null==height||height==""){
			var iHeight=500;      
		}
		else{
			var iHeight=height;
		}// 弹出窗口的高度;
		//var iTop = (window.screen.availHeight-30-iHeight)/2;       // 获得窗口的垂直位置;
		//var iLeft = (window.screen.availWidth-10-iWidth)/2;        // 获得窗口的水平位置;
		//alert(page);
		window.showModalDialog(page,"addapp","dialogWidth:" + iWidth + "px;dialogHeight:" + iHeight +"px;help:0;status:0;scroll:1;resizable:1;center:1;dialogHide:1");
	}
}

function addopen(page,width,height){
	if(page!=null&&page!=""){
		if(null==width||width==""){
			var iWidth=700;                          // 弹出窗口的宽度;
		}
		else{
			var iWidth= width;
		}
		if(null==height||height==""){
			var iHeight=500;      
		}
		else{
			var iHeight=height;
		}// 弹出窗口的高度; 
	var iTop = (window.screen.availHeight-30-iHeight)/2;       // 获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-iWidth)/2;        // 获得窗口的水平位置;
	window.open(page,"addapp",'height='+iHeight+',,innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
	}
}
/*打印指定的iframe里的内容，
使用方法例:<input type="button" value="打印" onclick="pagePrint(this)" id="pt" printFrameName="data" style="float: right;"/>
<iframe frameborder="0" name="data" id="search-iframe" width="100%" height="100%" scrolling="auto" src="${pageContext.request.contextPath}/pages/zs/InfoGcConstructing!getContructingInfo.action"></iframe>
*/
function pagePrint(obj) {
	var id=obj.id;
	var frameName = $("#"+id).attr("printFrameName"); //获取要打印的iframe name名字
	frameName=eval(frameName); //将iframe的名字转为对象
	if(-[1,]) {
		//除IE外的浏览器
		frameName.print();
	}else {
		//IE浏览器
		frameName.focus();
		window.print();
	}
}
