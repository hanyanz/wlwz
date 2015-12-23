<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
  <!-- 这是设置基础路径的,basepath为变量,简单的静态网页的话你设置比如:<base href="http://www.baidu.com">,那你下面的href属性就会以你上面设的为基准,
                        如:<a href="http://www.baidu.com/xxx.htm"></a>你现在就只需要写<a href="xxx.htm"></a> -->
    <!-- <base href="%=basePath%>"> 这里路径为 项目所在位置D:/.../wlwz  -->
    
    <title>用户注册界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language="javascript">
<!--
 function selectCity(){
  if(RegInfoPost.state.value=="上海"){
   RegInfoPost.city.value="上海";
  }
  else if(RegInfoPost.state.value=="天津"){
   RegInfoPost.city.value="天津";
  }
  else if(RegInfoPost.state.value=="北京"){
   RegInfoPost.city.value="北京";
  }
  else if(RegInfoPost.state.value=="重庆"){
   RegInfoPost.city.value="重庆";
  }
  else if(RegInfoPost.state.value=="中国香港"){
   RegInfoPost.city.value="中国香港";
  }
  else if(RegInfoPost.state.value=="中国澳门"){
   RegInfoPost.city.value="中国澳门";
  }
  else{
   RegInfoPost.city.value="";
  }
 }

 function checkCity(){
  if(RegInfoPost.city.value=="北京"){
   RegInfoPost.address.focus();
  }
  if(RegInfoPost.city.value=="上海"){
   RegInfoPost.address.focus();
  }
  if(RegInfoPost.city.value=="天津"){
   RegInfoPost.address.focus();
  }
  if(RegInfoPost.city.value=="重庆"){
   RegInfoPost.address.focus();
  }
  if(RegInfoPost.city.value=="中国香港"){
   RegInfoPost.address.focus();
  }
  if(RegInfoPost.city.value=="中国澳门"){
   RegInfoPost.address.focus();
  }
 }
 

 
