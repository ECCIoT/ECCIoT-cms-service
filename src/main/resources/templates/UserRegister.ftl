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

    <!-- 内容主体区域 -->
    <div style="padding: 15px;">


        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>注册新用户</legend>
        </fieldset>

        <div>
            <!-- 表单 -->
            <form class="layui-form" action="/registerParam">
                <!-- 邮箱 -->
                <div class="layui-form-item">
                    <label class="layui-form-label">邮箱</label>
                    <div class="layui-inline">
                        <input name="email" lay-verify="email" autocomplete="off" class="layui-input" type="text">
                    </div>
                </div>
                <!-- 密码 -->
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input id="psw" name="password" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input" type="password">
                    </div>
                    <div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
                </div>
                <!-- 重复密码 -->
                <div class="layui-form-item">
                    <label class="layui-form-label">重复密码</label>
                    <div class="layui-input-inline">
                        <input id="repwd" lay-verify="repass" placeholder="再次输入密码" autocomplete="off" class="layui-input" type="password">
                    </div>
                    <div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
                </div>
                <!-- 手机号 -->
                <div class="layui-form-item">
                    <label class="layui-form-label">手机</label>
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <input name="phone" lay-verify="phone" autocomplete="off" class="layui-input" type="tel">
                        </div>
                    </div>
                </div>
                <!-- 行业 -->
                <div class="layui-form-item">
                    <label class="layui-form-label">所属行业</label>
                    <div class="layui-input-inline">
                        <select name="industry" lay-filter="aihao">
                            <option value=""></option>
                            <option value="0">教育</option>
                            <option value="1" selected="">物联网</option>
                            <option value="2">金融</option>
                            <option value="3">通信</option>
                            <option value="4">其他</option>
                        </select>
                    </div>
                </div>
                <!-- 提交 -->
                <div class="layui-form-item" align="center">
                    <button class="layui-btn" lay-submit="" lay-filter="demo2">注册</button>
                </div>
            </form>
        </div>
    </div>
</div>


<script src="../layui/layui.js" charset="utf-8"></script>
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