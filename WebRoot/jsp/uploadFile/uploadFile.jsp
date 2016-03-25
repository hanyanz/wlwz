<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: yanzi
  Date: 2016/3/9
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <script>
    function fileSelected() {
      var file = document.getElementById('file').files[0];
      if (file) {
        var fileSize = 0;
        if (file.size > 1024 * 1024)
          fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
        else
          fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';

        var fileName = document.getElementById('fileName');
        fileName.value = file.name;
        var fileType =  document.getElementById('fileType');
        fileType.value = file.type;

        document.getElementById('showFileName').innerHTML = 'Name: ' + file.name;
        document.getElementById('showFileSize').innerHTML = 'Size: ' + fileSize;
        document.getElementById('showFileType').innerHTML = 'Type: ' + file.type;

      }
    }

    function checkType(){
      var v=document.getElementById("methodType").value;
      var t=document.getElementById("div1");
      if(v=="数据标准化"){
        t.style.display="";
      }else{
        t.style.display="none";
      }
    }

  </script>
</head>
<body>
<form id="form1" name = "uploadForm" enctype="multipart/form-data" method="post" action="uploadFileAction!dealWithData.action">
  <div class="row">
    <label for="methodType">Select a method to deal with data you upload </label>
    <select name="methodType"  id = "methodType" onchange="checkType()">
      <option  value="归一化">归一化 </option>
      <option value="数据标准化" >数据标准化</option>
      <option value="噪声平滑">噪声平滑</option>
      <option value="不处理"> 不处理</option>
    </select>
  </div>

  <div id="div1"  style="display:none">
    <label for="minValue">input the minValue </label><input type="text" id = "minValue" name = "minValue" >
    <label for="maxValue">input the maxValue</label><input type="text" id = "maxValue" name = "maxValue" >
  </div>

  <div class="row">
    <label for="file">Select a File to Upload</label>
    <input type="file" name="file" id="file" onchange="fileSelected();"/>
  </div>
  <div id = "showFileName">
    <input type="hidden" id ="fileName" name="fileName"/>
  </div>
  <div id = "showFileSize"></div>
 <div id="showFileType">
   <input type="hidden" id ="fileType" name="fileType"/>
 </div>

  <div class="row">
    <input type="submit" value="Upload" />
  </div>
</form>
</body>
</html>