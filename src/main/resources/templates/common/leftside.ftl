<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree"  lay-filter="test">
            <li class="layui-nav-item layui-nav-itemed">
                <a class="" href="javascript:;">应用管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="/AppPage">应用概况</a></dd>
                    <dd><a href="/AppList">应用列表</a></dd>
                    <dd><a href="/AppTrafficStatistics">流量统计</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="devices">设备群组</a></li>
            <li class="layui-nav-item"><a href="">APIKey管理</a></li>
            <li class="layui-nav-item layui-nav-itemed">
                <a class="" href="javascript:;">数据通信</a>
                <dl class="layui-nav-child">
                    <dd><a href="">趋势分析</a></dd>
                    <dd><a href="">记录查询</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item layui-nav-itemed">
                <a class="" href="javascript:;">我的账号</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">个人信息</a></dd>
                    <dd><a href="/userManage">账号安全</a></dd>
                    <dd><a href="/logout">注销</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>