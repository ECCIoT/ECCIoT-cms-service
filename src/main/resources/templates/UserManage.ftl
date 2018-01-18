<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>云联万物 - 控制台</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <!-- 页面头部 -->
    <#include "./common/header.ftl"/>
    <!-- 左侧导航栏 -->
    <#include "./common/leftside.ftl"/>
    <!-- 内容主体区域 -->
    <div class="layui-body" style="padding: 15px;">

        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>修改密码</legend>
        </fieldset>

        <div>
            <font size="3" color="red">${error_info!''}</font>
            <br><br>

            <!-- 表单 -->
            <form class="layui-form" action="/changePassword">
                <!-- 原密码 -->
                <div class="layui-form-item">
                    <label class="layui-form-label">原密码</label>
                    <div class="layui-input-inline">
                        <input  name="pass" lay-verify="pass" placeholder="请输入原密码" autocomplete="off" class="layui-input" type="password">
                    </div>
                    <div class="layui-form-mid layui-word-aux">请输入当前密码</div>
                </div>

                <br><br>

                <!-- 新密码 -->
                <div class="layui-form-item">
                    <label class="layui-form-label">新密码</label>
                    <div class="layui-input-inline">
                        <input id="newpwd" name="newpass" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input" type="password">
                    </div>
                    <div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
                </div>
                <!-- 重复密码 -->
                <div class="layui-form-item">
                    <label class="layui-form-label">重复密码</label>
                    <div class="layui-input-inline">
                        <input id="repwd" lay-verify="repass" placeholder="再次输入密码" autocomplete="off" class="layui-input" type="password">
                    </div>
                    <div class="layui-form-mid layui-word-aux">重复输入密码</div>
                </div>

                <!-- 提交 -->
                <div class="layui-form-item" align="center">
                    <button class="layui-btn" lay-submit="" lay-filter="demo2">保存修改</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    var pswd;

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

        //自定义验证规则
        form.verify({
            pass: function (value) {
                pswd = value;
                if(!(/(.+){6,12}$/.test(value))){
                    return '密码必须6到12位，且不能出现空格';
                }
            }
            ,repass: function (value) {
                if(pswd != value){
                    return "两次输入的密码不一致.";
                }
            }
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