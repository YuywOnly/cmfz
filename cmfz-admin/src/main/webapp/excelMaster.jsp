<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>

<script type="text/javascript">
    $(function () {
       $("#masterExcelSub").linkbutton({
           onClick:function() {
               $("#excelMasterForm").form("submit",{
                   url:"${pageContext.request.contextPath}/easypoi/excelMaster.do",
                   onSubmit: function(){
                       console.log("提交前执行");
                       return $("#excelMasterForm").form("validate");
                   },
                   success:function(data){
                       if(data){
                           $.messager.alert('警告','添加成功');
                           $("#excelMaster").dialog("close");
                           $("#masterTab").datagrid({});
                       }else{
                           $.messager.alert('警告','添加失败');
                       }

                   }
               });

           }
       });
       $("#masterExcelCancel").linkbutton({
           onClick:function() {
               $("#excelMaster").dialog("close");
           }
       })
    });
</script>

<form id="excelMasterForm" method="post" enctype="multipart/form-data">
    <table style="margin: 10px auto; ">

        <tr>
            <td>上师头像：</td>
            <td><input class="easyui-filebox" name="file" data-options="buttonText: '选择文件',
                buttonAlign: 'right',accept:'.xlsx'"></td>
        </tr>


        <tr>
            <td></td>
            <td>
                <a id="masterExcelSub" class="easyui-linkbutton" data-options="iconCls:'icon-accept', text:'提交'"></a>
                <a id="masterExcelCancel" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', text:'取消'"></a>
            </td>
        </tr>
    </table>

</form>`