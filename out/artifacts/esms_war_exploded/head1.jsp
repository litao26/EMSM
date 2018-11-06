<%@ page language="java"  pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/head1.css" rel="stylesheet" type="text/css">
<div id="headPart">
<div id="shortcut">
		<div class="w">
			<ul>
				<c:if test="${empty login_name == true}">
					<li class="fore1" id="loginfo">您好！欢迎来到京东商城！<span><a href="login.jsp">[请登录]</a>，新用户<a href="register.jsp" class="link-regist">[免费注册]</a></span></li>
				</c:if>
				<c:if test="${empty login_name== false}">
					<li class="fore1" id="loginfo">您好！欢迎来到京东商城！<span><a href="login.jsp">${login_name}</a>，新用户<a href="register.jsp" class="link-regist">[免费注册]</a></span></li>
				</c:if>
				<li class="fore2"><a href="orderList.jsp">我的订单</a></li>
	
				<li><a href="userHome.jsp">我的京东</a></li>
				<li><a href="myCart.jsp">我的购物车</a></li>
				
				<li class="sub"><b></b>帮助中心</li>
			</ul>
		</div>
	</div>
</div>