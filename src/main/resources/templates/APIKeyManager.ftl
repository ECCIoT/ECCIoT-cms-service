<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>APIKey管理器 - 控制台 - 云联万物</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <!-- 页面头部 -->
    <#include "./common/header.ftl"/>
    <!-- 左侧导航栏 -->
    <#include "./common/leftside.ftl"/>

    <div class="layui-body">

        <div style="padding: 15px;">

            <!-- 内容主体区域 ： 开始 -->

            

            <!-- 内容主体区域 ： 结束 -->

        </div>
    </div>

    <!-- 底部固定区域 -->
    <#include "./common/footer.ftl"/>

</div>


<script src="./layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>