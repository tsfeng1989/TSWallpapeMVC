<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${sessionScope.user.u_name}个人中心</title>
<link rel="Shortcut Icon" href="${pageContext.request.contextPath}/picture/ico/ts2.png">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<!-- bootstrap -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user_info.css">

<!-- 上传图片插件 -->
<link media="all" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/fileinput.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fileinput.js"></script>




<script type="text/javascript">
$(function(){
	if('${empty sessionScope.user }'=='true')
		location.href = "${pageContext.request.contextPath}/pages/users_login.jsp";
});
</script>
</head>
<body>
	<!-- ------------------------------------------网页顶部开始------------------------------------------ -->
	<div class="ts-top">
		<a href="${pageContext.request.contextPath}/index.jsp" id="logo">TSwallpape</a>
		<!-- 搜索框 -->
		<div class="search-box">
			<form action="" method="post">
				<input name="search-value" type="text" class="form-control" value="" placeholder="Search..."/> 
				<button class="search-icon"><span class="glyphicon glyphicon-search"></span></button>
			</form>
		</div>
		<div id="userpanel">
			<c:choose>
				<c:when test="${not empty sessionScope.user}">
					<span class="welcome-text">welcome back</span>
					&nbsp;
					<!-- 用户名 -->
					<div class="btn-group">
					  <button data-toggle="dropdown" class="btn btn-primary dropdown-toggle" type="button">${sessionScope.user.u_name} <span class="caret"></span></button>
					  <ul role="menu" class="dropdown-menu username">
					    <li>用户菜单</li>
					    <li class="divider"></li>
					    <li>
					    	<div class="user-info">
					    		<div class="user-info-left">
					    			<!-- 用户头像 -->
						    		<div class="user-portrait-box">
						    			<c:choose>
							    			<c:when test="${not empty sessionScope.user.u_photo}">
								    			<a href="${pageContext.request.contextPath}/pages/users_info.jsp">
								    				<img class="user-portrait" src="${pageContext.request.contextPath}/${sessionScope.user.u_photo}">
							    				</a>
							    			</c:when>
							    			<c:otherwise>
							    				<a href="${pageContext.request.contextPath}/pages/users_info.jsp">
							    					<img class="user-portrait-default" src="${pageContext.request.contextPath}/picture/headPortrait/default/user.jpg">
							    				</a>
							    			</c:otherwise>
						    			</c:choose>
						    		</div>
					    		
						    		<!-- 用户名称 -->
						    		<div class="user-name-box">
						    			<a href="${pageContext.request.contextPath}/pages/users_info.jsp">${sessionScope.user.u_name}</a>
						    		</div>
					    		</div>
					    		
					    		<div class="user-info-right">
					    			<div class="guanzhu">
					    				<a href="#">
					    					<span>${sessionScope.user.u_attention}</span>
					    					<span>关注</span>
					    				</a>
					    			</div>
					    			
					    			<div class="fensi">
					    				<a href="#">
					    					<span>${sessionScope.user.u_fans}</span>
					    					<span>粉丝</span>
					    				</a>
					    			</div>
					    			
					    			<div class="uploads">
					    				<a href="#">
					    					<span class="glyphicon glyphicon-upload"></span>
					    					&nbsp;
					    					<span>${sessionScope.user.u_upload}</span>
					    				</a>
					    			</div>
					    			
					    			<div class="favorites">
					    				<a href="#">
					    					
					    					<span class="glyphicon glyphicon-star"></span>
					    					&nbsp;
					    					<span>${sessionScope.user.u_collect}</span>
					    				</a>
					    			</div>
					    			
					    		</div>
					    		
					    	</div>
					    </li>
					    <li class="divider"></li>
					    
					    <li>
					    	<div class="user-setting">
					    		<div class="setting-icon-box">
					    			<span class="glyphicon glyphicon-cog"></span>
					    		</div>
					    		<div>
					    			<a href="#">修改个人信息</a>
					    			&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;
					    			<a href="#">修改密码</a>
					    		</div>
					    	</div>
					    </li>
					    
					    <li class="divider"></li>
					    
					    <li>
					    	<div class="user-message">
					    		<div class="setting-message-box">
					    			<span class="glyphicon glyphicon-envelope"></span>
					    		</div>
					    		
					    		<div>
					    			<a href="#">新消息：0</a>
					    		</div>
					    	</div>
							
						</li>
					    <li class="divider"></li>
					    <li>
						    <a href="${pageContext.request.contextPath}/usersAction/logout">
						    	<span class="glyphicon glyphicon-log-out"></span>&nbsp;&nbsp;安全退出
						    </a>
					    </li>
					  </ul>
					</div>
				</c:when>
				
				<c:otherwise>
					<!-- 按钮 -->
					<button type="button" class="btn btn-success btn-sm btm-me" data-toggle="modal" data-target="#myModal">
						登录
					</button>
					
					<!-- 对话框开始 -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					  <div class="modal-dialog" role="document">
					    
					    <div class="modal-content">
					    
					      <!-- 1.对话框标题 -->
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="myModalLabel">用户登录</h4>
					      </div>
					      
					      <!-- 2.对话框内容开始 -->
					      <div class="modal-body">
					        	
						     <form id="myform" action="${pageContext.request.contextPath}/usersAction/login" method="post">
								<div class="login-form login-form-me">
								
									<div class="form-group">
										<input name="u_name" type="text" class="form-control login-field" value="taylor"
											placeholder="用户名" id="login-name" /> 
										<label class="login-field-icon fui-user" for="login-name"></label>
									</div>
							
									<div class="form-group">
										<input name="u_pass" type="password" class="form-control login-field" value="123"
											placeholder="密码" id="login-pass" /> 
										<label class="login-field-icon fui-lock" for="login-pass"></label>
									</div>
									
									<a class="btn btn-primary btn-lg btn-block" href="javascript:validate()">登录</a> 
									<div class="login-bottom">
										<a class="login-link" href="#">忘记密码?</a>
										&nbsp;&nbsp;&nbsp;&nbsp;
										<a class="login-link" href="${pageContext.request.contextPath}/pages/users_register.jsp">注册</a>
									</div>
								</div>
							</form>
					        	
					      </div>
					      <!-- 2.对话框内容结束  -->
					      
					    </div>
					    
					  </div>
					</div>
					<!-- 对话框结束 -->
					
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<!-- ------------------------------------------网页顶部 结束------------------------------------------ -->
	<div class="profile-header">
		<div class="profile-header-inner">
			<div class="img-box">
				<c:choose>
					<c:when test="${not empty sessionScope.user.u_photo}">
						<img class="user-head-portrait" src="${pageContext.request.contextPath}/${sessionScope.user.u_photo}">
					</c:when>
					<c:otherwise>
						<img class="default-head-portrait" src="${pageContext.request.contextPath}/picture/headPortrait/default/user.jpg">
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="user-group">
				<span class="user-nane">${sessionScope.user.u_name}</span><br/>
				<span class="user-autograph">${sessionScope.user.u_autograph}</span>
			</div>
			
			<div class="profile-tools">
				<span class="glyphicon glyphicon-pencil compile-me"></span>
				<span class="glyphicon glyphicon-cog setting-me"></span>
				<span class="glyphicon glyphicon-picture picture-me"></span>
			</div>
		</div>
		
		<div id="profile-content">
			<div class="bs-example bs-example-tabs">
			  <div id="myTabContent" class="tab-content">
			  
			    <div role="tabpanel" class="tab-pane fade" id="compile-me" aria-labelledby="home-tab">
			    
			      <form id="form-update" action="${pageContext.request.contextPath}/usersAction/updateUsers" method="post">
			      	
			      	<div class="form-left">
			      	  <br/>
			      	  <input name="u_no" value="${sessionScope.user.u_no}" type="hidden">
					  <span>　用户名：</span><input class="input-me" name="u_name" type="text"value="${sessionScope.user.u_name}"/><br/><br/>
					  <span>　性　别：</span><input name="u_sex" type="radio" value="男"/>男
					  				   &nbsp;&nbsp;&nbsp;&nbsp;
					  				   <input name="u_sex" type="radio" value="女"/>女<br/><br/>
					  
					  <span>　年　龄：</span><input class="input-me" name="u_age" type="text" value="${sessionScope.user.u_age}"/><br/><br/>
					  <span>手机号码：</span><input class="input-me" name="u_phone" type="text" value="${sessionScope.user.u_phone}"/><br/><br/>
					  
					</div>
					
					<div class="form-middle">
						<br/>
						<span>个性签名：</span><textarea class="input-me" id="u_autograph" name="u_autograph" cols="30" rows="9"></textarea><br/><br/>		
						<br/>
					</div>
					
					<div class="form-right">
						<br/>
						<span>电子邮箱：</span><input class="input-me" name="u_email" type="text" value="${sessionScope.user.u_email}"/><br/><br/>
						<span><a href="javascript:form_update()">保存</a></span>
					</div>
					
			      </form>
			      
			    </div>
			    
			    <div role="tabpanel" class="tab-pane fade" id="setting-me" aria-labelledby="profile-tab">
			      	<form id="updatePass" action="" method="post">
			      			   <input type="hidden" name="u_no" value="${sessionScope.user.u_no}"/>
			      			   <input type="hidden" name="u_name" value="${sessionScope.user.u_name}"/>
			      			   
						<span>　旧密码：</span><input class="input-me" type="password" name="u_pass"/><br/><br/>
						<span>　新密码：</span><input class="input-me" type="password" id="psOne"/><br/><br/>
						<span>确认密码：</span><input class="input-me" type="password" name="newPassword" id="psTwo"/><br/><br/>
			      		<!-- <input type="submit" value="修改"> -->
			      		<span><a href="javascript:updaPass()">修改</a></span>
			      	</form>
			    </div>
			    
			    <!-- 图片 -->
				<div role="tabpanel" class="tab-pane fade active in" id="picture-me" aria-labelledby="profile-tab">
					
					<div class="bs-example bs-example-tabs">
						<ul id="myTab" class="nav nav-tabs" role="tablist">
						  <li role="presentation" class="active"><a href="#picture-control" id="picture-control-tab" role="tab" data-toggle="tab" aria-controls="picture-control" aria-expanded="false">图片管理</a></li>
						  <li role="presentation" class=""><a href="#picture-upload" role="tab" id="picture-upload-tab" data-toggle="tab" aria-controls="picture-upload" aria-expanded="true">上传</a></li>
						</ul>
						
						<div id="myTabContent" class="tab-content">
							
							<!-- 图片管理 -->
							<div role="tabpanel" class="tab-pane fade active in" id="picture-control" aria-labelledby="picture-control-tab">
							   <div>
							   		<ul id="finAllPicture"></ul>
								</div>
							</div>
							
							<!-- 上传图片 -->
							<div role="tabpanel" class="tab-pane fade" id="picture-upload" aria-labelledby="picture-upload-tab">
							  	<div class="container kv-main">
								    <br>
								    <form action="" method="post" enctype="multipart/form-data">
								        
								        <div class="form-group">
								            <input id="file-1" type="file" multiple class="file" data-overwrite-initial="false" data-min-file-count="2">
								        </div>
								        
								    </form>
								</div>
							</div>
							
						</div>
					</div>
					
					
			    </div>
			    
			  </div>
			</div>
		</div>
		<!-- 网页尾 -->
		<div id="webpage-offal">
			
		</div>
	</div>
	
	
	
	<script type="text/javascript">
	/* 个性签名 */
	var textobj =  document.getElementById('u_autograph');
	textobj.innerHTML = "${sessionScope.user.u_autograph}";
	
	/* 根据值选中radio */
	$(document).ready(function(){
		var sex = "${sessionScope.user.u_sex}";
        $(":radio[name='u_sex'][value='" + sex + "']").prop("checked", "checked");
	});  
	
	if("true"=="${result}"){
		alert("修改成功");
	}else if("false"=="${result}"){
		alert("修改失败");
	}
	/* 修改密码 */
	function updaPass(){
		if($("#psOne")[0].value == $("#psTwo")[0].value){
			$.ajax({
	        	cache: true,
		        type: "post",
		        url: "${pageContext.request.contextPath}/usersAction/updatePassword",
		        data:$('#updatePass').serialize(),
		        async: false,
		        error: function(request) {
		            alert("Connection error");
		        },
		        success: function(data) {
		        	alert("修改成功！");
		        }
		    });
			return;
		}else{
			alert("两次输入的密码不一致！");
			return;
		}
		alert("旧密码错误！");
	}
	
	/* 管理图片 */
	function loadDate(){
		$.post("${pageContext.request.contextPath}/pictureAction/findAllPicture?id=${sessionScope.user.u_no}","",function(data){
			$.each(data,function(i,v){
				
				var tr = "<li>";
					tr += "<div class='picture-div'>";
					tr += "<div class='picture-box'>";
					tr += "<img src='${pageContext.request.contextPath}/"+v[2]+"'>";
					tr += "</div>";
					tr += "<div class='description'>"+v[1]+"</div>";
					tr += "<div class='operations'>";
					
					tr +="<a href='#'>修改</a>";
					tr +="<a href='#'>删除</a>";
					
					tr +="</div>";
					tr += "</div>";
					tr += "</li>";
					
				$("#finAllPicture").append(tr);
			});
			
			
			$(".picture-div").mouseover(function(){
				$(this).children('.description').css({"margin-top":"-25px","position":"absolute","transition":".1s"});
				$(this).children('.operations').css({"margin-top":"-160px","position":"absolute","transition":".1s"});
			});
			$(".picture-div").mouseleave(function(){
				$(this).children('.description').css({"margin-top":"0px","position":"","transition":"0"});
				$(this).children('.operations').css({"margin-top":"0px","position":"","transition":"0"});
			});
			
		});
		
		
	}
	window.onload = loadDate();
	
	
	
	
	
	
	

	/* 图片上传插件 */
	$("#file-1").fileinput({
		
		// you must set a valid URL here else you will get an error
		uploadUrl: '${pageContext.request.contextPath}/pictureAction/uploadPicture',
	    allowedFileExtensions : ['jpg', 'png','gif'],
	    overwriteInitial: false,
	    maxFileSize: 10000,
	    maxFilesNum: 10,
	    //allowedFileTypes: ['image', 'video', 'flash'],
	    slugCallback: function(filename) {
	        return filename.replace('(', '_').replace(']', '_');
	    }
		
	});
	
	        
	
	</script>

	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/index.js"></script>
	
</body>
</html>