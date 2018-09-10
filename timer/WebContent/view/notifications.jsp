<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script> -->

<link rel="stylesheet" href="${ pageContext.request.contextPath}/css/notifications.css"/>
<title>Insert title here</title>
<style type="text/css">
	.container-fluid {
    	background: #2E2E2E;
	}
	
	.main_content{
		width: 920px;
		height:1200px;
		margin: 0 auto;
	}
	

	.right_content{
		width:640px;
		height:1000px;
		background-color: #FFF;
		float:right;
	
	}
	
	.footer_star{
		display: block;
		margin: 0 0 2em 0;
		border: 0;
    	font-size: 100%;
    	font: inherit;
    	vertical-align: baseline;
	}
	.footer_star li {
		float:right;
		list-style: none;
		
	
	} 
	.padding-dorder{
		padding-left: 5px;
		padding-right: 5px;
		padding-top: 10px;
		padding-bottom: 5px;
	}
	
	.message_list{
		list-style: none;
	
	}

	.message_list ul li img{
		margin-left: 10px;
		margin-bottom: 8px;
		width: 40px;
		height: 40px;
		color: #fff;
	}
	.message_list ul li span{
		color: #f16e50;
	}
	a{
		cursor: pointer;
	}
	.list-chat-item{
		cursor: pointer;
	}
	
		.jy_user_headimg{
		position: relative;
		width: 30px;
    	height: 30px;
    	float: left;
	}
	.jy_user_headimg a img{
		width:30px;
		height: 30px;
	}
	.list_con{
    	margin: 0 0 0 40px;
    	display: block;
    	
	}
	.jy_text{
		margin-bottom: 0;
		padding: 0 0 2px;
		overflow: hidden;
    	line-height: 23px;
    	word-wrap: break-word;
    	
	}
	.jy_text span{
		color: #eb7350;
	}
	.jy_text2{
		
	}
	.jy_text2 ul{
		list-style: none;
		display: block;
		margin-right: -9px;
    	overflow: visible;
	}
	.jy_text2 ul li {
		display: block;
		float:right;
		padding-right: 10px;
		margin: 0 -1px 0 0;
		cursor: pointer;
	}
	.list_on_in{
    	margin-top: 10px;
    	margin-bottom: 10px;
    	padding: 0 12px;
    	margin-left:5px;
		background-color: #F2F2F5;
	}
	.list_on_in .list_con{
		margin: 0 0 0 5px;
	}
	.WB_from {
    	margin-bottom: 0;
    	line-height: 22px;
	}
	.S_txt2{
    	color: #808080;
    	text-decoration: none;
    	font-size: 12px;
	}
	.S_line1 {
    	border-color: #d9d9d9;
    	margin: 0 0 -1px;
    	padding: 5px 0 7px;
    	border-bottom-width: 1px;
    	border-bottom-style: solid;
	}
	.write_reply_div{
		display: none;
		height: 100px;
	}
	.write_reply_div span{
		display: block;
		width: 100%;
		padding-top: 10px;
	}
	.old_content{
		display:block;
		width: 60%;
		background-color: #eaeaec;
		font-size: 14px;
		padding-left: 5px;
		padding-right: 5px;
		padding-top: 8px;
		padding-bottom: 8px;
		margin-left: 10px;
	}
	</style>
</head>
<body>
<div class="container-fluid">
<jsp:include page="./head.jsp"/>

<div class="main_content">
 
 <!-- 左侧菜单栏 -->
 <aside class="aside-left" style="margin-left: 0px;">
	<ul class="left-menu">
		<li class="left-menu-item"><a class="private_letter"><img alt="" src="${ pageContext.request.contextPath}/images/mail.png" class="img-responsive">私信&nbsp;&nbsp;<span class="badge" style="background-color: #FF0000;" id="private_badge"></span></a></li>
		<li class="left-menu-item"><a class="rece_comment"><img alt="" src="${ pageContext.request.contextPath}/images/message.png">评论&nbsp;&nbsp;<span class="badge" style="background-color: #FF0000;" id="comm_badge"></span></a></li>
		<li class="left-menu-item"><a class="rece_bottle"><img alt="" src="${ pageContext.request.contextPath}/images/delete.png" class="img-responsive">瓶子&nbsp;&nbsp;<span class="badge" style="background-color: #FF0000;" id="bottle_badge"></span></a></li>
		<li class="left-menu-item"><a class="rece_word"><img alt="" src="${ pageContext.request.contextPath}/images/bulb.png" class="img-responsive">留言&nbsp;&nbsp;<span class="badge" style="background-color: #FF0000;" id="word_badge"></span></a></li>
	</ul>   

 </aside>
 
 <input type="hidden" id="hidden_user_id" value="${user.userId}">
 
