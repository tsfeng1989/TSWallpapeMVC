<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="Shortcut Icon" href="${pageContext.request.contextPath}/picture/ico/ts2.png">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
</head>
<body>
	<h2>welcome ${user.u_name}</h2>
	ID:<font>${user.u_no}</font>
</body>
<script type="text/javascript">
	//alert("${u.u_name}");
</script>
</html>