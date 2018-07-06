<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@page import="java.util.Date"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>

	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="this is my page">
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">

	<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
	<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
	<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>


	<script type="text/javascript">

        $(function() {
			var name = "${cookie.managerName.value}";
			var newName = decodeURI(name,"UTF-8");
			$("#managerName").val(newName);

            $("#loginForm").form({

            });

            $("#sub").linkbutton({
                width:100,
                text:"提交",
                onClick:function() {
                    $("#loginForm").form("submit",{
                        url:"${pageContext.request.contextPath}/manager/login.do",
                        onSubmit: function(){
                            console.log("提交前执行");
                            if($("#managerName").val()==""){
                                $.messager.alert("提示","用户名不能为空","info");
								return false;
							}else if ( $("#managerPassword").val()==""){
                                $.messager.alert("提示","密码不能为空","info");
                                return false;
							}else if($("#code").val()==""){
                                $.messager.alert("提示","验证码不能为空","info");
                                return false;
							} else{
                                return $("#loginForm").form("validate");
							}

                        },
                        success:function(data){
                            if(data=="true"){
                                window.location.href="${pageContext.request.contextPath}/main.jsp"
                                // alert('登录成功');
                            }else if (data=="codeFalse"){
                                $.messager.alert("提示",'验证码错误',"info");
							} else{
                                $.messager.alert("提示",'用户名或密码错误',"info");

                            }

                        }
                    });
                },
            });


        });
	</script>
</head>
<body>
	
		<div class="login">
			<form id="loginForm" action="" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="${pageContext.request.contextPath}/img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input type="text" id="managerName"  name="managerName" class="text" value="${managerName}" maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" id="managerPassword" name="managerPassword" class="text" value="" maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="code" name="code" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath }/manager/getCode.do"
									 title="点击更换验证码" onclick="document.getElementById('captchaImage').src='${pageContext.request.contextPath }/manager/getCode.do?date-'+(new Date()).getTime();"/>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
						<td>
							<label>
								<input type="checkbox" id="isRememberUsername" name="check" value="true"/> 记住用户名
							</label>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" id="sub" class="loginButton" value="登录   ">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>