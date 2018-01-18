<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>设备群组管理 - 控制台 - 云联万物</title>
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="./layui/css/layui.css"  media="all">

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <!-- 页面头部 -->
<#include "./common/header.ftl"/>
    <!-- 左侧导航栏 -->
<#include "./common/leftside.ftl"/>

    <div class="layui-body" style="padding: 15px;">

        <!-- 内容主体区域 ： 开始 -->

        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>设备群组管理</legend>
        </fieldset>

        <div class="site-demo-button" id="layerDemo" style="margin-left: 30px">
            <button data-method="createDevice" class="layui-btn">创建新设备</button>
        </div>

        <#--应用列表-->
        <#include "./include/device_list.ftl"/>

        <!-- 内容主体区域 ： 结束 -->
    </div>

    <!-- 底部固定区域 -->
<#include "./common/footer.ftl"/>

</div>

<script>
    layui.use('layer', function(){ //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句

        //触发事件
        var active = {
            createDevice: function(){
                //示范一个公告层
                layer.open({
                    type: 1
                    ,title: '创建新设备' //不显示标题栏
                    ,closeBtn: false
                    ,area: '300px;'
                    ,shade: 0.8
                    ,id: 'layCreateDevice' //设定一个id，防止重复弹出
                    ,btn: '取消'
                    ,btnAlign: 'c'
                    ,moveType: 1 //拖拽模式，0或者1
                    ,content: '' +
                    '<div style="padding: 15px; line-height: 22px; background-color: #393D49; color: #393D49; font-weight: 300;">' +
                    '<form class="layui-form layui-form-pane" action="/createDevice">' +
                    '<input name="appApikey" class="layui-input" type="hidden" value="${app_api_key}">' +
                    '<div class="layui-form-item"><label class="layui-form-label">设备型号</label><div class="layui-input-block"><input name="deviceModel" autocomplete="off" placeholder="请输入设备型号" class="layui-input" type="text"></div></div>' +
                    '<div class="layui-form-item"><label class="layui-form-label">设备标记</label><div class="layui-input-block"><input name="deviceFlag" autocomplete="off" placeholder="请输入标记" class="layui-input" type="text"></div></div>' +
                    '<div class="layui-form-item layui-form-text"><label class="layui-form-label">说明</label>' +
                    '<div class="layui-input-block"><textarea name="deviceNote" placeholder="请输入内容" class="layui-textarea"></textarea></div></div>' +
                    '<div class="layui-form-item"><button class="layui-btn" lay-submit="" lay-filter="demo1">创建</button>' +
                    '<button type="reset" class="layui-btn layui-btn-primary">重置</button></div></form>' +
                    '</div>'
                });
            }
        };

        $('#layerDemo .layui-btn').on('click', function(){
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });
    });
</script>

</body>
</html>