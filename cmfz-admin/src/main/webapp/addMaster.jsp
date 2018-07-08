<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>

<script type="text/javascript">
    $(function () {
       $("#masterSub").linkbutton({
           onClick:function() {
               $("#addMasterForm").form("submit",{
                   url:"${pageContext.request.contextPath}/master/addMaster.do",
                   onSubmit: function(){
                       console.log("提交前执行");
                       return $("#addMasterForm").form("validate");
                   },
                   success:function(data){
                       if(data){
                           $.messager.alert('警告','添加成功');
                           $("#addMaster").dialog("close");
                           $("#masterTab").datagrid({});
                       }else{
                           $.messager.alert('警告','添加失败');
                       }

                   }
               });

           }
       });
       $("#masterCancel").linkbutton({
           onClick:function() {
               $("#addMaster").dialog("close");
           }
       })
    });
</script>

<form id="addMasterForm" method="post" enctype="multipart/form-data">
    <table style="margin: 10px auto; ">

        <tr>
            <td>上师法名：</td>
            <td><input id="masterName" name="masterName"></td>
        </tr>

        <tr>
            <td>上师头像：</td>
            <td><input class="easyui-filebox" name="file" data-options="buttonText: '选择文件',
                buttonAlign: 'right',accept:'.jpg,.png,.gif'"></td>
        </tr>

        <tr>
            <td>上师简介：</td>
            <td><input id="masterSummary" name="masterSummary"></td>
        </tr>

        <tr>
            <td></td>
            <td>
                <a id="masterSub" class="easyui-linkbutton" data-options="iconCls:'icon-accept', text:'提交'"></a>
                <a id="masterCancel" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', text:'取消'"></a>
            </td>
        </tr>
    </table>

</form>`