-->
</script>
<script language="javascript">
  <!--
   function onSubmit(){
  <%//检查姓名%>
  if(RegInfoPost.realName.value==""){
   alert("请填写姓名！");
   RegInfoPost.realName.focus();
   return false;
  }
  <%//检查手机号码%>
  else if(RegInfoPost.mobilephone.value==""){
   alert("请填写手机号码！");
   RegInfoPost.mobilephone.focus();
   return false;
  }
  <%//检查手机号码的格式是否合法%> 
  else if(chkid(RegInfoPost.mobilephone.value)==0){
   alert("您填写的手机号码格式不正确！");
   RegInfoPost.mobilephone.focus();
   return false;
  }
  <%//检查单位名称%>
  else if(RegInfoPost.unit.value==""){
   alert("请填写单位名称！");
   RegInfoPost.unit.focus();
   return false;
  }
  <%//检查省市自治区%>
  else if(RegInfoPost.state.value=="default"){
   alert("请选择省市自治区！");
   RegInfoPost.state.focus();
   return false;
  }
  <%//检查城市%>
  else if(RegInfoPost.city.value==""){
   alert("请填写城市！");
   RegInfoPost.city.focus();
   return false;
  }
  <%//检查地址%>
  else if(RegInfoPost.address.value==""){
   alert("请填写地址！");
   RegInfoPost.address.focus();
   return false;
  }
  
  <%//检查电子邮件%>
  else if(RegInfoPost.email.value==""){
   alert("请填写您的电子邮件地址！");
   RegInfoPost.email.focus();
   return false;
  }
  <%//检查电子邮件是否合法%>
  else if(chkemail(RegInfoPost.email.value)!=1){
   alert("电子邮件地址不符合格式！");
   RegInfoPost.email.focus();
   return false;
  }
  <%//检查用于确认的电子邮件地址%>
  else if(RegInfoPost.email.value!=RegInfoPost.email2.value){
   alert("请确认您的电子邮件填写的准确无误！");
   RegInfoPost.email2.focus();
   return false;
  }
  else{
         var area = document.getElementById("area");
         var country = document.getElementById("country");
         var state = document.getElementById("state");
         var city = document.getElementById("city");
         var address = document.getElementById("address");
	        area.value="";//去除了area中内容有残留的bug
	        area.value = country.value+state.value+city.value+address.value;
         document.RegInfoPost.submit();
  }
 }

 <%
 //函数名：chkspc
 //功能介绍：检查是否含有空格
 //参数说明：要检查的字符串
 //返回值：0：有空格  1：没有空格  2：有空格
 %>
 function chkspc(a){
   var i=a.length;
   var j = 0;
   var k = 0;
   while(k<i){
     if(a.charAt(k)!=" "){
                         j = j+1;
     }
                        k = k+1;
   }
                if(j==0){
                 return 0;
                }
                if(i!=j){
                 return 2;
                }
                else{
                 return 1;
                }
 }

 <%
 //函数名：checkNum
 //功能介绍：检查是否为数字
 //参数说明：要检查的数字
 //返回值：0：不是数字  1：是数字
 %>
 function checkNum(num){
   var i,j,strTemp;
   strTemp="0123456789";
   if(num.length==0)
     return 0;
   for(i=0;i<num.length;i++){
     j=strTemp.indexOf(num.charAt(i));
     if (j==-1){
       return 0;
     }
   }
   return 1;
 }

 <%
 //函数名：chkid
 //功能介绍：检查身份证
 //参数说明：要检查的字符串
 //返回值：0：不合格  1：合格
 %>
 function chkid(id){
  if(id.length!=11 ){
   return 0;
  }
  else if(chkspc(id)!=1){
   return 0;
  }
  else if(checkNum(id)==0){
   return 0;
  }
  else
   return 1;
 }

 <%
 //检查电子邮件是否合法
 //函数名：chkemail
 //参数说明：要检查的字符串
 //返回值：1：是
 %>
 function chkemail(a){
  var i=a.length;
   var temp = a.indexOf('@');
   var tempd = a.indexOf('.');
   if(temp > 1) {
     if((i-temp) > 3){
                         if((i-tempd)>0){
                                 return 1;
                                }
     }
   }
 }
