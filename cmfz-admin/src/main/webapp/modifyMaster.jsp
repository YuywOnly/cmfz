<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>

<script type="text/javascript">
    $(function () {
        $("#modifyMasterSub").linkbutton({
            onClick:function() {
                $("#modifyMasterForm").form("submit",{
                    url:"${pageContext.request.contextPath}/master/modifyMaster.do",
                    onSubmit: function(){
                        console.log("提交前执行");
                        return $("#modifyMasterForm").form("validate");
                    },
                    success:function(data){
                        if(data){
                            $.messager.alert('警告','修改成功');
                            $("#upMaster").dialog("close");
                            $("#masterTab").datagrid({});
                        }else{
                            $.messager.alert('警告','修改失败');
                        }

                    }
                });

            }
        });
        $("#modifyMasterCancel").linkbutton({
            onClick:function() {
                $("#upMaster").dialog("close");
            }
        })
    });
</script>

<form id="modifyMasterForm" method="post" enctype="multipart/form-data">
    <table style="margin: 10px auto; ">

        <tr>
            <td>上师编号：</td>
            <td><input id="masterId" name="masterId" readonly></td>
        </tr>

        <tr>
            <td>上师法名：</td>
            <td><input id="masterName" name="masterName"></td>
        </tr>

        <tr>
            <td>上师头像：</td>
            <td><input id="masterPhoto" name="masterPhoto" readonly></td>
        </tr>

        <tr>
            <td>上师简介：</td>
            <td><input id="masterSummary" name="masterSummary"></td>
        </tr>


        <tr>
            <td></td>
            <td>
                <a id="modifyMasterSub" class="easyui-linkbutton" data-options="iconCls:'icon-accept', text:'提交'"></a>
                <a id="modifyMasterCancel" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', text:'取消'"></a>
            </td>
        </tr>
    </table>

</form>`
