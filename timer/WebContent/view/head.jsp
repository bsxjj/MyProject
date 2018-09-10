<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${ pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"/>
<style type="text/css">
	.write-png{
		cursor: pointer;
	}

</style>

</head>
<body>
<header>
 <nav class="navbar navbar-inverse navbar-default col-md-12 nav-black">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand"></a>
                    <button class="navbar-toggle" data-toggle="collapse" data-target=.navbar-responsive-collapse>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>

                    </button>
                </div>
                <div class="collapse navbar-collapse navbar-responsive-collapse">
                    <ul class="nav navbar-nav  navbar-left">
                        <li class="index"><a href="${pageContext.request.contextPath}/view/index.jsp">广场</a></li>
                        <li class="userlook"><a href="${pageContext.request.contextPath}/view/userlook.jsp">时光册</a></li>
                        <li class="guangguang"><a href="${pageContext.request.contextPath}/view/guangguang.jsp">爱时光</a></li>
                        <li class="words"><a href="${pageContext.request.contextPath}/view/words.jsp">时光瓶</a></li>
                        
                    </ul>
                    
                    <ul class="nav navbar-nav navbar-right admin_te" style="height: 50px;">
                    	<li style="height: 50px;text-align: center;padding-right: 10px;"><img alt="" src="${ pageContext.request.contextPath}/images/write.png" class="write-png" style="width:30px;height:30px;"></li>
                    	<li style="height: 50px;text-align: center;padding-right: 10px;"><a href="${ pageContext.request.contextPath}/view/notifications.jsp" style="margin: 0;padding-top: 5px; "><img alt="" src="${ pageContext.request.contextPath}/images/mail.png" class="img-circle" style="width:30px;height:30px;"><span class="badge" style="background-color: #FF0000;" id="countnum"></span></a></li>
              			<li style="height: 50px;text-align: center;"><img alt="" src="${ user.headPicture}" class="img-circle" style="width:30px;height:30px;"></li>
                    </ul>
                    
                </div>
            </div>
    </nav>
 </header>
</body>
<script type="text/javascript">
	function getCountNum(){
		$.ajax({
			type:"GET",
			url:"http://localhost:8080/timer/privateletter?method=notread",
			success:function(msg){
				console.log(msg);
				if (msg == 0){
					$("#countnum").html("");
				
				}else{
					$("#countnum").html(msg);
						
				}
				
			}
			
		});
	}
	var int=self.setInterval("getCountNum()",5000);
	$(function(){
		
		
		
	});


</script>
</html>