-->
  </script>
  <script language="javascript">
 var xmlHttp;
 function createXMLHttpRequest(){
  if(window.ActiveXObject){
   xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  }else if(window.XMLHttpRequest){
   xmlHttp = new XMLHttpRequest();
  }
 }
 
 function startRequest(){
  createXMLHttpRequest();
  xmlHttp.onreadystatechange = handleStateChange;
  var uname = document.getElementById("userName").value;
  xmlHttp.open("POST","RegAjax?name="+uname,true);
  xmlHttp.send(null);
 }
 
 function handleStateChange(){
  if(xmlHttp.readyState==4){
   if(xmlHttp.status==200){
    if("t"==(xmlHttp.responseText))
     alert("用户名已被占用");
   }
  }
 }
 
 function checkPwd(){
   var password = document.getElementById("password");
   var password2 = document.getElementById("password2");
   if(password.value != password2.value){
       alert("两次输入的密码不一致，请重新输入");
       RegInfoPost.password2.value = "";
       RegInfoPost.password2.focus();
   }
 }
 
  </script>
  </head>
  
  <body>
   
    <form name="RegInfoPost" action="registerAction!register.action" method="post" >
    <table width="auto" height="617" border="0" align="center">
  
   <tr>
      <td colspan="4"><hr color="#cccccc" noshade="yes" size="1"></td>
    </tr>

    <tr>
      <td colspan="4"><hr color="#cccccc" noshade="yes" size="1"></td>
    </tr>
    
    <tr>
	      <td  colspan="1"> </td>
	      <td colspan="2"><strong>用户帐号：</strong>  <input name="userName" type="text" class="item_table" id="userName" maxlength="16" OnBlur="startRequest()">
		       <span class="error">*（6-16个字符） </span>   </td>
	     <td > </td>
    </tr>
    <tr>
      <td colspan="1"> </td>
      <td colspan="2"><strong>用户密码：</strong>        <input name="password" type="password" class="item_table" id="password" maxlength="16">
        <span class="error">*（6-16个字符） </span>      </td>
     <td> </td>
    </tr>
    <tr>
      <td colspan="1"> </td>
      <td colspan="2"> <strong>确认密码：</strong>        <input name="password2" type="password" class="item_table" id="password2" maxlength="16" OnBlur="checkPwd()">
        <span class="error">*（请确认密码）</span>      </td>
      <td> </td>
    </tr>
    <tr align="center" valign="middle">
      <td height="30" colspan="4" valign="middle"><hr color="#cccccc" noshade="yes" size="1"></td>
    </tr>
    
    
   <tr>
      <td  colspan="2" valign="top"><strong>姓名</strong><font color="#ff0000"><span class="error">*</span></td>
      <td colspan="2" valign="top"><strong>单位名称</strong><font color="#ff0000"><span class="error">*</span></td>
    </tr>
    <tr>
      <td height="18" colspan="2" valign="top">
        <input name="realName" type="text" id="realname">      </td>
    <td colspan="2" valign="top"><input name="unit" type="text" id="unit" size="18" maxlength="18"></td>
    </tr>
    <tr>
      <td colspan="2"><strong>手机电话</strong><font color="#ff0000"><span class="error">*</span></td>
       <td colspan="2">办公室电话<font color="#ff0000"></td>
    </tr>
    <tr>
       <td colspan="2"> <input name="mobilephone" type="text" id="mobilephone"></td>
       <td colspan="2"><input name="telephone" type="text" id="telephone"></td>
    </tr>
    <tr>
       <td><input name="area" type="hidden" id ="area"></td>
    </tr>
    <tr>
      <td colspan="1"><strong>国家或地区</strong><font color="#ff0000"><span class="error">*</span></td>
      <td colspan="1"><br></td><td><strong>省市自治区</strong><font color="#ff0000"><span class="error">*</span></td>
      <td colspan="2"><strong>城市</strong><font color="#ff0000"><span class="error">*</span></td>  
     
    </tr>
    <tr>
      <td colspan="1">
        <select name="country" id="country">
          <option selected>中国</option>
          <option>中国香港</option>
          <option>中国澳门</option>
          <option>中国台湾</option>
        </select>
      </td>
    
      <td colspan="1"><br></td><td>
        <select name="state" id="state" onclick="selectCity()">
          <option value="default" selected name="value" isCity="false">选择省市自治区</option>
       <option name="value" value="北京" isCity="true">北京</option>
       <option name="value" value="上海" isCity="true">上海</option>
       <option name="value" value="天津" isCity="true">天津</option>
       <option name="value" value="重庆" isCity="true">重庆</option>
       <option name="value" value="安徽省" isCity="false">安徽省</option>
       <option name="value" value="福建省" isCity="false">福建省</option>
       <option name="value" value="甘肃省" isCity="false">甘肃省</option>
       <option name="value" value="广东省" isCity="false">广东省</option>
       <option name="value" value="广西壮族自治区" isCity="false">广西壮族自治区</option>
       <option name="value" value="贵州省" isCity="false">贵州省</option>
       <option name="value" value="海南省" isCity="false">海南省</option>
       <option name="value" value="河北省" isCity="false">河北省</option>
       <option name="value" value="河南省" isCity="false">河南省</option>
       <option name="value" value="黑龙江省" isCity="false">黑龙江省</option>
       <option name="value" value="湖北省" isCity="false">湖北省</option>
       <option name="value" value="湖南省" isCity="false">湖南省</option>
       <option name="value" value="吉林省" isCity="false">吉林省</option>
       <option name="value" value="江苏省" isCity="false">江苏省</option>
       <option name="value" value="江西省" isCity="false">江西省</option>
       <option name="value" value="辽宁省" isCity="false">辽宁省</option>
       <option name="value" value="内蒙古自治区" isCity="false">内蒙古自治区</option>
       <option name="value" value="宁夏回族自治区" isCity="false">宁夏回族自治区</option>
       <option name="value" value="青海省" isCity="false">青海省</option>
       <option name="value" value="山东省" isCity="false">山东省</option>
       <option name="value" value="山西省" isCity="false">山西省</option>
       <option name="value" value="陕西省" isCity="false">陕西省</option>
       <option name="value" value="四川省" isCity="false">四川省</option>
       <option name="value" value="台湾省" isCity="false">台湾省</option>
       <option name="value" value="西藏自治区" isCity="false">西藏自治区</option>
       <option name="value" value="新疆维吾尔自治区" isCity="false">新疆维吾尔自治区</option>
       <option name="value" value="云南省" isCity="false">云南省</option>
       <option name="value" value="浙江省" isCity="false">浙江省</option>
       <option name="value" value="中国香港" isCity="true">中国香港</option>
       <option name="value" value="中国澳门" isCity="true">中国澳门</option>
     </select>
      </td>
      <td colspan="1">
        <input name="city" type="text" id="city" onfocus="checkCity()">
      </td>
    </tr>
    <tr>
      <td colspan="4"><strong>详细地址</strong><font color="#ff0000"><span class="error">*</span></td>
    </tr>
    <tr>
      <td colspan="4"><input name="address" type="text" id="address" size="41"></td>
    </tr>
    
    <tr>
      <td colspan="4"><hr color="#cccccc" noshade="yes" size="1"></td>
    </tr>
    <tr>
      <td colspan="4"><span class="error">请填写真实有效的电子邮件地址</span></td>
    </tr>
    <tr>
      <td colspan="4"><strong>电子邮件地址<font color="#ff0000"></strong><span class="error">*</span></td>
    </tr>
    <tr>
      <td colspan="4">
      <input name="email" type="text" id="email" size="40">      </td>
    </tr>
    <tr>
      <td colspan="4"> <span class="style2">范例：</span><span class="style3"> myname@hotmail.com</span></td>
    </tr>
   
    <tr>
      <td colspan="4"> <strong>请再一次输入您的电子邮件地址</strong><font color="#ff0000"><span class="error">*</span></td>
    </tr>
    <tr>
      <td colspan="4">
      <input name="email2" type="text" id="email2" size="40">      </td>
    </tr>
    <tr>
      <td colspan="4"><hr color="#cccccc" noshade="yes" size="1"></td>
    </tr>
    <tr>
      <td colspan="4"> </td>
    </tr>
    <tr>
      <td> </td><td colspan="2"valign="top"><div align="center"><strong>接受用户协议</strong></div></td>
      <td> </td>
    </tr>
    <tr>
      <td height="87" colspan="4"><div align="center">
          <textarea name="textarea" cols="70" rows="15" wrap="VIRTUAL">  本网站仅为远程设备信息监控之用，使用前请阅读以下网站使用说明
          

一、互相尊重，对自己的言论和行为负责；   

二、不得利用本站危害国家安全、泄露国家秘密，不得侵犯国家社会集体的和公民的合法权益；

三、网站使用流程为：用户注册-->费用支付-->监控数据配置-->远程监控，本页面为用户注册页面，注册成功则自动跳转到下一界面，否则注册失败，请填写完整用户信息，重新注册；
 
 四、如您在使用过程中遇到困难，请联系 028-xxxxxxx或者 139xxxxxxxx。    </textarea>
      </div></td>
    </tr>
    <tr>
      <td colspan="4"><div align="center"><strong>点击”注册“按钮前，请确认您已阅读以上说明。</strong></div></td>
    </tr>
    <tr>
      <td colspan="4"><hr color="#cccccc" noshade="yes" size="1"></td>
    </tr>
    <tr>
      <td colspan="4"><div align="center">
          <input type="submit" name="Submit" value="注册" onClick="return onSubmit()">
          &nbsp;&nbsp;&nbsp;
          <input type="reset" name="Reset" value="重置">
      </div></td>
    </tr>
    <tr>
      <td height="46" colspan="5"> </td>
    </tr>
    
    </table>
    
   </form>
     <% %>
  </body>
</html>
