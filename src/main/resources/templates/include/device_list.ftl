<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>设备列表</legend>
</fieldset>

<#--数据表格-->
<div style="margin-left: 30px">
    <table class="layui-table" lay-data="{url:'getDeviceList?appApikey=${app_api_key!'null'}', page:false, id:'test2', skin: 'row', even: true}">
        <thead>
        <tr>
            <th lay-data="{field:'deviceModel', width:160, sort: true}">设备型号</th>
            <th lay-data="{field:'deviceFlag', width:160, sort: true}">标记</th>
            <th lay-data="{field:'deviceAPIkey', width:350 , align: 'left'}">API Key</th>
            <th lay-data="{field:'deviceNote', width:200 , align: 'left'}">说明</th>
            <th lay-data="{field:'deviceManage', width:150 , align: 'center', templet: '#manageTpl'}">操作</th>
        </tr>
        </thead>
    </table>

    <script type="text/html" id="manageTpl">
        <a href="">删除设备</a>
    </script>
</div>

<script>
    layui.use('table', function(){
        var table = layui.table;
    });
</script>