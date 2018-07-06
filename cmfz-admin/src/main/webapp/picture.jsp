<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>
<script type="text/javascript">
        $(function () {
            $('#tab').datagrid({
                // title:'DataGrid - DetailView',
                // width:700,
                // height:220,
                remoteSort:false,
                singleSelect:true,
                nowrap:false,
                fitColumns:true,
                url:'${pageContext.request.contextPath}/picture/showPicture.do',
                columns:[[
                    {field:'pictureId',title:'图片编号',width:200,align:'center'},
                    {field:'picturePath',title:'图片名',width:200,sortable:true,align:'center'},
                    {field:'pictureDescription',title:'描述信息',width:130,align:'center',sortable:true},
                    {field:'pictureStatus',title:'轮播状态',width:30,align:'center',sortable:true},
                    {field:'pictureDate',title:'创建时间',width:100,sortable:true,align:'center'}
                ]],
                pagination : true,
                pageList : [ 5, 10, 15, 20 ],
                pageSize : 5,
                singleSelect : true,
                striped : true,
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="upload/' + rowData.picturePath+'" style="height:150px;"></td>' +
                        '</tr></table>';
                },
                toolbar:[{
                    iconCls: 'icon-add',
                    text:'新增轮播图片',
                    handler: function(){
                        $("#add").dialog({
                            title:"添加轮播图片",
                            width:400,
                            height:200,
                            href: "${pageContext.request.contextPath}/addPicture.jsp",
                            modal: true
                        });
                    }
                },'-',
                    {
                    iconCls: 'icon-delete',
                    text:'删除轮播图片',
                    handler: function(){
                        var rowData = $("#tab").datagrid("getSelected");
                        console.log(rowData.id);
                        if(rowData == null){
                            $.messager.alert('警告','请先选中数据');
                        }else{

                            $.messager.confirm('确认删除', '您确定要删除该条数据吗？', function(r){
                                if (r){
                                    $.ajax({
                                        type : "post",
                                        async : false,
                                        url : "${pageContext.request.contextPath}/picture/removePicture.do",
                                        data : {
                                            "pictureId" : rowData.pictureId,
                                        },
                                        success : function(data) {
                                            data += ""
                                            if (data) {
                                                $.messager.alert('警告','删除成功');
                                                $("#tab").datagrid({});
                                            } else {
                                                $.messager.alert('警告','删除失败');
                                            };
                                        }
                                    });
                                }
                            });

                        }
                    }
                },'-',
                    {
                    iconCls: 'icon-edit',
                    text:'修改轮播图片',
                    handler: function(){
                        var rowData = $("#tab").datagrid("getSelected");
                        // console.log(rowData);
                        if(rowData == null){
                            $.messager.alert('警告','请先选中数据');
                        }else{
                            $.ajax({
                                type : "post",
                                async : false,
                                url : "${pageContext.request.contextPath}/picture/queryPicture.do",
                                data : {
                                    "pictureId" : rowData.pictureId
                                },
                                success : function(data) {
                                    console.log(data);
                                    $("#up").dialog({
                                        title:"修改轮播图片",
                                        width:500,
                                        height:300,
                                        href: "${pageContext.request.contextPath}/modifyPicture.jsp",
                                        modal: true ,
                                        onLoad:function(){
                                            $("#modifyform").form('load',data);
                                        }
                                    });

                                }
                            })



                        }
                    }
                }],
            });

        })
</script>

<table id="tab"></table>
<form id="add"></form>
<form id="up"></form>

