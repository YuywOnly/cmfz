<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>

<script type="text/javascript">
    $(function () {
       $("#sub").linkbutton({
           onClick:function() {
               $("#addform").form("submit",{
                   url:"${pageContext.request.contextPath}/picture/addPicture.do",
                   onSubmit: function(){
                       console.log("提交前执行");
                       return $("#addform").form("validate");
                   },
                   success:function(data){
                       if(data){
                           $.messager.alert('警告','添加成功');
                           $("#add").dialog("close");
                           $("#tab").datagrid({});
                       }else{
                           $.messager.alert('警告','添加失败');
                       }

                   }
               });

           }
       });
       $("#cancel").linkbutton({
           onClick:function() {
               $("#add").dialog("close");
           }
       })
    });
</script>

<form id="addform" method="post" enctype="multipart/form-data">
    <table style="margin: 10px auto; ">

        <tr>
            <td>展示状态：</td>
            <td>
                <input type="radio" name="pictureStatus" value="0" checked>展示中
                <input type="radio" name="pictureStatus" value="1">不展示
            </td>
        </tr>


        <tr>
            <td>描述信息：</td>
            <td><input id="description" name="pictureDescription"></td>
        </tr>

        <tr>
            <td>上传图片：</td>
            <td><input class="easyui-filebox" name="file" data-options="buttonText: '选择文件',
                buttonAlign: 'right',accept:'.jpg,.png,.gif'"></td>
        </tr>

        <tr>
            <td></td>
            <td>
                <a id="sub" class="easyui-linkbutton" data-options="iconCls:'icon-accept', text:'提交'"></a>
                <a id="cancel" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', text:'取消'"></a>
            </td>
        </tr>
    </table>

</form>`