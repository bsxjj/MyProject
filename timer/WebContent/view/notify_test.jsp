<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/dist/amazeui.min.css" />
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<style type="text/css">

</style>
</head>
<body>


<%-- <!-- 私信列表 -->

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
<!-- 私信列表  -->



<!-- 私信界面 -->
 --%>




<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@哈哈">发私信给@mdo</button>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">私信</h4>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="control-label">收件人:</label>
            <input type="text" class="form-control" id="recipient-name" disabled="disabled">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">内容:</label>
            <textarea class="form-control" id="message-text"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" id="send_private_to">发送</button>
      </div>
    </div>
  </div>
</div>
 -->

<!-- 
上传头像
 -->
<div class="container" style="clear: both;">
<div class="am-popup" id="my-popup">
			<div class="am-popup-inner">
				<div class="am-popup-hd">
					<h4 class="am-popup-title">裁剪图片</h4>
					<span data-am-modal-close class="am-close">&times;</span>
				</div>
				<div class="am-popup-bd">
					<!-- 裁剪显示区 -->
					<div class="am-margin-bottom-sm" id="myclip"></div>

					<button type="button" class="am-btn am-btn-primary" id="clipBtn">
						裁剪
					</button>

					<input class="am-hide" type="file" id="myfile">
				</div>
			</div>
</div>
</div>





<script src="${pageContext.request.contextPath}/dist/amazeui.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/dist/iscroll-zoom.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/dist/hammer.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/dist/photoClip.min.js" type="text/javascript" charset="utf-8"></script>
</body>
<script type="text/javascript">
	$(function(){
		
		/* $('#exampleModal').on('show.bs.modal', function (event) {
			  var button = $(event.relatedTarget) // Button that triggered the modal
			  var recipient = button.data('whatever') // Extract info from data-* attributes
			  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
			  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
			  var modal = $(this)
			  modal.find('.modal-title').text('私信给 ' + recipient)
			  modal.find('.modal-body input').val(recipient)
			});
		$("#send_private_to").click(function(){
			
			$('#exampleModal').modal('hide');
			
		});
		$('#exampleModal').on('hidden.bs.modal', function (e) {
			alert($("#message-text").val());
		}) */
		
		
		//上传图片
		var $clip = $("#myclip");
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
				$popup.modal("close");
			}
		});
		
		
		
		
	});
</script>
<script type="text/javascript">
	/* $(function(){
		$('.dropdown-toggle').dropdown()
	});
 */



</script>


<!-- 
	 <div class="main_mess_content">
  <div class="chat-top">
  		
  		<a class="back-to-list">
  			返回私信列表
  		</a>
  		<b>
      与
      <a href="/u/b52ff888fd17" target="_blank">简宝玉</a>
      的对话
    </b>
  </div>
  <div class="message-show">
  		<ul class="message-list">
  			<li class="message-l">
  				<a href="" class="a_img"><img alt="" src="${ pageContext.request.contextPath}/images/default.gif" class="img-circle"></a>
  				<div>
  					<span class="content">
  					我是一只小可爱，哈哈哈，如果你是我的人
  					</span>
  				</div>
  			</li>
  			<li class="message-r">
  				<a href="" class="a_img"><img alt="" src="${ pageContext.request.contextPath}/images/default.gif" class="img-circle"></a>
  				<div>
  					<span class="content">
  					我是一只小可爱，哈哈哈，如果你是我的人
  					</span>
  				</div>
  			
  			</li>
  		</ul>
  </div>
  
  <div class="write-message">
  		<form action="javascript:;">
  		<textarea type="text" placeholder="输入内容" class="form-control" style="resize: none;"></textarea>
  		
  		<input type="submit" class="btn btn-danger btn-send" value="发送">
  		</form>
  </div>
  
  
  
  </div>
    



 -->




</html>