<div class="right_content">
 	<div class="main_mess_content">
 		<div>
 		<div>
    	<div class="h4">全部私信</div>
   		</div>
   		<span  role="separator" class="divider"></span>
    	<ul class="sixin-list list-group">
  		<li class="sinxin-list-item list-group-item">
  		<span class="item-user-info">
  		<img alt="" src="${ pageContext.request.contextPath}/images/default.gif" class="img-circle">
  		Tom
  		<span class="item-user-message">
  		哈哈，我是立哈哈
  		</span>
  		<div class="pull-right">
  			<div class="btn-group">
			<span type="button" class="btn" data-toggle="dropdown">20:10
			<span class="caret dropdown-toggle"></span>
			</span>
			<ul class="dropdown-menu" role="menu">
			<li><a href="#">删除</a></li>
			<li><a href="#">查看</a></li>
			</ul>
			</div>
  		</div>
  		</span>
  		</li>
  		
	</ul>
 	</div>
 	
 	</div>
 
</div>

</div>
<footer>
<div class="footavatar">
     <img src="${ pageContext.request.contextPath}/images/photo.jpg" class="footphoto img-responsive img-circle">
     <ul class="footinfo">
       <p class="fname"><a href="/dancesmile" >青轻飞扬</a>  </p>
       <p class="finfo">性别：女 年龄：25岁</p>
       <p>现居：四川成都</p>
       </ul>
   </div>
   <section class="visitor">
     <h2>最近访客</h2>
      <ul>
        <li><a href="/"><img src="${ pageContext.request.contextPath}/images/s0.jpg" class="img-responsive img-circle"></a></li>
        <li><a href="/"><img src="${ pageContext.request.contextPath}/images/s1.jpg" class="img-responsive img-circle"></a></li>
        <li><a href="/"><img src="${ pageContext.request.contextPath}/images/s2.jpg" class="img-responsive img-circle"></a></li>
        <li><a href="/"><img src="${ pageContext.request.contextPath}/images/s3.jpg" class="img-responsive img-circle"></a></li>
        <li><a href="/"><img src="${ pageContext.request.contextPath}/images/s5.jpg" class="img-responsive img-circle"></a></li>
        <li><a href="/"><img src="${ pageContext.request.contextPath}/images/s6.jpg" class="img-responsive img-circle"></a></li>
        <li><a href="/"><img src="${ pageContext.request.contextPath}/images/s7.jpg" class="img-responsive img-circle"></a></li>
        <li><a href="/"><img src="${ pageContext.request.contextPath}/images/s8.jpg" class="img-responsive img-circle"></a></li>
      </ul>
   </section>
   <div class="Copyright">
     <ul>
       <a href="/">帮助中心</a><a href="/">空间客服</a><a href="/">投诉中心</a><a href="/">空间协议</a>
     </ul>
     <p>Design by DanceSmile</p>
   </div>

</footer>

</div>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">

