//用户 点击弹框，失去焦点隐藏
function validate(){
  document.getElementById('myform').submit();
}
//图片分类 鼠标经过弹框，鼠标离开隐藏
$(".navigationBar-ul #classify-me").mouseenter( function() {
	$("#classify-me .btn-group").addClass("open");
});
$(".navigationBar-ul #classify-me").mouseleave( function() {
		$("#classify-me .btn-group").removeClass("open");
});

/*users_info 页面*/
$(".compile-me").click( function() {
	$("#compile-me").addClass("active in");
	$("#setting-me").removeClass("active in")
	$("#picture-me").removeClass("active in")
	
	$(".compile-me").css({"color": "#fff"});
	$(".setting-me").css({"color": "#ccc"});
	$(".picture-me").css({"color": "#ccc"});
});

$(".setting-me").click( function() {
	$("#compile-me").removeClass("active in");
	$("#setting-me").addClass("active in")
	$("#picture-me").removeClass("active in")
	
	$(".compile-me").css({"color": "#ccc"});
	$(".setting-me").css({"color": "#fff"});
	$(".picture-me").css({"color": "#ccc"});
});

$(".picture-me").click( function() {
	$("#compile-me").removeClass("active in");
	$("#setting-me").removeClass("active in")
	$("#picture-me").addClass("active in")
	
	$(".compile-me").css({"color": "#ccc"});
	$(".setting-me").css({"color": "#ccc"});
	$(".picture-me").css({"color": "#fff"});
	
});


/*保存修改*/

function form_update(){
	document.getElementById('form-update').submit();
}
/*users_info 页面*/
