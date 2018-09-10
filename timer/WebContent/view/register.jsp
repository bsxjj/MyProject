<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>剪影</title>
	<meta name="keywords" content="盒老师">
	<meta name="content" content="盒老师">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <link type="text/css" rel="stylesheet" href="${ pageContext.request.contextPath}/css/login.css">
    <script type="text/javascript" src="${ pageContext.request.contextPath}/js/jquery-1.8.1.min.js"></script>

	<style type="text/css">
		.disablecolor{
			background-color: #C0C0C0;
		}
	
	</style>
</head>
<body class="login_bj" >

<div class="zhuce_body">
	<!-- <div class="logo"><a href="#"><img src="images/logo.png" width="114" height="54" border="0"></a></div> -->
	
    <div class="zhuce_kong">
    	<div class="zc">
        	<div class="bj_bai">
            <h3>欢迎注册</h3>
       	  	  <form action="${pageContext.request.contextPath}/user?method=register" method="post"  id="register-form">
          
                <input name="username" type="text" class="kuang_txt phone" placeholder="账号">
                <span id="tip"></span>
                <input name="email" type="email" class="kuang_txt email" placeholder="邮箱">
                <span id="tip2"></span>
                <input name="password" type="password" class="kuang_txt possword" placeholder="密码">
                <input name="verifycode" type="text" class="kuang_txt yanzm" placeholder="输入验证码">
                <div>
                	<input type="button" class="btn_zhuce verifysend" value="发送验证码" onclick="sendMessage()">
                </div>
                <div>
               		<input name="agree" type="checkbox" value=""><span>已阅读并同意<a href="#" target="_blank"><span class="lan">《剪影用户协议》</span></a></span>
                </div>
                <input name="register" type="button" class="btn_zhuce" value="注册">
                
                </form>
            </div>
        	<div class="bj_right">
            	<p>使用以下账号直接登录</p>
                <a href="#" class="zhuce_qq">QQ注册</a>
                <a href="#" class="zhuce_wb">微博注册</a>
                <a href="#" class="zhuce_wx">微信注册</a>
                <p>已有账号？<a href="${ pageContext.request.contextPath}/view/login.jsp">立即登录</a></p>
            
            </div>
        </div>
        <P>52moment.com&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您注册剪影</P>
    </div>

</div>
    

</body>
<script type="text/javascript">
var InterValObj; //timer变量，控制时间 
var count = 180; //倒计时总时间 
var curCount; //当前剩余秒数 
var code = ""; //验证码 
var codeLength = 6; //验证码长度 


function sendMessage(){
	curCount = count;
	var emailNum = $("input[name='email']").val();
	emailNum = emailNum.trim();
	if (emailNum == ""){
		alert("请先填写邮箱");
		return;
	}
	if (!validateEmail(emailNum)){
		alert("邮箱格式不正确");
		return ;
	}
	if (emailNum != null){
		$(".verifysend").attr("disabled","true");
		$(".verifysend").val("请在" + curCount + "秒内输入");
		InterValObj = window.setInterval(SetRemainTimes, 1000);
		$.ajax({
			type:"POST",
			url:"http://localhost:8080/timer/user?method=sendmail",
			data:"email="+emailNum,
			success:function(msg){
				if(msg != ""){
					code = msg;
				}else{
					alert("邮件发送失败");
				}
				
			}
			
		});
	}
	
	
	
}
function SetRemainTimes() {
    if(curCount == 0) {
       window.clearInterval(InterValObj); //停止计时器 
       $(".verifysend").removeAttr("disabled"); //启用按钮 
       $(".verifysend").val("重新发送验证码");
       //code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效   
    } else {
       curCount--;
       $(".verifysend").val("请在" + curCount + "秒内输入");
    }
 }
function validateEmail(email){
	var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
	if (!reg.test(email)){
		
		return false;
	}
	return true;
	
}
$(function(){
	$("input[name='username']").blur(function(){
		var uname = $("input[name='username']").val();
		uname = uname.trim();
		$.ajax({
			type:"POST",
			url:"http://localhost:8080/timer/user?method=valiuser",
			data:"username="+uname,
			success:function(msg){
				if(msg != ""){
					$("#tip").text(msg);
					$("#tip").css({"display":"block","color":"#FF0000"});
					$("input[name='register']").attr("disabled","true");
				}
				
			}
			
		});
		
	});
	$("input[name='username']").keydown(function(){
		$("#tip").css("display","none");
		$("input[name='register']").removeAttr("disabled"); //启用按钮 
		
		
	});
	$("input[name='email']").blur(function(){
		var uemail = $("input[name='email']").val();
		if (!validateEmail(uemail)){
			$("#tip2").text("邮箱格式不正确·");
			$("#tip2").css("display","block");
			$("input[name='register']").attr("disabled","true");
			return;
		}
		uemail = uemail.trim();
		$.ajax({
			type:"POST",
			url:"http://localhost:8080/timer/user?method=valiemail",
			data:"email=" + uemail,
			success:function(msg){
				if(msg != ""){
					$("#tip2").text(msg);
					$("#tip2").css("display","block");
					$("input[name='register']").attr("disabled","true");
				}
				
			}
			
		});
	});
	$("input[name='email']").keydown(function(){
		$("#tip").css("display","none");
		$("input[name='register']").removeAttr("disabled"); //启用按钮 
		
		
	});
	
	
	$("input[name='register']").click(function(){
		
		var username = $("input[name='username']").val();
		username = username.trim();
		var password = $("input[name='password']").val();
		var email = $("input[name='email']").val();
		var verifycode = $("input[name='verifycode']").val();
		password = password.trim();
		email = email.trim();
		verifycode = verifycode.trim();
		
		if ($("input[name='agree']").is(":checked")){
			if (username == "" || password == "" || email == "" || verifycode == ""){
				alert("信息不能为空");
			}else{
				if (code == verifycode){
					alert(555);
					$("#register-form").submit();
				}else{
					alert("验证码不正确");
					return false;
				}
			}
		}else{
			alert("请阅读协议并勾选");
		}
		
	});
		
});

</script>

</html>