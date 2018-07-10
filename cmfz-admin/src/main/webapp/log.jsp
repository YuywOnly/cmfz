<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>
<script type="text/javascript">
        $(function () {
            $('#logTab').datagrid({
                url:'${pageContext.request.contextPath}/log/showLog',
                columns : [ [ {
                    field : "logId",
                    title : "操作编号"
                }, {
                    field : "logUser",
                    title : "操作用户"
                }, {
                    field : "logTime",
                    title : "操作时间"
                }, {
                    field : "logResource",
                    title : "资源"
                },{
                    field : "logAction",
                    title : "操作"
                },{
                    field : "logMessage",
                    title : "修改详情",
                    width:200,
                    height:100,
                },{
                    field : "logResult",
                    title : "结果"
                } ] ],
                pagination : true,
                pageList : [ 5, 10, 15, 20 ],
                pageSize : 5,
                singleSelect : true,
                striped : true,
            });
        });

</script>

<table id="logTab"></table>


