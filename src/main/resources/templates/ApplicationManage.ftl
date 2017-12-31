<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>应用管理 - 控制台 - 云联万物</title>
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

            <div class="site-demo-button" id="layerDemo" style="margin-bottom: 0;">
                <button data-method="createApp" class="layui-btn">创建新应用</button>
            </div>

            <!-- 内容主体区域 ： 结束 -->

        </div>
    </div>

    <!-- 底部固定区域 -->
    <#include "./common/footer.ftl"/>

</div>


<script src="./layui/layui.js"></script>
<script>
    layui.use('layer', function(){ //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句

        //触发事件
        var active = {
            createApp: function(){
                //示范一个公告层
                layer.open({
                    type: 1
                    ,title: '创建新应用' //不显示标题栏
                    ,closeBtn: false
                    ,area: '300px;'
                    ,shade: 0.8
                    ,id: 'layCreateApp' //设定一个id，防止重复弹出
                    ,btn: '取消'
                    ,btnAlign: 'c'
                    ,moveType: 1 //拖拽模式，0或者1
                    ,content: '' +
                            '<div style="padding: 15px; line-height: 22px; background-color: #393D49; color: #393D49; font-weight: 300;">' +
                            '<form class="layui-form layui-form-pane" action="/createApp">' +
                            '<div class="layui-form-item"><label class="layui-form-label">应用名称</label><div class="layui-input-block"><input name="appName" autocomplete="off" placeholder="请输入名称" class="layui-input" type="text"></div></div>' +
                            '<div class="layui-form-item layui-form-text"><label class="layui-form-label">说明</label>' +
                            '<div class="layui-input-block"><textarea name="appNote" placeholder="请输入内容" class="layui-textarea"></textarea></div></div>' +
                            '<div class="layui-form-item"><button class="layui-btn" lay-submit="" lay-filter="demo1">创建</button><button type="reset" class="layui-btn layui-btn-primary">重置</button></div></form>' +
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