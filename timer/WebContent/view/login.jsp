<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>剪影</title>
<meta name="keywords" content="剪影">
<meta name="content" content="剪影">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<link type="text/css" rel="stylesheet" href="${ pageContext.request.contextPath}/css/login.css">
<script type="text/javascript" src="${ pageContext.request.contextPath}/js/jquery-1.8.1.min.js"></script>
</head>
<style type="text/css">
/* .login_bj{ background:url(${pageContext.request.contextPath}/images/background.jpg) no-repeat top center;}
 */
</style>
<body class="login_bj" >
<div class="zhuce_body">
	<!-- 剪影logo -->
	<!-- <div class="logo"><a href="#"><img src="images/logo.png" width="114" height="54" border="0"></a></div> -->
    <div class="zhuce_kong login_kuang">
    	<div class="zc">
        	<div class="bj_bai">
            <h3>登录</h3>
       	  	  <form method="POST" action="${pageContext.request.contextPath}/user" id="login-form">
       	  	  	<input name="method" value="login" type="hidden"/>
                <input name="username" type="text" class="kuang_txt" placeholder="账号">
                <input name="password" type="password" class="kuang_txt" placeholder="密码">
                <div>
               		<a href="#">忘记密码？</a><input name="" type="checkbox" value="" checked><span>记住我</span> 
                </div>
                <input name="loginbtn" type="button" class="btn_zhuce" value="登录">
                
                </form>
            </div>
        	<div class="bj_right">
            	<p>使用以下账号直接登录</p>
                <a href="#" class="zhuce_qq">QQ登录</a>
                <a href="#" class="zhuce_wb">微博登录</a>
                <a href="#" class="zhuce_wx">微信登录</a>
                <p>没有有账号？<a href="${pageContext.request.contextPath}/view/register.jsp">立即注册</a></p>
            
            </div>
        </div>
        <P>52moment.com&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎登录剪影</P>
    </div>

</div>
<script type="text/javascript">
	$(function(){
		
		$("input[name='loginbtn']").click(function(){
			var username = $("input[name='username']").val();
			var password = $("input[name='password']").val();
			username = username.trim();
			password = password.trim();
			if (username == "" || password == ""){
				alert("用户名或密码不能为空");
				return;
			}
			
			
			alert($("#login-form").submit());
			
		});
		
	});

</script>
</body>

</html>