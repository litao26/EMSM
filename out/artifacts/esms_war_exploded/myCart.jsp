<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/myCart_style.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="js/jquery.min.js"></script>
<title>无标题文档</title>
	<script type="text/javascript">
        $(function(){
            $.ajax({
                url:"myCartLoadCookie.do",
                type:"post"
            });
        });
        function removerTr(product_id){
            $.ajax({
                url:"myCartAJAX.do",
                type:"post",
                success:function(data){
                    var trobj = "#tr"+product_id;
                    $(trobj).remove();
                    var strDiv = '<div>已删除商品，您可以重新购买或加入收藏夹：</div><div id="divDeledSku"><div class="delItem"><table class="delItem"><tr>'
                        +'<td style="width: 70px;">'+data.product_id+'</td>'
                        +'<td style="text-align: left;"><a href="#">'+data.name+'</a></td>'
                        +'<td style="width: 150px;"><span class="price">￥'+data.lower_price+'</span></td>'
                        +'<td style="width: 125px;">1</td><td style="width: 100px;"><a href="buyProduct.do?product_id='+data.product_id+'">重新购买</a> | <a href="javascript:" onclick="addfavor('+data.product_id+')" >收藏</a></td>'
                        +'</tr></table></div></div></div>';

                    $("#DeledSkuInfo").append(strDiv);
                },
                data:{"product_id":product_id},
                dataType:"json"
            });
            flushSumPrice();
        }
        function flushSumPrice(){
            $.ajax({
                url:"myCartSumPrice.do",
                type:"post",
                success:function(data){
                    $("#cartBottom_price").html(data.sumPrice);
                },
                dataType:"json"
            });
        }
        function removeAll(){
            var objs = $(".spanAll");
            for(var i =0;i<objs.length;i++){
                removerTr(objs.text()[i]);
            }
        }
	</script>
	<script type="text/javascript">
        function addfavor(product_id) {
            $.ajax({
                url:"favorAdd.do",
                type:"post",
                success:function (rf) {
                    if(rf){
                        window.location.reload();
                    }else{
                        alert("收藏失败");
                    }
                },
                data:{"product_id":product_id},
                dataType:"json"
            });
        }
	</script>
	<script type="text/javascript">
        $(function(){
            $.ajax({
                url:"favor.do",
                type:"post",
                success:function(datas){
                    for(var i = 0;i<datas.length;i++){
                        var obj = datas[i];
                        // 把obj 这个json对象转换成页面上的一个显示单元对应的字符串
                        var divTd ='<div id="divDeledSku"><div class="delItem"><table class="delItem"><tr>'
                            + '<td style="width: 70px;">' + obj.product_id + '</td>'
                            + '<td style="text-align: left;"><a href="#">' + obj.name + '</a></td>'
                            + '<td style="width: 50px;"><span class="price">￥' + obj.lower_price + '</span></td>'
                            + '<td style="width: 55px;">空</td><td style="width: 150px;"><a href="avascript:" onclick="removerFavor()">取消收藏</a> | <a href="buyProduct.do?product_id='+obj.product_id+'">加入购物车</a></td>'
                            + '</tr></table></div></div></div>';
                        $("#notFav").append($(divTd));
                    }
                },
                dataType:"json"
            });
        });
	</script>
	<script type="text/javascript">
		function removerFavor(){
            $.ajax({
                url:"delFavor.do",
                type:"post",
                success:function(rf){
                    var trobj = "#divDeledSku";
                    $(trobj).remove();
                    if(rf){
                        window.location.reload();
					}
                },
                dataType:"json"
            });
		}
	</script>
	<script type="text/javascript">
        function addOrSubCount(product_id,tag){
            var obj = $("#num"+product_id);
            var count = obj.val();
            if(count<2 && tag<0){
                return;
            }
            if(count>99 && tag>0){
                return;
            }

            $.ajax({

                url:"myCartAddAndSub.do",
                type:"post",
                success:function(){
                    if(tag>0){

                        obj.val(parseInt(obj.val())+1);
                    }else{
                        obj.val(parseInt(obj.val())-1);
                    }
                },
                data:{"product_id":product_id,"tag":tag}
            });
            flushSumPrice();
        }
	</script>
</head>
<body>
<!------------头部------------->
<%@include file="head1.jsp" %>

