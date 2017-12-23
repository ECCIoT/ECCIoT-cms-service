<div class="layui-header">
    <div class="layui-logo">ECC云联万物</div>
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
    <#if msg_msgcount??>

        <!--存在用户信息-->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src=${user_image!"http://t.cn/RCzsdCq"} class="layui-nav-img">
                ${user_nickname}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">消息提醒(${msg_msgcount})</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="/logout">注销</a></li>
        </ul>

    <#else>

        <!--不存在用户信息-->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item"><a href="/loginPage">开发者中心</a></li>
            <li class="layui-nav-item"><a href="/registerPage">注册</a></li>
        </ul>

    </#if>




</div>