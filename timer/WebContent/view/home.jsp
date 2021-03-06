<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script> -->
<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/dist/amazeui.min.css" />

<title>Insert title here</title>
<!-- 
上传头像
 -->

<style type="text/css">
	.container-fluid {
    	background: #2E2E2E;
	}
	#clip {
		width: 100%;
		height: 400px;
	}
	.head_bg{
		width: 920px;
		height: 400px;
		background-image: url(${pageContext.request.contextPath}/images/head_bg.jpg);
		margin: 0 auto;
	}
	.head{
		margin: 0 auto;
		height: 110px;
		width: 110px;
		padding-top: 70px;
		cursor: pointer;
	}
	.main_content{
		width: 920px;
		height:1600px;
		margin: 0 auto;
	}
	.user_name{
		margin: 0 auto;
		display: block;
		color: #FFF;
		font-size: 22px;
		text-align: center;
		cursor: pointer; 
	}
	.user_signal_message{
		margin: 0 auto;
		display: block;
		color: #FFF;
		font-size: 12px;
		text-align: center;
		cursor: pointer;
	}
	.head_nav{
		width: 920px;;
		background-color: #000;
		height: 40px;
		margin:0 auto;
		margin-top: 10px;
		margin-bottom: 10px;
	}
	.head_nav .nav_list{
		list-style: none;
		display:block;
		margin: 0 auto;
		height: 40px;
		width: 90%;
	}
	.head_nav .nav_list li{
		display:block;
		float: left;
		width:33%;
		height: 40px;
		text-align: center;
		line-height: 40px;
		color: #fff;
	}
	.head_nav .nav_list li a{
		cursor: pointer;
		text-decoration:none;
		color: #fff;
	}
	
	.head_nav .nav_list li a:hover{
		cursor: pointer;
		text-decoration:none;
		color: #eb7350;
	}
	.head_nav .nav_list li .tab1{
		display:block;
		height: 2px;
		width: 80px;
		background-color: #eb7350;
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
	.write-comment{
		display: none;
		height: 100px;
	}
	.write-comment span{
		display: block;
		width: 100%;
		padding-top: 10px;
	}
	.write-comment .right-button{
		/* float:right; */
		
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
    	margin-left:30px;
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
	.reply_list{
		display:none;
	
	}
	a{
		text-decoration: none;
	}
	a:hover{
		text-decoration: none;
	}	
	</style>
</head>
<body>
<div class="container-fluid">
<jsp:include page="./head.jsp"/>
<div class="head_content">
<div class="head_bg">





<input type="hidden" value="${myuser.userId}" id="myuserid"> 
<div class="head">
	<img alt="" src="${myuser.headPicture}" class="img-responsive img-circle updateimg" id="toggle-file">
	<span class="user_name">${myuser.username}</span>
	<span class="user_signal_message">${myuser.signature}</span>
</div>

</div>
<div class="head_nav">
<ul class="nav_list">
	<li><a href="${ pageContext.request.contextPath}/user?method=myinfo">我的主页</a>
	<span class="tab1"></span>
	</li>
	<li><a href="${ pageContext.request.contextPath}/view/album.jsp">我的相册</a>
	<span class=""></span>
	</li>
	<li><a>管理中心</a>
	<span class=""></span>
	</li>
</ul>

</div>

</div>
<div class="main_content">
 <aside class="aside-left" style="margin-left: 0px;">
       <div class="userinfo"> 
       <p class="q-fans"> <a href="/" target="_blank">粉丝：${myuser.fansNum}</a></p>
       <p class="q-fans"> <a href="/" target="_blank">关注：${myuser.focusNum }</a></p>
       <p class="btns"><a href="/" target="_blank" ></a><a href="/" target="_blank">留言板</a><a href="/" target="_blank">收藏</a><a href="/" target="_blank">时光瓶</a></p>   
      </div>
      <section class="topspaceinfo">
        
        <p class="small">${myuser.signature}</p>
      </section>
     
      <section class="newpic">
         <h2>最新照片</h2>
         <ul>
         <c:forEach var="img" items="${myuser.imgs}">
			<li><a href="/"><img src="${img.imgUrl}" class="img-responsive"></a></li>
		 </c:forEach>
           <%-- <li><a href="/"><img src="${ pageContext.request.contextPath}/images/01.jpg"></a></li>
           <li><a href="/"><img src="${ pageContext.request.contextPath}/images/02.jpg"></a></li>
           <li><a href="/"><img src="${ pageContext.request.contextPath}/images/03.jpg"></a></li>
           <li><a href="/"><img src="${ pageContext.request.contextPath}/images/04.jpg"></a></li>
           <li><a href="/"><img src="${ pageContext.request.contextPath}/images/05.jpg"></a></li>
           <li><a href="/"><img src="${ pageContext.request.contextPath}/images/06.jpg"></a></li>
           <li><a href="/"><img src="${ pageContext.request.contextPath}/images/07.jpg"></a></li>
           <li><a href="/"><img src="${ pageContext.request.contextPath}/images/08.jpg"></a></li> --%>
         </ul>
      </section>
      <section class="taglist">
         <h2>全部标签</h2>
         <ul>
         <c:forEach var="intern" items="${myuser.intersts}">
         	<li><a href="/"><span class="label label-warning">${intern.interstName}</span></a></li>
         </c:forEach>
          <!--  <li><a href="/"><span class="label label-warning">旅游</span></a></li>
           <li><a href="/"><span class="label label-warning">美食</span></a></li>
           <li><a href="/"><span class="label label-warning">运动</span></a></li>
           <li><a href="/"><span class="label label-warning">技术宅 </span></a></li> -->
        </ul>
      </section>
    </aside>
    <div class="right_content">
    <div id="blog-img-txt">
    <div class="col-sm-12 col-md-12" style="padding-top: 10px;margin:0 auto">
    <div class="thumbnail">
      <img src="${ pageContext.request.contextPath}/images/pic01.jpg" alt="..." class="img-responsive">
      <div class="caption">
      <div>
      <img alt="" src="${ pageContext.request.contextPath}/images/avatar.jpg" class="img-responsive img-circle" style="display: inline-block;">
       <span>Tom</span>
      </div>
       <div>
       	<p class="small padding-dorder">我的小鱼你醒了,还认识早晨吗?昨夜你曾经说,愿夜幕永不开启。
       	你的香腮边轻轻滑落的，
		是你的泪，还是我的泪？
		初吻吻别的那个季节，
		不是已经哭过了吗？
		我的指尖还记忆着，
		你慌乱的心跳。
		温柔的体香里，
		那一缕长发飘飘。
       	</p>
       </div>
      <div class="footer_star">
		<ul class="stats">
		<li><a href="#" class=""><span class="glyphicon glyphicon-heart"></span>10&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
		<li><a href="#" class=""><span class="glyphicon glyphicon-comment"></span>128&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
		<li><a href="#" class=""><span class="glyphicon glyphicon-thumbs-up"></span>152&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
		</ul>
	 </div>
      </div>
    </div>
  </div>
    </div>
    
    <!-- 分页功能 -->
    <div class="col-md-12 col-md-offset-3">
  <nav aria-label="Page navigation">
  		<ul class="pagination" id="txtnavation">
    		<li>
      		<a href="#" aria-label="Previous">
        	<span aria-hidden="true">&laquo;</span>
      		</a>
    	</li>
    	<li><a href="#">1</a></li>
    	<li><a href="#">2</a></li>
    	<li><a href="#">3</a></li>
    	<li><a href="#">4</a></li>
    	<li><a href="#">5</a></li>
    	<li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
  
  </div>
    
    
    </div>

</div>
<footer>
<div class="footavatar">
     <img src="${ pageContext.request.contextPath}/images/photo.jpg" class="footphoto img-responsive img-circle">
     <ul class="footinfo">
       <p class="fname"><a href="/dancesmile" >青轻飞扬</a>  </p>
       <p class="finfo">性别：女 年龄：25岁</p>
       <p>现居：四川成都</p></ul>
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




<div class="container">
<div class="am-popup" id="my-popup">
			<div class="am-popup-inner">
				<div class="am-popup-hd">
					<h4 class="am-popup-title">裁剪图片</h4>
					<span data-am-modal-close class="am-close">&times;</span>
				</div>
				<div class="am-popup-bd">
					<!-- 裁剪显示区 -->
					<div class="am-margin-bottom-sm" id="clip"></div>

					<button type="button" class="am-btn am-btn-primary" id="clipBtn">
						上传
					</button>

					<input class="am-hide" type="file" id="myfile">
				</div>
			</div>
</div>
</div>

<input type="hidden" name="imagebase64" id="imgbase" value="">


</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/comments.js"></script>
<script src="${pageContext.request.contextPath}/dist/amazeui.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/dist/iscroll-zoom.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/dist/hammer.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/dist/photoClip.min.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">


//上传头像
	var nowNum = 1;
var singalPage = 1;
function pareJsonToHtml(txtarray){
	//alert(txtarray);
	var allhtml = "";
	for (var i = 0;i < txtarray.length;i++){
		allhtml = allhtml + "<div class=\"col-sm-12 col-md-12\" style=\"padding-top: 10px;margin:0 auto\"><div class=\"thumbnail\">"
		+"<img src=\"" + txtarray[i].imgUrl + "\" alt=\"...\" class=\"img-responsive\"><div class=\"caption\"><div><a href=\"${pageContext.request.contextPath}/user?method=info&userid="+txtarray[i].sendId+"\"><img alt=\"\" src=\""
		+ txtarray[i].userImg + "\" class=\"img-responsive img-circle userimg\" style=\"display: inline-block;width:35px;height:35px;\"></a><span>" + txtarray[i].username + "</span></div><div><p class=\"small padding-dorder\">"+
		txtarray[i].text+"</p></div><div class=\"footer_star\"><ul class=\"stats\"><li><a href=\"javascript:;\" class=\"collection_num\" thisimgid=\""+txtarray[i].imgTxtId+"\" iscollection=\""+txtarray[i].isCollection+"\"><span class=\"glyphicon glyphicon-heart\"></span><span class=\"collectionNum\">"+
		txtarray[i].collectionNum+"</span>&nbsp;&nbsp;&nbsp;&nbsp;</a></li><li><input type=\"hidden\" class=\"imgtxtid\" name=\"imgtxtid\" value=\""+txtarray[i].imgTxtId+"\"><a href=\"javascript:;\" class=\"comment_num\"><span class=\"glyphicon glyphicon-comment\"></span><span>"+txtarray[i].commNum+"</span>&nbsp;&nbsp;&nbsp;&nbsp;</a></li>"+
		"<li><a href=\"javascript:;\" class=\"laud_num\" islaud=\""+txtarray[i].laud+"\" thisimgid=\""+txtarray[i].imgTxtId+"\"><span class=\"glyphicon glyphicon-thumbs-up\"></span><span class=\"laudnum\">"+txtarray[i].laudNum+"</span>&nbsp;&nbsp;&nbsp;&nbsp;</a></li></ul></div></div>"+
		
		" <div class=\"write-comment\"><span><input type=\"hidden\" name=\"imgtxtid\" value=\""+txtarray[i].imgTxtId+"\" class=\"imgtxtid\"></span><span><textarea class=\"comment_content\" rows=\"2\" style=\"width:100%;border-color:#f16e50;overflow:hidden; resize:none;\" placeholder=\"发表你的评论吧!\"></textarea></span>"
		+"<span><button class=\"btn btn-danger right-button pull-right sendcommbtn\">发表</button></span></div>"+"<div style=\"\" class=\"reply_list\"></div>"+"</div></div>";
	}
	$("#blog-img-txt").html(allhtml);
	
}
function setImgTxtHtml(pageNum){
	var userid = $("#myuserid").val();
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/timer/imgtxt?method=gettaimgtxt",
		data:"pageNum=" + pageNum +"&userid=" + userid,
		success:function(msg){
			//alert(msg);
			txtarray = jQuery.parseJSON(msg);
			pareJsonToHtml(txtarray);
		}
		
	});
	
}
function setPageNum(num){
		singalPage = num / 3;
		if (singalPage < 1){
			singalPage = 1;
		}
		var pagehtml = "<li><a href=\"javascript:;\" aria-label=\"Previous\" id=\"prevpage\" onclick=\"setpre()\"><span aria-hidden=\"true\">&laquo;</span></a></li>";
		for (var i = 1;i <= singalPage;i++){
			if (i == 1){
				pagehtml = pagehtml + "<li class=\"active\"><a href=\"javascript:;\">1</a></li>";
			}else{
				pagehtml = pagehtml + "<li><a href=\"javascript:;\">" + i + "</a></li>";
			}
			
			
			
		}
		pagehtml = pagehtml+"<li><a href=\"javascript:;\" aria-label=\"Next\" id=\"nextpage\" onclick=\"setnext()\"><span aria-hidden=\"true\">&raquo;</span></a></li>";
		
		$("#txtnavation").html(pagehtml);
		
	}
	
	function setpre (){
	//alert(111111);
	if (nowNum > 1){
		nowNum = nowNum - 1;
	}
	setImgTxtHtml(nowNum);
	
}
	function setnext(){
	//alert(211111);
	if (nowNum < singalPage){
		nowNum = nowNum + 1;
	}
	setImgTxtHtml(nowNum);
	
	}
	
	var isWrittenShow = false;
	
	$(function(){
		var userid = $("#myuserid").val();
		setImgTxtHtml(nowNum);
		$.ajax({
			type:"GET",
			url:"http://localhost:8080/timer/imgtxt?method=gettacount",
			data:"userid=" + userid,
			success:function(msg){
				//alert(msg);
				if (msg != null && msg != ""){
					//alert(msg);
					var obj = jQuery.parseJSON(msg);
					//$("#fansnum").text("粉丝：" + obj.fans);
					setPageNum(obj.nums);
					
				}
				
			}
			
	});
		
		$(document).on("click",".collection_num",function(){
			//alert(666);
			var objthis = $(this);
			var imgtxtid = $(this).attr("thisimgid");
			var iscollection = $(this).attr("iscollection");
			var objcollection = $(this).children(".collectionNum");
			//alert(objcollection.val() + "" + objcollection.html());
			if (iscollection == "false"){
				$.ajax({
					type:"POST",
					url:"http://localhost:8080/timer/collection?method=addcollection",
					data:"imgtxtid=" +imgtxtid ,
					success:function(msg){
						if (msg != ""){
							alert("收藏成功");
							objthis.attr("iscollection","true");
							objcollection.html(msg);
						}else{
							alert("收藏失败");
						}
					}
				});
			}else{
				alert("亲您已经收藏过了");
			}
			
			
		});
		$(document).on("click",".comment_num",function(){
			//alert($(this).html());
			if (isWrittenShow == false){
				$(this).parent().parent().parent().parent().next(".write-comment").show(1000);
				//alert();
				var imgtxtid = $(this).prev(".imgtxtid").val();
				getAllComments(imgtxtid);
				$(this).parent().parent().parent().parent().next().next(".reply_list").show(1000);
				//$(".reply_list").show(1000);
				isWrittenShow = true;
			}else{
				$(this).parent().parent().parent().parent().next(".write-comment").hide(1000);
				$(this).parent().parent().parent().parent().next().next(".reply_list").hide(1000);
				isWrittenShow = false;
			}
			
		//var id = $(this).find("input").val();
		//$(location).attr("href","http://localhost:8080/MakeFriends/info?id="+id);
		
	});
		$(document).on("click",".laud_num",function(){
			var laudnum = 0;
			var imgtxtid = $(this).attr("thisimgid");
			//alert($(this).children(".laudnum").html("2123"));
			var islaud = $(this).attr("islaud");
			//alert($(this).children(".laudnum").html(""));
			//alert(islaud);
			var objlaudnum = $(this).children(".laudnum");
		//$(this).attr("islaud","true");
			var objthis = $(this);
		if (islaud == "false"){
				$.ajax({
	   				type:"POST",
	   				url:"http://localhost:8080/timer/imgtxt?method=addlaud",
	   				data:"imgtxtid=" + imgtxtid,
	   				success:function(msg){
	   					alert("点赞成功");
	   					objlaudnum.html(msg);
	   					objthis.attr("islaud","true");
	   					//alert(msg);
	   					console.log("" + $(this).children(".laudnum").val());
	   				}
	   				
	   			});
			}else{
				console.log("" + $(this).children(".laudnum").text());
				alert("已点了赞了亲");
			}
			
			//alert($(this).attr("thisimgid"));
			//alert($(this).attr("islaud"));
			
		});
		$(document).on("click",".sendcommbtn",function(){
			//console.log($(this).parent().prev().children(".comment_content").val());
			var comm_content = $(this).parent().prev().children(".comment_content").val();
			var imgtxtid = $(this).parent().prev().prev().children().val();
			comm_content = comm_content.trim();
			if (comm_content != ""){
				$.ajax({
					type:"POST",
					url:"http://localhost:8080/timer/comment?method=addcomm",
					data:"imgtxtid=" +imgtxtid +"&comm_content="+comm_content,
					success:function(msg){
						alert(msg);
						$(this).parent().prev().children(".comment_content").attr("value","");
						getAllComments(imgtxtid);
					}
				});
			}else{
				alert("评论不能为空");
			}
			//console.log($(this).parent().prev().prev().children().val());
			//$(this).parent().parent().pre(".comment_content").html();
		//var id = $(this).find("input").val();
		//$(location).attr("href","http://localhost:8080/MakeFriends/info?id="+id);
		
	});
		
		
		//上传图片
		var $clip = $("#clip");
		var $file = $("#myfile");
		var $imgView = $("#img-view");
		var $popup = $("#my-popup");
		$("#toggle-file").click(function() {
			$file.trigger("click");
			$popup.modal({
				closeViaDimmer: false
			});
		});

		$clip.photoClip({
			width: 200,
			height: 200,
			fileMinSize: 20,
			file: $file,
			ok: "#clipBtn",
			loadStart: function() {
				console.log("照片读取中");
			},
			loadProgress: function(progress) {
				console.log(progress);
			},
			loadError: function() {
				console.log("图片加载失败");
			},
			loadComplete: function() {
				console.log("照片读取完成");
			},
			imgSizeMin: function(kbs) {
				console.log(kbs, "上传图片过小");
			},
			clipFinish: function(dataURL) {
				//document.getElementById("img-view").src = dataURL;
				//alert(dataURL);
				$("#imgbase").attr("value",dataURL);
				$.ajax({
					type:"POST",
					url:"http://localhost:8080/timer/user?method=uploadimg",
					data:"imgdata=" + dataURL,
					success:function(msg){
						alert(msg);
					}
				});
				$popup.modal("close");
			}
		});
			
		
		
	});


</script>


</html>