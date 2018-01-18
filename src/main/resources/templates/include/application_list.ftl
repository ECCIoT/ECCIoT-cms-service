<script src="./layui/layui.js"></script>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>应用列表</legend>
</fieldset>

<div style="margin-left: 30px">
    <table class="layui-table" lay-data="{url:'/getApplicationList', page:false, id:'test2', skin: 'row', even: true}">
        <thead>
        <tr>
            <th lay-data="{field:'appName', width:150, sort: true}">应用名称</th>
            <th lay-data="{field:'appAPIKey', width:320 }">API Key</th>
            <th lay-data="{field:'appNote', width:250 , align: 'left'}">说明</th>
            <th lay-data="{field:'btnManage', width:180 , align: 'center', templet: '#manageTpl'}">操作</th>
        </tr>
        </thead>
    </table>

    <script type="text/html" id="manageTpl">
        <a href="/ServerSetting?apikey={{d.appAPIKey}}">服务配置</a>  |
        <a href="/devicePage?apikey={{d.appAPIKey}}">设备群组</a>
    </script>
</div>

<script>
    layui.use('table', function(){
        var table = layui.table;
    });
</script>