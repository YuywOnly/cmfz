<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>

<script type="text/javascript">
    $(function () {
        $("#modifysub").linkbutton({
            onClick:function() {
                $("#modifyform").form("submit",{
                    url:"${pageContext.request.contextPath}/picture/modifyPicture.do",
                    onSubmit: function(){
                        console.log("提交前执行");
                        return $("#modifyform").form("validate");
                    },
                    success:function(data){
                        if(data){
                            $.messager.alert('警告','修改成功');
                            $("#up").dialog("close");
                            $("#tab").datagrid({});
                        }else{
                            $.messager.alert('警告','修改失败');
                        }

                    }
                });

            }
        });
        $("#modifycancel").linkbutton({
            onClick:function() {
                $("#up").dialog("close");
            }
        })
    });
</script>

<form id="modifyform" method="post" enctype="multipart/form-data">
    <table style="margin: 10px auto; ">

        <tr>
            <td>图片编号：</td>
            <td><input id="id" name="pictureId" readonly></td>
        </tr>

        <tr>
            <td>图片名称：</td>
            <td><input id="name" name="picturePath" readonly></td>
        </tr>

        <tr>
            <td>展示状态：</td>
            <td>
                <input type="radio" name="pictureStatus" value="0" >展示中
                <input type="radio" name="pictureStatus" value="1">不展示
            </td>
        </tr>


        <tr>
            <td>描述信息：</td>
            <td><input id="description" name="pictureDescription"></td>
        </tr>

        <tr>
            <td>上传时间：</td>
            <td><input id="time" name="pictureDate" readonly></td>
        </tr>


        <tr>
            <td></td>
            <td>
                <a id="modifysub" class="easyui-linkbutton" data-options="iconCls:'icon-accept', text:'提交'"></a>
                <a id="modifycancel" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', text:'取消'"></a>
            </td>
        </tr>
    </table>

</form>`
