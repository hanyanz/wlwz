//前台验证初始化
$(document).ready(function () {
	//判断页面是否需要验证
	//如查产生异常则表明没有找到对应的表单则不加载验证文件
	try {
		var formId = document.replyform.id;
		$("#" + formId).validate({});
	}
	catch (Exception) {
	}
});

