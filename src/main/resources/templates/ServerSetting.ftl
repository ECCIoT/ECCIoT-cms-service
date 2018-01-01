<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>服务端配置 - 控制台 - 云联万物</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
    <script src="../echarts/echarts.min.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <!-- 页面头部 -->
    <#include "./common/header.ftl"/>
    <!-- 左侧导航栏 -->
    <#include "./common/leftside.ftl"/>

    <div class="layui-body">

        <blockquote class="layui-elem-quote">
            API Key:${server_api_key!'null'}
        </blockquote>

        <div style="padding: 15px;">

            <!-- 内容主体区域 ： 开始 -->
            <form class="layui-form" action="">

                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                    <legend>基本配置</legend>
                </fieldset>

                <div class="layui-form-item">
                    <label class="layui-form-label">服务器功能</label>
                    <div class="layui-input-block">
                        <input name="close" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF" type="checkbox">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">通信方式</label>
                    <div class="layui-input-block">
                        <input name="model" value="HTTP" title="HTTP" checked="" type="radio">
                        <input name="model" value="HTTPS" title="HTTPS" disabled="" type="radio">
                        <input name="model" value="UPD" title="UDP" type="radio">
                        <input name="model" value="TCP" title="TCP" disabled="" type="radio">
                    </div>
                </div>

                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                    <legend>HTTP方式</legend>
                </fieldset>

                <div class="layui-form-item">
                    <label class="layui-form-label">服务端接口</label>
                    <div class="layui-input-block">
                        <input name="title" lay-verify="title" autocomplete="off" placeholder="接口URL,示例：http://127.0.0.1:9999/project?value=" class="layui-input" type="text">
                    </div>
                </div>

                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                    <legend>UDP方式</legend>
                </fieldset>

                <div class="layui-form-item">
                    <label class="layui-form-label">IP地址</label>
                    <div class="layui-input-block" style="width: 250px">
                        <input name="title" lay-verify="title" autocomplete="off" placeholder="请输入IP地址，例如：127.0.0.1" class="layui-input" type="text">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">端口号</label>
                    <div class="layui-input-block" style="width: 250px">
                        <input name="title" lay-verify="title" autocomplete="off" placeholder="请输入端口号，例如：9999" class="layui-input" type="text">
                    </div>
                </div>


                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;"></fieldset>
                <div class="layui-form-item" style="margin-left: 30px">
                    <button class="layui-btn" lay-submit="" lay-filter="demo1">保存配置</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </form>

            <!-- 内容主体区域 ： 结束 -->

        </div>
    </div>

    <!-- 底部固定区域 -->
    <#include "./common/footer.ftl"/>

</div>

<script src="../layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
                ,layer = layui.layer
                ,layedit = layui.layedit
                ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 5){
                    return '标题至少得5个字符啊';
                }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function(data){
            layer.msg('服务器通信功能已'+ (this.checked ? '打开' : '关闭'), {
                offset: '6px'
            });
            layer.tips('注意：服务端通信功能状态已更改', data.othis)
        });

        //监听提交
        form.on('submit(demo1)', function(data){
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return false;
        });


    });
</script>
</body>
</html>