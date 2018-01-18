<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>设备群组管理 - 控制台 - 云联万物</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <!-- 页面头部 -->
    <#include "./common/header.ftl"/>
    <!-- 左侧导航栏 -->
    <#include "./common/leftside.ftl"/>

    <div class="layui-body">
        <blockquote class="layui-elem-quote">
            以下是所有应用的设备信息，如需要查询单个应用的设备列表请打开<a href="/AppList"><font color="#b22222"> 应用列表 </font></a>找到指定应用后在“操作”列中选择“设备群组”。
        </blockquote>
        <div style="padding: 15px;">
            <!-- 内容主体区域 ： 开始 -->
            <#--应用列表-->
            <#include "./include/device_list.ftl"/>

            <!-- 内容主体区域 ： 结束 -->
        </div>
    </div>

    <!-- 底部固定区域 -->
    <#include "./common/footer.ftl"/>

</div>

</body>
</html>