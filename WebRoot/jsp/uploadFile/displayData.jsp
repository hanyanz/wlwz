<%--
  Created by IntelliJ IDEA.
  User: yanzi
  Date: 2016/3/9
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
  <title>Highcharts Example</title>

  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.min.js"></script>
  <script type="text/javascript">

    var chart;

    var yResult = JSON.stringify(${yResult});

    $(document).ready(function() {
      chart = new Highcharts.Chart({
        chart : {
          renderTo : 'container',
          type : 'spline'
        },
        title : {
          text : '数据处理结果'
        },
        xAxis : {
          label:{
            step:1
          },
          title : {
            text : 'x轴'
          }
        },
        yAxis : {
          title : {
            text : 'y轴'
          },
          plotLines: [{
            value: 0,
            width: 1,
            color: '#808080'
          }]
        },
        legend: {
          layout: 'vertical',
          align: 'left',//设置说明文字的文字 left/right/top/
          verticalAlign: 'top',
          x: -10,
          y: 100,
          borderWidth: 0
        },
        tooltip : {
          formatter : function() {
            return '' + this.series.name + ': ' + this.y + '';
          }
        },
        credits : {
          enabled: false
        },

        series : eval(  yResult  )
      });
    });

  </script>
</head>
<body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/highcharts/highcharts.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/highcharts/funnel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/highcharts/highcharts-more.js"></script>

<div id="container" ></div>

</body>
</html>