<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link type="text/css" href="css/orderInfoSure_style.css" rel="stylesheet"/>
	<style type="text/css">
		#addcontent2{
			width:450px;
			height:400px;
			border:1px solid #0099FF;
			padding: 40px;
			font-size:18px;
			position: fixed;
			bottom:-480px;
			right:-330px;
			transition:all 1s;
			background-color: #fff;
		}#addcontent2>h4{
			 text-align: center;
		 }
		#addcontent2 input{
			font-size:18px;
			width:180px;
		}
		#addcontent2 p{
			text-align: center;
		}
	</style>
<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
        function show2(){
            document.getElementById("addcontent2").style="bottom:100px;right:550px;";
            //$("#addcontent2").css({"bottom":"100px","right":"600px"});

        }
        function reset_y(){
            hide2();
        }
        function hide2(){
            document.getElementsByName("receive_name").value="";
            document.getElementsByName("province").value="";
            document.getElementsByName("address").value="";
            document.getElementsByName("zipcode").value="";
            document.getElementsByName("mobile").value="";
            document.getElementsByName("telephone").value="";
            document.getElementsByName("email").value="";
            document.getElementById("addcontent2").style="bottom:-480px;right:-330px;";
        }
	</script>
</head>

<body>
<div id="bodyPart">
	<div id="top">
		<div id="logo"></div>
		<div id="Cart">
			<ul>
				<li id="myCart">1.我的购物车</li>
				<li id="writeInfo" class="white">2.填写核对订单信息</li>
				<li id="successSub">3.成功提交订单</li>				
			</ul>
		</div>
	</div>
	<div class="List_cart">
		<h2>
			<strong>填写核对订单信息</strong>
		</h2>
				
		<div class="cart_table">		
			<div id="part_consignee">
				<div class="o_show">
			
					<h1>
					收货人信息&nbsp;<input type="submit"onclick="show2()" value="修改"/>
					</h1>

					<c:forEach items="${addresses}" var="item" begin="0" end="0">
					<div class="middle">
						<table cellpadding="0" cellspacing="0">
							<tr>
								<td align="right" style="width: 80px;">收货人姓名：</td>
								<td>${item.receive_name}</td>
							</tr>
							
							<tr>
								<td align="right">省　　份：</td>
								<td>${item.province}</td>
							</tr>
						
							<tr>
								<td align="right">地　　址：</td>
								<td>${item.address}</td>
							</tr>
						
							<tr>
								<td align="right">手机号码：</td>
								<td>${item.mobile}</td>
							</tr>
						
							<tr>
								<td align="right">固定电话：</td>
								<td>${item.telephone}</td>
							</tr>
							<tr>
								<td align="right">电子邮件：</td>
								<td>${item.email}</td>
							</tr>
						
							<tr>
								<td align="right">邮　　编：</td>
								<td>${item.zipcode}</td>
							</tr>
							<form action="addressPut.do" method="post">
								<div id="addcontent2" >
									<h4>修改地址</h4><br>
									<p>收 货 人 姓 名&nbsp;:&nbsp;<input type="text" name="receive_name" placeholder="${item.receive_name}"></p><br>
									<p>省&nbsp;&nbsp;份&nbsp;:&nbsp;<input type="text" name="province" placeholder="${item.province}"></p><br>
									<p>地&nbsp;&nbsp;址&nbsp;:&nbsp;<input type="text" name="address" placeholder="${item.address}"></p><br>
									<p>手机号码&nbsp;:&nbsp;<input type="text" name="telephone" placeholder="${item.mobile}"></p><br>
									<p>固定电话&nbsp;:&nbsp;<input type="text" name="mobile" placeholder="${item.telephone}"></p><br>
									<p>电子邮件&nbsp;:&nbsp;<input type="text" name="email" placeholder="${item.email}"></p><br>
									<p>邮&nbsp;&nbsp;编&nbsp;:&nbsp;<input type="text" name="zipcode" placeholder="${item.zipcode}"></p>
									<input type="hidden" value="${item.reveive_address_id}" name="id"><br>
									<p><button type="submit" >修改</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button onclick="reset_y()"><a href="#">取消</a></button></p>
								</div>
							</form>
						</table>
					</div>
					</c:forEach>
				</div>
			</div>		


			<div id="part_payTypeAndShipType">
				<div class="o_show">
					<h1>支付及配送方式&nbsp;<a href="#">修改</a></h1>
     				<div class="middle">
						<table cellpadding="0" cellspacing="0">
							  <tr>
								  <td style="text-align: right; width: 80px;">支付方式：</td>
								  <td>在线支付</td>
							  </tr>
							  <tr style="">
								  <td style="text-align: right;">配送方式：</td>
								  <td>京东快递</td>
							  </tr>
							  <tr>
								  <td style="text-align: right;">运　　费：</td>
								  <td>0.00元<span style="color: red;">(免运费)</span></td>
							  </tr>
							  <tr>
								  <td style="text-align: right;">送货日期：</td>
								  <td style="color: red;">只双休日、假日送货(工作日不用送)</td>
							  </tr>
						</table>

       				</div>
				</div>
			</div>


			<div id="part_invoice">
				<div class="o_show">
					 <h1>发票信息&nbsp;<a href="#">[修改]</a></h1>
					  <div class="middle">
							<table cellpadding="0" cellspacing="0">
								<tr>
									<td style="text-align: right; width: 82px;">发票类型：</td>
									<td>普通发票</td>
								</tr>
								<tr>
									<td style="text-align: right;">发票抬头：</td>
									<td>个人 </td>
								</tr>
								 <tr>
								   <td style="text-align: right;">发票内容：</td>
								   <td>明细</td>
								</tr>
							</table>
					   </div>
				 </div>			 
			</div>


			<div id="part_remark">
				<div class="o_show">
				   <h1>订单备注&nbsp;<a href="#">[修改]</a></h1>
					 <div class="middle">
						<table cellpadding="0" cellspacing="0">
							<tr>
								<td style="text-align: left; padding-left: 20px;">暂无备注</td>
							</tr>
						</table>
					</div>
				</div>
			</div>


			<div id="part_cart">
				<div class="o_show">
				   <h1><span style="margin-right: 700px;">商品清单</span><a  href="myCart.jsp" id="backCart">返回修改购物车</a></h1>
				   <div class="middle">
					   <table width="100%" cellspacing="0" cellpadding="0" class="Table">
						 <tr class="align_Center Thead">
							<td width="7%">商品编号</td>
							<td>商品名称</td>
							<td width="10%">京东价</td>
							<td width="8%">返现</td>
							<td width="8%">赠送积分</td>
							<td width="9%">库存状态</td>
							<td width="9%">商品数量</td>
						 </tr>
						<c:forEach items="${cart }" var="item">
						<tr class="align_Center">
							 <td style="padding: 5px 0pt;">${item.product_id }</td>
							 <td class="align_Left">
							 	<a href="#">${item.name }</a>
								<div><span class="tip_bag">[赠品]</span>无<font color="red"></font></div>
				
							 </td>
							 <td><span class="price">￥${item.lower_price }</span></td>
							 <td>￥0.0</td>
							 <td>${item.score }</td>
							 <td>现货</td>
							 <td>${item.count }</td>
						</tr>
						</c:forEach>
					 </table>
				   </div>
				</div>
			</div>	
	

			<div id="ware_info">
				<div id="acc_info">结算信息</div>
				<h1></h1>
				<div class="middle">
					<ul id="part_info">
						<li style="padding-bottom: 5px;" class="info1">商品金额：${sumPrice }元 + 运费：0.00元 - 优惠券：<span id="price_coupon">0.00</span>元 - 礼品卡：<span id="price_coupon">0.00</span>元 - 返现：0.00元
						<br>
						</li>

						<li style="width: 100%; overflow: hidden;" class="info2">
							 <table cellspacing="0" cellpadding="0" width="100%">
								<tr>
								  <td><a href="#">(<span id="couponStateShow">+</span>)使用优惠券抵消部分总额</a>            </td>
								  <td style="text-align: right; font-size: 15px;"><b>应付总额：<font color="red">￥${sumPrice }</font> 元</b></td>
							   </tr>
								<tr>
								  <td colspan="2"><a href="#">(<span id="couponStateShow">+</span>)使用京东礼品卡</a>            </td>
							   </tr>
							</table>
						</li>
                    </ul>
				</div>				
			</div>


			<div id="submit_btn"><a href="orderSuccess.jsp"><img src="img/submit.jpg"/></a></div>	
			<div id="line"></div>
		</div><!----cart_table结束---->
		
		<div class="round">
			<div class="lround"></div>
			<div class="rround"></div>
		</div>			
	</div>	
</div>
<!-- 页脚类型1 -->
<%@include file="footer1.jsp"%>
</body>
</html>
