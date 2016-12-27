<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<link rel="Shortcut Icon" href="${pageContext.request.contextPath}/picture/ico/ts2.png">
	<!-- Loading Bootstrap -->
	<link href="${pageContext.request.contextPath}/dist/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- Loading Flat UI -->
	<link href="${pageContext.request.contextPath}/dist/css/flat-ui.css" rel="stylesheet">

	<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">

</head>
<body>
	<h3 class="headline">注册</h3>
	<form id="myform" action="${pageContext.request.contextPath}/usersAction/addUsers" method="post">
		<div class="login-form login-form-me">
			<div class="form-group">
				<input name="u_name" type="text" class="form-control login-field" value=""
					placeholder="用户名" id="login-name" /> 
				<label class="login-field-icon fui-user" for="login-name"></label>
			</div>
	
			<div class="form-group">
				<input name="u_pass" type="password" class="form-control login-field" value=""
					placeholder="密码" id="login-pass" /> 
				<label class="login-field-icon fui-lock" for="login-pass"></label>
			</div>
			
			<div class="form-group" style="text-align: center;">
				
				<label class="radio">
					<input type="radio"  name="u_sex" id="optionsRadios2" value="男" data-toggle="radio" checked="" class="custom-radio"><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
					男
				</label>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label class="radio">
					<input type="radio"  name="u_sex" id="optionsRadios1" value="女" data-toggle="radio" class="custom-radio"><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
					女
				</label>
			</div>
			
			<div class="form-group">
				<input name="u_age" type="text" class="form-control login-field" value=""
					placeholder="年龄" id="login-name" /> 
				<label class="login-field-icon fui-user" for="login-name"></label>
			</div>
			
			<div class="form-group">
				<input name="u_email" type="text" class="form-control login-field" value=""
					placeholder="邮箱" id="login-name" /> 
				<label class="login-field-icon fui-mail" for="login-name"></label>
			</div>
	
			<a class="btn btn-primary btn-lg btn-block" href="javascript:validate()">注册</a> 
			<a class="login-link" href="${pageContext.request.contextPath}/pages/users_login.jsp">已有账号，马上登录</a>
			
		</div>
	</form>
	<script type="text/javascript">
		function validate(){
		  document.getElementById('myform').submit();
		}
	</script>
	
</body>
</html>