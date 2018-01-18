
<script src="./layui/layui.js"></script>

<div class="layui-header">
    <div class="layui-logo"><a href="/index"><font color="#eee8aa">ECC云联万物</font></a></div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item"><a href="">解决方案</a></li>
        <li class="layui-nav-item"><a href="">接入案例</a></li>
        <li class="layui-nav-item">
            <a href="javascript:;">技术支持</a>
            <dl class="layui-nav-child">
                <dd><a href="">入门指南</a></dd>
                <dd><a href="">技术文档</a></dd>
                <dd><a href="">常见问题</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="">关于作者</a></li>
    </ul>
    <!--判断用户是否登录 - 根据登录状态显示相应内容-->
    <#if account??>
        <!--存在用户信息-->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                <#--<img src=${user_image!"http://t.cn/RCzsdCq"} class="layui-nav-img">-->
                ${account}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">消息提醒(0)</a></dd>
                    <dd><a href="/userManage">安全设置</a></dd>
                    <dd><a href="/logout">注销</a></dd>
                </dl>
            </li>
        </ul>
    <#else>
        <!--不存在用户信息-->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item"><a href="/loginPage">开发者中心</a></li>
            <li class="layui-nav-item"><a href="/registerPage">注册</a></li>
        </ul>
    </#if>
</div>

<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });
</script>