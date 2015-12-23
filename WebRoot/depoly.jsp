<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html dir="ltr" lang="zh-CN">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width" />
<title>监控参量配置</title>
<meta name="keywords" content="jQuery, 表格, table, 自动增加" />
<meta name="description" content="jQuery表格自动增加" />
<meta name="viewport" content="width=device-width" />
<meta name="author" content="sole" />
<meta name="robots" content="all" />
<meta name="distribution" content="global" />
  <style type="text/css">  
    table{  
        width:auto;  
        border:1px solid #FFF;  
        border-collapse:collapse;  
        }  
    table tr  
            {  
            border:1px #FFF solid;  
            }  
    table tr td  
            {  
            border:1px #FFF solid;  
            }  
    </style>  
   
   <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" language="javascript">  
    $(document).ready(function(){  
        //序列号
        //var len = 1; 
        $("#tijiao").click(function(){  
          //获取上发数据中参量对应的顺序值
           var $number = $("#number").val();
            //获取参量名  
            var $name=$("#name").val();  
            //获取数据类型  
             var $dataType=$("#dataType").val();  
            //获取数据长度
            var $length=$("#length").val(); 
            //获取数据上限
            var $upper =$("#upper").val(); 
             //获取数据下限 
            var $lower =$("#lower").val(); 
      
       //这里可以加一个强制检查上述信息中某些量必填
            
             //获取备注信息
           // var $remark =$("#remark").val();
         //   var $tr=$("<tr><td>"+len+"</td><td>"+$name+"</td><td>"+$dataType+"</td><td>"+$length+"</td><td>"+$upper+"</td><td>"+$lower+"</td><td>"+$remark+"</td><td><a href='javascript:void(0)' class='a'>删除</a></td></tr>");
         var $tr=$("<tr><td>"+$number+"</td><td>"+$name+"</td><td>"+$dataType+"</td><td>"+$length+"</td><td>"+$upper+"</td><td>"+$lower+"</td><td><a href='javascript:void(0)' class='a'>删除</a></td></tr>");    
            //alert($tr);  
            
            $tr.appendTo("#table1");
         
            $(".a").click(function(){  
                $(this).parent().parent().remove();  
              
              
                });  
            });   
               
            
            $("#checkSubmit").click(function(){  
                
	          //   var tableData=new Array();
	             var depolyStr = document.getElementById("depolyStr");
	              depolyStr.value="";//去除了depolyStr中内容有残留的bug
	               $("#table1 tr").each(function(trindex,tritem){
	             //       tableData[trindex]=new Array();
	                $(tritem).find("td").each(function(tdindex,tditem){
	                    if($(tditem).text() != "删除"){
	                  //    tableData[trindex][tdindex]=$(tditem).text();
	                      depolyStr.value += $(tditem).text()+",";
	                    }
	                });
                  });
                 //   alert(tableData);//表格是从第1行第0列开始的*/
                //    alert(depolyStr.value);
                    document.depolyForm.submit();
             });
                          
        });  
        
        
    </script>  
    </head> 
     
    <body>  
    
   <!--  <div style="width:700px; height:300px; background:#999; margin:auto">  --> 
   <div style="width:800px; height:auto; background:#999; margin:auto">
    <p style="margin-left:300px">添加监控量</p>  
    <form>
     <table style ="margin:auto">
     <tr><td>参量序号</td><td><input type="text" id = "number"></td>
         <td>参量名</td><td><input type="text" id = "name"></td>
     </tr>
     <tr><td> 数据类型</td><td><select name="datasType" id="dataType" >
          <option selected>varchar</option> <option>int</option>
          <option>tinyint</option><option>float</option>
          <option>timestamp</option> </select></td>
          <td>数据长度</td><td><input type="text" id = "length"></td>
      </tr>
      <tr><td> 数据上限</td> <td><input type="text" id = "upper"></td>
          <td>  数据下限</td> <td> <input type="text" id = "lower"></td></tr>
        <!--    <td>  备注</td>  <td> <input type="text" id = "remark"></td> -->
    </table>   
    
    <input type="button" id="tijiao" value="添加" align="middle" style="margin-left:300px;">     
    &nbsp;&nbsp;&nbsp;
    <input type="reset" name="Reset" value="重置" >
   </form>
    <hr>  
  
   <form name = "depolyForm" action = "depolyAction!acceptDepolyData.action" method = "post">
  <!--  --> 
         
     <input type="hidden" id ="depolyStr" name="depolyStr"/> 
    </form> 
   <table align="center"  border="1" id="table1">  
      <thead>
        <tr><th>参量序号 </th><th>参量名</th><th>数据类型</th><th>数据长度</th><th>数值上限</th><th>数值下限</th></tr> 
      </thead>   
    </table>   
       <input type="button"  id = "checkSubmit" name="Submit" value="提交" >
       
   
  <hr> 
  
      <td height="50" colspan="4"><div align="center">
          <textarea name="textarea" cols="80" rows="10" wrap="VIRTUAL">  本网站为远程数据监控配置之用，作如下补充和说明

一、不得利用本站危害国家安全、泄露国家秘密，不得侵犯国家社会集体的和公民的合法权益；

二、对本页面的使用说明如下：
（一） 参量添加时，以上发的数据协议顺序填写，即先添加处于帧头的参量信息；
（二） 参量名是您希望在监控页面上显示的物理量信息，支持中文或者字母数字等各种表示；
（三）提交前请确定您添加的参量信息及各参量之间的顺序无误，确认后将无法修改。
（四）请确保参量信息表中，您添加的参量序号是由1开始的连续编号。

三、感谢您使用本远程监控系统,如有疑问，请联系：028-xxxxxxxx </textarea>
      </td>
    
    <tr>
      <td colspan="4"><div align="center"><strong>点击”提交“按钮即表示已确认信息无误，提交后将不能修改</strong></div></td>
    </tr>
  
   
   </body>
   </html>
   