<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${ pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${ pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	.container-fluid {
    	background: #2E2E2E;
	}
	.head_bg{
		width: 920px;
		height: 400px;
		background-image: url(../images/head_bg.jpg);
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
		height:1200px;
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
	
	</style>
</head>
<body>
<div class="container-fluid">
<jsp:include page="./head.jsp"/>
<div class="head_content">
<div class="head_bg">

<div class="head">
	<img alt="" src="${ pageContext.request.contextPath}/images/default_up.gif" class="img-responsive img-circle updateimg">
	<span class="user_name">Tomc</span>
	<span class="user_signal_message">我的小鱼你醒了吗</span>
</div>

</div>
<div class="head_nav">
<ul class="nav_list">
	<li><a href="${ pageContext.request.contextPath}/user?method=myinfo">我的主页</a>
	<span class=""></span>
	</li>
	<li><a href="${ pageContext.request.contextPath}/view/album.jsp">我的相册</a>
	<span class="tab1"></span>
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
       <p class="q-fans"> <a href="/" target="_blank">粉丝：167</a></p>
       <p class="q-fans"> <a href="/" target="_blank">关注：167</a></p>
       <p class="btns"><a href="/" target="_blank" ></a><a href="/" target="_blank">留言板</a><a href="/" target="_blank">收藏</a><a href="/" target="_blank">时光瓶</a></p>   
      </div>
      <section class="topspaceinfo">
        
        <p class="small">于千万人之中，我遇见了我所遇见的人....</p>
      </section>
     
      <section class="newpic">
         <h2>最新照片</h2>
         <ul>
           <li><a href="/"><img src="${ pageContext.request.contextPath}/images/01.jpg"></a></li>
           <li><a href="/"><img src="${ pageContext.request.contextPath}/images/02.jpg"></a></li>
           <li><a href="/"><img src="${ pageContext.request.contextPath}/images/03.jpg"></a></li>
           <li><a href="/"><img src="${ pageContext.request.contextPath}/images/04.jpg"></a></li>
           <li><a href="/"><img src="${ pageContext.request.contextPath}/images/05.jpg"></a></li>
           <li><a href="/"><img src="${ pageContext.request.contextPath}/images/06.jpg"></a></li>
           <li><a href="/"><img src="${ pageContext.request.contextPath}/images/07.jpg"></a></li>
           <li><a href="/"><img src="${ pageContext.request.contextPath}/images/08.jpg"></a></li>
         </ul>
      </section>
      <section class="taglist">
         <h2>全部标签</h2>
         <ul>
           <li><a href="/"><span class="label label-warning">旅游</span></a></li>
           <li><a href="/"><span class="label label-warning">美食</span></a></li>
           <li><a href="/"><span class="label label-warning">运动</span></a></li>
           <li><a href="/"><span class="label label-warning">技术宅 </span></a></li>
        </ul>
      </section>
    </aside>
    <div class="right_content">
    <div style="width:100%;">
    	<span style="width:100%;display:block;margin-top: 10px;"><span class="btn btn-primary" style="margin-left:20px;" data-toggle="modal" data-target="#addalbum">创建相册</span></span>
    	
    </div>
    <div class="col-sm-6 col-md-5" style="padding-top: 5px;">
    <div class="thumbnail" style="background-color: #FFF;">
      <img src="${ pageContext.request.contextPath}/images/text01.jpg" alt="...">
      <div class="caption">
        <h3 style="color:#f16e50;text-align: center;">青春记忆</h3>
      </div>
    </div>
  </div>
   <div class="col-sm-6 col-md-5" style="padding-top: 5px;">
    <div class="thumbnail" style="background-color: #FFF;">
      <img src="${ pageContext.request.contextPath}/images/text02.jpg" alt="...">
      <div class="caption">
        <h3 style="color:#f16e50;text-align: center;">我在楼上看妹子</h3>
      </div>
    </div>
  </div>
   <div class="col-sm-6 col-md-5" style="padding-top: 5px;">
    <div class="thumbnail" style="background-color: #FFF;">
      <img src="${ pageContext.request.contextPath}/images/text01.jpg" alt="...">
      <div class="caption">
        <h3 style="color:#f16e50;text-align: center;">妹子却在看你</h3>
      </div>
    </div>
  </div>
    
    
    
    <!-- 分页功能 -->
    <div class="col-md-12 col-md-offset-3">
  <nav aria-label="Page navigation">
  		<ul class="pagination">
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


<!-- 模态框 -->
<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@哈哈">发私信给@mdo</button>
 -->
<div class="modal fade" id="addalbum" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">创建相册</h4>
      </div>
      <div class="modal-body">
        
          <div class="form-group">
            <label for="message-text" class="control-label">相册名称</label>
            <textarea class="form-control" id="addalbum-text"></textarea>
          </div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" id="send_add_album" data-dismiss="modal">创建</button>
      </div>
    </div>
  </div>
</div>

<!-- 模态框 -->


<!-- 模态框 -->
<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@哈哈">发私信给@mdo</button>
 -->
<div class="modal fade" id="imgsuploadModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">私信</h4>
      </div>
      <div class="modal-body">
        <form action="${pageContext.request.contextPath}/album?method=" method="post" enctype="multipart/form-data">
          	文件<input type="file" name="img"><br>
			<input type="submit" value="上传">
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" id="send_private_to" data-dismiss="modal">发送</button>
      </div>
    </div>
  </div>
</div>

<!-- 模态框 -->






<script type="text/javascript">
	$(function(){
		$(".updateimg").click(function(){
			
			
			alert(555);
		});
	
		$("#send_add_album").click(function(){
			
			var albumName = $("#addalbum-text").val();
			$.ajax({
				type:"Post",
				url:"http://localhost:8080/timer/album?method=addalbum",
				data:"albumname=" + albumName,
				success:function(msg){
					alert(msg);
				}
				
			});
			
		});
		
		
		
		
		
	});
	


</script>
</body>
</html>