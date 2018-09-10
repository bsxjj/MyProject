	var isWrite_reply_divshow = false;
	var isreply_replyshow = false;
	
	function getAllComments(imgtxtid){
		$.ajax({
			type:"GET",
			url:"http://localhost:8080/timer/comment?method=getcomms",
			data:"imgtxtid=" + imgtxtid,
			success:function(msg){
				//alert(msg);
				var allhtml = "";
				var jsonarray = jQuery.parseJSON(msg);
				for(var i = 0;i < jsonarray.length;i++){
					allhtml = allhtml + "<div class=\"jy_user_headimg\"><a href=\"\"><img class=\"img-circle img-responsive\" alt=\""+jsonarray[i].commentorName+"的头像\" src=\""+jsonarray[i].commentorHead+"\"></a></div>"
					+ "<div class=\"list_con\"><div class=\"jy_text\"><span>"+jsonarray[i].commentorName+"</span>:"+jsonarray[i].commentContent+"</div><div class=\"jy_text2\">"
					+"<ul><li class=\"write_reply_comm\">回复</li></ul></div><div class=\"WB_from S_txt2\">"+jsonarray[i].strCreateTime+"</div>"+
					"<div class=\"write_reply_div\">"+
						"<span><input type=\"hidden\" name=\"rootcomid\" value=\""+jsonarray[i].commentId+"\" class=\"rootcomid\"></span>"
						+"<span><input type=\"hidden\" name=\"beReliedName\" value=\""+jsonarray[i].commentorName+"\" class=\"beReliedName\"></span>"+
   						"<span><input type=\"hidden\" name=\"replyId\" value=\""+jsonarray[i].commentId+"\" class=\"replyId\"></span>"+
    					"<span><textarea class=\"reply_content\" rows=\"2\" style=\"width:100%;border-color:#f16e50;overflow:hidden; resize:none;\" placeholder=\"回复"+jsonarray[i].commentorName+"\"></textarea></span>"+
    					"<span><button class=\"btn btn-danger right-button pull-right sendreply_comm_btn\">回复</button></span></div>"
					+"</div>"
					if (jsonarray[i].replies.length > 0){
						allhtml = allhtml + "<div class=\"list_on_in\"><div class=\"list_ul\"><div><div class=\"list_con\">";
						for(var j = 0;j < jsonarray[i].replies.length;j++){
							allhtml = allhtml + "<div class=\"S_line1\"><div class=\"jy_text\">";
							if (jsonarray[i].replies[j].reply_type == "reply_comm"){
								allhtml = allhtml +"<span>"+jsonarray[i].replies[j].replyname+"</span>";
							}else{
								allhtml = allhtml +"<span>"+jsonarray[i].replies[j].replyname+"回复 "+jsonarray[i].replies[j].beReliedName+"</span>";
								
							}
							allhtml = allhtml + ":" + jsonarray[i].replies[j].replyContent;
							if (jsonarray[i].replies[j].beRepliedContent != "" && jsonarray[i].replies[j].beRepliedContent != null){
								allhtml = allhtml + "<span class=\"old_content\" style=\"color:#000000\"><span style=\"color:#eb7350\">"+jsonarray[i].replies[j].beReliedName+"</span> :"+jsonarray[i].replies[j].beRepliedContent+"</span>";
							}
							allhtml = allhtml +"</div><div class=\"jy_text2\"><ul><li class=\"write_reply_reply\">回复</li></ul></div><div class=\"WB_from S_txt2\">"+jsonarray[i].replies[j].strReplyTime+"</div>"
							+"<div class=\"write_reply_div\"><span><input type=\"hidden\" name=\"rootcomid\" value=\""+jsonarray[i].replies[j].rcommentid+"\" class=\"rootcomid\"></span><span><input type=\"hidden\" name=\"beReliedName\" value=\""+jsonarray[i].replies[j].replyname+"\" class=\"beReliedName\"></span><span><input type=\"hidden\" name=\"replyId\" value=\""+jsonarray[i].replies[j].id+"\" class=\"replyId\"></span>"
							+"<span><textarea class=\"reply_content\" rows=\"2\" style=\"width:100%;border-color:#f16e50;overflow:hidden; resize:none;\" placeholder=\"回复"+jsonarray[i].replies[j].replyname+"\"></textarea></span>"
							+"<span><button class=\"btn btn-danger right-button pull-right sendreplybtn\">回复</button></span></div>"+"</div>";
						}
						allhtml = allhtml + "</div></div></div></div>";
					}
					
					//alert(jsonarray[i].replies.length);
				}
				$(".reply_list").html(allhtml);
				
			}
			
		});
	}
	
	$(function(){
		$(document).on("click",".write_reply_comm",function(){
			alert($(this).parent().parent().next().next(".write_reply_div").html());
			if (isWrite_reply_divshow){
				$(this).parent().parent().next().next(".write_reply_div").hide(1000);
				isWrite_reply_divshow = false;
			}else{
				$(this).parent().parent().next().next(".write_reply_div").show(1000);
				isWrite_reply_divshow = true;
			}
			
			
		});
		$(document).on("click",".write_reply_reply",function(){
			if (isreply_replyshow == false){
				$(this).parent().parent().next().next(".write_reply_div").show(1000);
				isreply_replyshow = true;
			}else{
				$(this).parent().parent().next().next(".write_reply_div").hide(1000);
				isreply_replyshow = false;
			}
			
			
		});
		
		//回复类型为评论
		$(document).on("click",".sendreply_comm_btn",function(){
			var reply_content = $(this).parent().prev().children(".reply_content").val();
			var replyid = $(this).parent().prev().prev().children(".replyId").val();
			var berepliedName = $(this).parent().prev().prev().prev().children(".beReliedName").val();
			var rootcomid = $(this).parent().prev().prev().prev().prev().children(".rootcomid").val();
			rereply_content = reply_content.trim();
			if (reply_content == ""){
				alert("评论内容不能为空");
				return false;
			}
			$.ajax({
				tyep:"POST",
				url:"http://localhost:8080/timer/comment?method=addreply",
				data:"type=reply_comm&reply_content=" +reply_content +"&replyid=" +replyid +"&berepliedName=" +berepliedName +"&rootcomid=" +rootcomid,
				success:function(msg){
					alert(msg);
					getAllComments(8);
					
				}
				
			});
			
			
			//alert(berepliedName);
		});
		
		//回复类型为回复
		$(document).on("click",".sendreplybtn",function(){
			var reply_content = $(this).parent().prev().children(".reply_content").val();
			var replyid = $(this).parent().prev().prev().children(".replyId").val();
			var berepliedName = $(this).parent().prev().prev().prev().children(".beReliedName").val();
			var rootcomid = $(this).parent().prev().prev().prev().prev().children(".rootcomid").val();
			rereply_content = reply_content.trim();
			if (reply_content == ""){
				alert("评论内容不能为空");
				return false;
			}
			$.ajax({
				tyep:"POST",
				url:"http://localhost:8080/timer/comment?method=addreply",
				data:"type=reply_repl&reply_content=" +reply_content +"&replyid=" +replyid +"&berepliedName=" +berepliedName +"&rootcomid=" +rootcomid,
				success:function(msg){
					alert(msg);
					getAllComments(8);
				}
				
			});
			
			
			//alert(berepliedName);
		});
		
		//getAllComments(8);
		
		//alert(333);
	});