function getCommNum(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/timer/comment?method=getnotread",
		success:function(msg){
			console.log(msg);
			if (msg == 0){
				$("#comm_badge").html("");
			
			}else{
				$("#comm_badge").html(msg);
					
			}
			
		}
		
	});
}
var int1=self.setInterval("getCommNum()",5000);
function getPrivateNum(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/timer/privateletter?method=privatenotread",
		success:function(msg){
			console.log(msg);
			if (msg == 0){
				$("#private_badge").html("");
			
			}else{
				$("#private_badge").html(msg);
					
			}
			
		}
		
	});
}
var int1=self.setInterval("getPrivateNum()",5000);



	var commutoName = "";
	var commutoId = "";
	$(window).on('load', function () {
		$('.dropdown-toggle').dropdown()

	});
	function setChatList(){
		$.ajax({
			type:"GET",
			url:"http://localhost:8080/timer/chatrecord?method=getallchat",
			success:function(msg){
				//alert(msg);
				objarray = jQuery.parseJSON(msg);
				//alert(objarray);
				var allhtml = "<div><div class=\"h4\">全部私信</div></div>";
				for(var i = 0 ; i < objarray.length;i++){
					allhtml = allhtml + "<div class=\"list-chat-item\" crid=\""+objarray[i].crid+"\" commuto=\""+objarray[i].othername+"\" send=\""+objarray[i].send+"\" sendid=\""+objarray[i].sendid+"\" receiveid=\""+objarray[i].receiveid+"\"><span  role=\"separator\" class=\"divider\"></span><ul class=\"sixin-list list-group\">"+
					"<li class=\"sinxin-list-item list-group-item\"><span class=\"item-user-info\">"
					+"<img alt=\"\" src=\""+objarray[i].otherhead+"\" class=\"img-circle\">"
					+"<span style=\"padding-left: 5px;font-size:12px;\">"+objarray[i].othername+"</span><span></span>"
					+"<div class=\"pull-right\"><div class=\"btn-group\"><span type=\"button\" class=\"\" data-toggle=\"dropdown\">20:10"
					+"<span class=\"caret dropdown-toggle\"></span></span><ul class=\"dropdown-menu\" role=\"menu\">"
					+"<li><a href=\"javascript:;\">删除</a></li><li><a href=\"javascript:;\">查看</a></li></ul></div></div></span></li></ul></div>";
					
				}
				$(".main_mess_content").html(allhtml);
			}
			
		});
	}
	
	
	function setPrivateList(crid,myid){
		$.ajax({
			type:"GET",
			url:"http://localhost:8080/timer/privateletter?method=getallletter",
			data:"crid=" + crid,
			success:function(msg){
				//alert(msg);
				var objarray = jQuery.parseJSON(msg);
				var allhtml = "<div class=\"chat-top\"><a class=\"back-to-list\" href=\"javascript:;\">返回私信列表</a><b>与<a href=\"javascript:;\" target=\"_blank\">"+commutoName+"</a>的对话</b></div><div class=\"message-show\" id=\"message-show\" style=\"overflow:scroll; width:640px; height:400px;\"><ul class=\"message-list\">";
				for(var i = 0;i < objarray.length;i++){
					if (myid == objarray[i].senderId){
						allhtml = allhtml + "<li class=\"message-r\"><a href=\"javascript:;\" class=\"a_img\"><img alt=\"\" src=\""+objarray[i].sendimg+"\" class=\"img-circle\"></a><div>" +
						"<span class=\"content\">"+objarray[i].privateLetterContents+"</span></div></li>";
					}else{
						
						allhtml = allhtml + "<li class=\"message-l\"><a href=\"javascript:;\" class=\"a_img\"><img alt=\"\" src=\""+objarray[i].sendimg+"\" class=\"img-circle\"></a><div><span class=\"content\">"+objarray[i].privateLetterContents+"</span></div></li>";
						
					
					}
				}
				allhtml = allhtml + "</ul></div><div class=\"write-message\"><form action=\"javascript:;\">"+
				"<textarea type=\"text\" placeholder=\"输入内容\" class=\"form-control\" style=\"resize: none;\"></textarea>"+
				"<input type=\"submit\" class=\"btn btn-danger btn-send\" value=\"发送\" crid=\""+crid+"\" myid=\""+myid+"\"></form></div>";
				$(".main_mess_content").html(allhtml);
				var div = document.getElementById("message-show");
				//alert(div.scrollHeight);
				div.scrollTop=div.scrollHeight;
				
				
			}
			
		});
	}
	
	function setCommentList(){
		var userid = $("#hidden_user_id").val();
		$.ajax({
			type:"GET",
			url:"http://localhost:8080/timer/comment?method=getnotifi",
			success:function(msg){
				//alert(msg);
				var objarray = jQuery.parseJSON(msg);
				//console.log(msg);
				//alert(msg);
				var allhtml = "";
				for(var i = 0; i < objarray.length;i++ ){
					if (userid != objarray[i].commtorid){
						allhtml = allhtml + "<div class=\"list_on_in\"><div class=\"list_ul\"><div><div class=\"list_con\"><div class=\"jy_text\">";
						if (objarray[i].comm_type == "comm_comm"){
							allhtml = allhtml + "<span>"+objarray[i].commName+"评论了你</span>";
						}else if (objarray[i].comm_type == "comm_reply"){
							allhtml = allhtml + "<span>"+objarray[i].commName+"回复了你的评论</span>";
						}else{
							allhtml = allhtml + "<span>"+objarray[i].commName+"回复了你</span>";
						}
						allhtml = allhtml + ":" + objarray[i].commContent + "<span class=\"old_content\" style=\"color:#000000\"><span style=\"color:#eb7350\">"
						+objarray[i].myName+"</span>:"+objarray[i].content+"</span></div><div class=\"jy_text2\"><ul><li class=\"write_reply_reply\">回复</li></ul>"
						+"</div><div class=\"WB_from S_txt2\">"+objarray[i].commTime+"</div><div class=\"write_reply_div\"><span><textarea class=\"reply_content\" rows=\"2\" style=\"width:100%;border-color:#f16e50;overflow:hidden; resize:none;\" placeholder=\"回复吧!\"></textarea></span>"
						+"<span><button class=\"btn btn-danger right-button pull-right sendcommbtn\" commtype=\""+objarray[i].comm_type+"\" rootcommid=\""+objarray[i].commentid+"\" replyid=\""+objarray[i].id+"\" berepliedName=\""+objarray[i].commName+"\">发表</button></span></div></div></div></div></div>";
					}
					
					
				}
				$(".main_mess_content").html(allhtml);
				
				
				
			}
			
		});
	}
	function setBottleList(){
		$.ajax({
			type:"GET",
			url:"",
			data:"",
			success:function(msg){
				
			}
			
		});
	}
	function setWordList(){
		$.ajax({
			type:"GET",
			url:"",
			data:"",
			success:function(msg){
				
			}
			
		});
	}
	isreply_replyshow = false;
	$(function(){
		
		
		$(document).on("click",".write_reply_reply",function(){
			if (isreply_replyshow == false){
				$(this).parent().parent().next().next(".write_reply_div").show(1000);
				isreply_replyshow = true;
			}else{
				$(this).parent().parent().next().next(".write_reply_div").hide(1000);
				isreply_replyshow = false;
			}
			
			
		});
		
		//回复类型为回复
		$(document).on("click",".sendcommbtn",function(){
			var type = $(this).attr("commtype");
			var replyid = "";
			var real_type = "";
			if (type == "comm_comm"){
				replyid = $(this).attr("rootcommid");
				real_type = "reply_comm";
			}else{
				replyid = $(this).attr("replyid");
				real_type = "reply_repl";
			}
			var reply_content = $(this).parent().prev().children(".reply_content").val();
			//alert();
			var rootcomid = $(this).attr("rootcommid");
			
			var berepliedName = $(this).attr("berepliedName");
			reply_content = reply_content.trim();
			if (reply_content == ""){
				alert("回复内容不能为空");
				return false;
			}
			$.ajax({
				tyep:"POST",
				url:"http://localhost:8080/timer/comment?method=addreply",
				data:"type="+real_type+"&reply_content=" +reply_content +"&replyid=" +replyid +"&berepliedName=" +berepliedName +"&rootcomid=" +rootcomid,
				success:function(msg){
					alert(msg);
					//getAllComments(8);
					setCommentList();
				}
				
			});
			
			
			//alert(berepliedName);
		});
		
		
		setChatList();
		//$("#private_badge").html("10");
		//setCommentList();
		$.ajax({
			type:"",
			url:"",
			success:function(msg){
				
			}
			
		});
		
		$(document).on("click",".btn-send",function(){
			//alert(11);
			var letter = $(this).prev().val();
			letter = letter.trim();
			var lmyid = $(this).attr("myid");
			var crid = $(this).attr("crid");
			//alert("我的id" + lmyid);
			if (letter == ""){
				alert("不能发空的消息");
				return;
			}else{
				$.ajax({
					type:"POST",
					url:"http://localhost:8080/timer/privateletter?method=saveletter",
					data:"sendid=" +lmyid +"&acceptid="+commutoId+"&content=" + letter +"&crid="+crid,
					success:function(msg){
						if (msg == ""){
							setPrivateList(crid,lmyid);
						}else{
							alert(msg);
						}
					}
					
				});
				
			}
			
			
			
			
		});
		
		$(document).on("click",".back-to-list",function(){
			setChatList();
		});
		
		$(document).on("click",".list-chat-item",function(){
			//alert(555);
			var crid = $(this).attr("crid");
			//alert(crid);
			commutoName = $(this).attr("commuto");
			var send = $(this).attr("send");
			var myid ="";
			if (send == "false"){
				myid = $(this).attr("receiveid");
				commutoId = $(this).attr("sendid");
			}else{
				myid = $(this).attr("sendid");
				commutoId = $(this).attr("receiveid");
			}
			setPrivateList(crid,myid);
		});
		
		
		$(document).on("click",".private_letter",function(){
			setChatList();
			
		});
		$(document).on("click",".rece_comment",function(){
			setCommentList();
			
		});
		$(document).on("click",".rece_bottle",function(){
	
	
		});
		$(document).on("click",".rece_word",function(){
	
	
		});

	});


</script>
</html>