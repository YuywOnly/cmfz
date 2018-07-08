<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $('#masterTab').datagrid({
            remoteSort: false,
            singleSelect: true,
            nowrap: false,
            fitColumns: true,
            url: '${pageContext.request.contextPath}/master/showMaster.do',
            columns: [[
                {field: 'masterId', title: '上师编号', width: 50, align: 'center', sortable: true},
                {field: 'masterPhoto', title: '上师头像', width: 100, align: 'center'},
                {field: 'masterName', title: '上师法名', width: 150, align: 'center'},
                {field: 'masterSummary', title: '上师简介', width: 260, align: 'center'},
            ]],
            pagination: true,
            pageList: [3, 6, 9, 12],
            pageSize: 3,
            singleSelect: true,
            striped: true,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="upload/master/' + rowData.masterPhoto + '" style="height:150px;"></td>' +
                    '</tr></table>';
            },
            toolbar: [{
                iconCls: 'icon-add',
                text: '新增上师',
                handler: function () {
                    $("#addMaster").dialog({
                        title: "添加上师",
                        width: 400,
                        height: 200,
                        href: "${pageContext.request.contextPath}/addMaster.jsp",
                        modal: true
                    });
                }
            }, '-',
                {
                    iconCls: 'icon-delete',
                    text: '删除上师',
                    handler: function () {
                        var rowData = $("#masterTab").datagrid("getSelected");
                        console.log(rowData.id);
                        if (rowData == null) {
                            $.messager.alert('警告', '请先选中数据');
                        } else {

                            $.messager.confirm('确认删除', '您确定要删除该条数据吗？', function (r) {
                                if (r) {
                                    $.ajax({
                                        type: "post",
                                        async: false,
                                        url: "${pageContext.request.contextPath}/master/removeMaster.d0",
                                        data: {
                                            "masterId": rowData.masterId,
                                        },
                                        success: function (data) {
                                            data += ""
                                            if (data) {
                                                $.messager.alert('警告', '删除成功');
                                                $("#masterTab").datagrid({});
                                            } else {
                                                $.messager.alert('警告', '删除失败');
                                            }
                                            ;
                                        }
                                    });
                                }
                            });

                        }
                    }
                }, '-',
                {
                    iconCls: 'icon-edit',
                    text: '修改上师信息',
                    handler: function () {
                        var rowData = $("#masterTab").datagrid("getSelected");
                        // console.log(rowData);
                        if (rowData == null) {
                            $.messager.alert('警告', '请先选中数据');
                        } else {
                            $.ajax({
                                type: "post",
                                async: false,
                                url: "${pageContext.request.contextPath}/master/queryMaster.do",
                                data: {
                                    "masterId": rowData.masterId
                                },
                                success: function (data) {
                                    console.log(data);
                                    $("#upMaster").dialog({
                                        title: "修改上师信息",
                                        width: 500,
                                        height: 300,
                                        href: "${pageContext.request.contextPath}/modifyMaster.jsp",
                                        modal: true,
                                        onLoad: function () {
                                            $("#modifyMasterForm").form('load', data);
                                        }
                                    });

                                }
                            })


                        }
                    }
                }, '-',
                {
                    iconCls: 'icon-page_excel',
                    text: '上师批量上传',
                    handler: function () {
                        $("#excelMaster").dialog({
                            title: "批量上传上师",
                            width: 400,
                            height: 200,
                            href: "${pageContext.request.contextPath}/excelMaster.jsp",
                            modal: true
                        });
                    }

                }],
        });

    });


    function qq(value){

        if(value != ""){

            $('#masterTab').datagrid('load',{
                masterName : value
            });
            $('#masterTab').datagrid({
                url: "${pageContext.request.contextPath}/master/queryMasterByName.do",

            });
        }else {
            $('#masterTab').datagrid({
                url: "${pageContext.request.contextPath}/master/showMaster.do",

            });
        }

    }

</script>
<input id="ss" class="easyui-searchbox" style="width:300px"
       data-options="searcher:qq,prompt:'Please Input Master Name'"></input>
<table id="masterTab"></table>
<form id="addMaster"></form>
<form id="upMaster"></form>
<form id="excelMaster"></form>