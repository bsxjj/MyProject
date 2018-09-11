<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="span10 last">
	<div class="topNav clearfix">
		<ul>
		    <c:set var="isLogin" value="${empty sessionScope.user}"/>
			<c:if test="${isLogin}">
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a
					href="${ pageContext.request.contextPath }/login">登录</a>|
				</li>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a
					href="${ pageContext.request.contextPath }/register">注册</a>|
				</li>
			</c:if>
			<c:if test="${!isLogin}">
			   <!-- 显示登录用户名 -->
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<span>${sessionScope.user.username}</span>
				</li>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${pageContext.request.contextPath}/findByUid?uid=${user.uid}&page=1">我的订单</a> |
				</li>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a
					href="${ pageContext.request.contextPath }/exit">退出</a>|
				</li>
             </c:if>
			<li><a>会员中心</a> |</li>
			<li><a>购物指南</a> |</li>
			<li><a>关于我们</a></li>
		</ul>
	</div>
	<div class="cart">
		<a href="${pageContext.request.contextPath}/myCart">购物车</a>
	</div>
	<div class="phone">
		客服热线: <strong>96008/53277764</strong>
	</div>
</div>
<div class="span24">
	<ul class="mainNav">
		<li><a href="${pageContext.request.contextPath}/">首页</a> |</li>
		<c:forEach var="c" items="${sessionScope.cList}">
		<li>
		<a href="${pageContext.request.contextPath}/findByCid?cid=${c.cid}&page=1">${c.cname}</a>|</li>
		</c:forEach>
	</ul>
</div>