<div id="bodyPart">
	<div id="top">
		<div id="logo"></div>
		<div id="Cart">
			<ul>
				<li id="myCart" class="white">1.我的购物车</li>
				<li id="writeInfo">2.填写核对订单信息</li>
				<li id="successSub">3.成功提交订单</li>				
			</ul>
		</div>
	</div>
	<div id="top_myCart"></div>
	<div class="List_cart">
		<h2>
			<strong>我挑选的商品</strong>
		</h2>
		<div class="cart_table">
			<table id="CartTb" cellpadding="0" cellspacing="0" width="600">
				<tr class="align_Right">
					<td>商品编号</td>
					<td>商品名称</td>
					<td>京东价</td>
					<td>返现</td>
					<td>赠送积分</td>
					<td>商品数量</td>
					<td>删除商品</td>
				</tr>
				<c:forEach items="${cart }" var="item">
					<tr id ="tr${item.product_id }">
						<td ><span class="spanAll">${item.product_id }</span></td>
						<td id="align_Left">
							<div id="c_img"><a href="ipad.jsp"><img src="${item.picture }" style="width: 50px"></a></div>
							<div id="c_info"><span><a href="#">${item.name }</a></span><br><span class="redColor">[赠品]</span>相机包 ×<span class="redColor">1</span></div>
						</td>
						<td class="price">￥${item.lower_price }</td>
						<td>￥0.0</td>
						<td>${item.score }</td>
						<td width="70">
							<div id="eqNum">
								<ul>
									<li class="Img"><img src="img/bag_open.gif" onclick="addOrSubCount(${item.product_id },1)"/></li>
									<li><input type="text"  value="${item.count }" id="num${item.product_id }" /></li>
									<li class="Img"><img src="img/bag_close.gif" onclick="addOrSubCount(${item.product_id },-1)"/></li>
								</ul>
							</div>
						</td>
						<td  onclick="removerTr(${item.product_id})">删除</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="7" class="align_Right" height="40"><b>商品总金额(不含运费)：<span id="cartBottom_price" class="price" >${sumPrice}</span>元</b></td>
				</tr>
			</table>
			<div id="cart_op">
				<ul>
					<li id="li1"><a href="myCartCookie.do">寄存购物车</a></li>
					<li id="li2" onclick="removeAll()">清空购物车</li>
					<li id="li3">凑单商品</li>
					<li id="li4"><a href="bookMain.do"><img src="img/btn0603_1.jpg"/></a><a href="orderInfoSure.jsp"><img src="img/btn0603_2.jpg"/></a></li>
				</ul>
			</div>
			
			<div id="DeledSkuInfo">
		</div><!---cart_table--->
	</div>
	
	<div id="sbox_3" class="Wrap_cart">
		<div class="c-top"></div>	
		<div class="content_right">
			<h3>购买了同样商品的顾客还购买了</h3>		
			<ul class="num">
				<li>1</li>
				<li>2</li>
				<li class="on">3</li>
			</ul>
			<div class="ad">
				<ul>
					<li class="Product_List_S3">
						<ul>
							<li>
								<dl>
									<dt><a href="#"><img src="img/ms.jpg"></a></dt>
									<dd>
										<div class="p_Name"><a href="#">微软（Microsoft）无线激光鼠标ARC 黑色</a></div>
										<div class="p_Price"><img src="img/ms_price.png"></div>
										<div class="p_Opp"><a href="#"><img src="img/addcart2.gif"></a></div>

									</dd>
								</dl>
							</li>						
							<li>
								<dl>
									<dt><a href="#"><img src="img/ms.jpg"></a></dt>
									<dd>
										<div class="p_Name"><a href="#">微软（Microsoft）无线激光鼠标ARC 黑色</a></div>
										<div class="p_Price"><img src="img/ms_price.png"></div>
										<div class="p_Opp"><a href="#"><img src="img/addcart2.gif"></a></div>

									</dd>
								</dl>
							</li>						
							<li>
								<dl>
									<dt><a href="#"><img src="img/ms.jpg"></a></dt>
									<dd>
										<div class="p_Name"><a href="#">微软（Microsoft）无线激光鼠标ARC 黑色</a></div>
										<div class="p_Price"><img src="img/ms_price.png"></div>
										<div class="p_Opp"><a href="#"><img src="img/addcart2.gif"></a></div>

									</dd>
								</dl>
							</li>						
						</ul>
					</li>
				</ul>			
			</div>			
		</div>
		<div class="c-bot"></div>		
		
			
	</div>
	
	<div class="List_cart t">
		<h2>
			<strong>我收藏的商品<span id="smallSize">(现在就放入购物车吧！)</span><span id="extra">进入收藏夹>></span></strong>
		</h2>
		<div id="notFav"style="height: 200px">
			<%--<div id="divDeledSku">
				<div class="delItem">
					<table class="delItem">
						<tr>
							<td style="width: 70px;">264645</td>
							<td style="text-align: left;"><a href="#">苹果（Apple）iPad  MB293CH/A  9.7英寸平板电脑 （32G WIFI版）</a></td>
							<td style="width: 150px;"><span class="price">￥3,688.00</span></td>
							<td style="width: 125px;">1</td><td style="width: 100px;"><a href="#">重新购买</a> | <a href="#">收藏</a></td>
						</tr>
					</table>
				</div>
			</div>--%>
		</div>
	</div>
	<div id="help">
		帮我们改进购物车	</div>	
</div>
<!-- 页脚1 -->
<%@include file="footer1.jsp" %>

</body>
</html>
