<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor')
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/upload';  // 上传图片到服务器
    editor.customConfig.uploadFileName = 'files'; //上传图片的名称
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.create()
    $(function () {
        $("#user").textbox({
            required: true,
            validateOnCreate: false,
            validateOnBlur: true,
            prompt: "请您输入文章的标题",
        });

        $('#btn').linkbutton({
            text: '创建文章',
            onClick: function () {

                $('#form7').form('submit', {
                    url: "${pageContext.request.contextPath}/article/createArticle",
                    onSubmit: function (param) {
                        param.p1 = (editor).txt.html();
                        console.log(param);
                        param.masterName = $("#masterId").combobox("getText");
                        console.log(param.masterName);
                    },
                    success:function(data){
                        if(data){
                            $.messager.alert('警告','创建成功');
                            // $("#form7").form("reset");
                            // (editor).txt.html("");
                        }else{
                            $.messager.alert('警告','创建失败');
                        }

                    }

                });


            },
        });
        $('#btn1').linkbutton({
            text: '重置内容',
            onClick: function () {
                $("#form7").form("reset");
                (editor).txt.html("");
            },
        });

        $("#masterId").append("<option value='未知' selected></option>");
        $("#masterId").combobox({
            url:'${pageContext.request.contextPath}/master/findAll',
            valueField:'masterId',
            textField:'masterName',
            select:'',
        });

    });
</script>


<form id="form7" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td width="100px">文章标题</td>
            <td><input id="articleName" name="articleName"></td>
        </tr>

        <tr>
            <td width="100px">文章作者</td>
            <td><select id="masterId" class="easyui-combobox" name="masterId" style="width: 100px" ></select>
            </td>
        </tr>

        <tr>
            <td>状态：</td>
            <td><input class="easyui-switchbutton" name="articleStatus" data-options="onText:'上架',offText:'未上架',"></td>
        </tr>

        <tr>
            <td colspan="2">
                <div id="editor">
                    <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
                </div>

            </td>
        </tr>
        <tr>
            <%--提交--%>
            <td><a id="btn" href="#"></a></td>
                <%--重置--%>
            <td><a id="btn1" href="#"></a></td>
        </tr>


    </table>
</form>



