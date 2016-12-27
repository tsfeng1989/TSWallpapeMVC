<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TSwallpape后台管理系统</title>
<link rel="Shortcut Icon" href="${pageContext.request.contextPath}/picture/ico/ts2.png">
	<!-- Loading Bootstrap -->
	<link href="${pageContext.request.contextPath}/dist/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- Loading Flat UI -->
	<link href="${pageContext.request.contextPath}/dist/css/flat-ui.css" rel="stylesheet">

	<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">	
	</head>
<body>
	
	<h3 class="headline">管理员登录</h3>
	<form id="myform" action="${pageContext.request.contextPath}/adminAction/login" method="post">
		<div class="login-form login-form-me">
			<div class="form-group">
				<input name="a_name" type="text" class="form-control login-field" value="admin"
					placeholder="用户名" id="login-name" /> 
				<label class="login-field-icon fui-user" for="login-name"></label>
			</div>
			<div class="form-group">
				<input name="a_password" type="password" class="form-control login-field" value="123456"
					placeholder="密码" id="login-pass" /> 
				<label class="login-field-icon fui-lock" for="login-pass"></label>
			</div>
			<a class="btn btn-primary btn-lg btn-block" href="javascript:validate()">登录</a> 
		</div>
	</form>
	


	<script type="text/javascript">
		function validate(){
		  document.getElementById('myform').submit();
		}
	</script>
	
</body>
</html>