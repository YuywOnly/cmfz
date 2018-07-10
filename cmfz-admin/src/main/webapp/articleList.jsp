<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $('#articleTab').datagrid({

            url: '${pageContext.request.contextPath}/article/showArticle.do',
            columns: [[
                {field: 'articleId', title: '文章编号', align: 'center', sortable: true},
                {field: 'articleName', title: '文章名', align: 'center'},
                {field: 'masterName', title: '上师法名', align: 'center'},
                {field: 'articleContent', title: '文章内容', align: 'center'},
                {field: 'articleDate', title: '创建时间', align: 'center'},
                {field: 'articleStatus', title: '文章状态', align: 'center'},
            ]],

        });
    });


</script>

<table id="articleTab"></table>
