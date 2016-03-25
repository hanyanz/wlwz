<%--
  Created by IntelliJ IDEA.
  User: yanzi
  Date: 2016/3/9
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Highcharts Example</title>

  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
  <script type="text/javascript">
    //x轴值
    var categories=<%=categories%>;

    //y轴值
    var data=<%=data%>;

    //创建图表
    var chart;
    $(document).ready(function() {
      chart = new Highcharts.Chart( {
        chart : {
          renderTo : 'container',
          type : 'spline',
          events : {
            load : st// 定时器
          }
        },
        title : {
          text : '动物数量统计'
        },
        xAxis : {
          categories : categories,
          title : {
            text : 'name'
          }

        },
        yAxis : {
          min : 0,
          title : {
            text : 'number'
          }
        },
        legend: {
          enabled: false
        },
        tooltip : {
          formatter : function() {
            return '' + this.series.name + ': ' + this.y + '';
          }
        },
        credits : {
          enabled: false
        },
        plotOptions : {
          series : {
            stacking : 'normal'
          }
        },
        series : [ {
          name : '个',
          data : data
        } ]
      });


    });


    //10秒钟刷新一次数据
    function st() {
      setInterval("getData()", 10000);
    }

    //动态更新图表数据
    function getData() {

      var categories = [];
      $.ajax({
        type: "post",
        url: "${pageContext.request.contextPath}/demo/chart_demo.action",
        dataType: "json",
        success : function(data){
          var d = [];
          $(data).each(function(n,item){
            d.push(item.data);
            categories.push(item.categories);
          })
          chart.series[0].setData(d);
          chart.xAxis[0].setCategories(categories);
        }
      });
    }

  </script>
</head>
<body>
<script type="text/javascript" src="${pageContext.request.contextPath}/highcharts/highcharts.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/highcharts/funnel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/highcharts/highcharts-more.js"></script>

<div id="container" ></div>
</body>
</html>