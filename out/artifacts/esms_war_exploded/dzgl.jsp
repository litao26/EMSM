<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的订单</title>
<link type="text/css" rel="stylesheet" href="css/delete_order_style.css"/>
<link rel="stylesheet" type="text/css" href="css/userOther.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<style type="text/css">
		#addcontent{
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
		}#addcontent>h4{
			 text-align: center;
		 }
		#addcontent input{
			font-size:18px;
			width:180px;
		}
		#addcontent p{
			text-align: center;
		}
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
	<script type="text/javascript">
        function show(){
            document.getElementById("addcontent").style="bottom:100px;right:600px;";
        }
        function show2(){
            document.getElementById("addcontent2").style="bottom:100px;right:600px;";
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
        function reset_x(){
            hide();
        }
        function hide(){
            document.getElementsByName("receive_name").value="";
            document.getElementsByName("province").value="";
            document.getElementsByName("address").value="";
            document.getElementsByName("zipcode").value="";
            document.getElementsByName("mobile").value="";
            document.getElementsByName("telephone").value="";
            document.getElementsByName("email").value="";
            document.getElementById("addcontent").style="bottom:-480px;right:-330px;";
        }
        /*function update(reveive_address_id) {
            $.ajax({
                url:"updateAddress.do",
                type:"post",
                success:function (rf) {
                    if(rf){
                        window.location.reload();
                    }else {
                        alert("修改失败");
                    }
                },
                data:{"reveive_address_id":reveive_address_id},
                dataType:"json"
            });
        }*/
        function remove(reveive_address_id) {
            $.ajax({
				url:"delAddressAJAX.do",
				type:"post",
				success:function (rf) {
                    if(rf){
                        window.location.reload();
					}else {
                        alert("删除失败");
                    }
                },
                data:{"reveive_address_id":reveive_address_id},
                dataType:"json"
			});

        }
	</script>
</head>
<body>
<!--快捷访问栏开始-->
<%@include file="head.jsp"%>

<div id="bodyPart">
	<div class="w">
		<div class="crumb">
			 <a href="#">首页</a>
			 &nbsp;&gt;&nbsp;
			 <a href="#">我的京东</a>
			 &nbsp;&gt;&nbsp;
			 <a href="#">地址管理</a>
        </div>
	</div>
	<!--主界面-->
	<div class="main">
	<!--左侧-->
	<%@include file="left.jsp"%>
	<!--右侧-->
	<div id="right_order">
		<div class="addr_m">
	    	<div class="addr_tit"><h3>收货地址管理</h3></div>
	        <div class="addr_c">
				<c:forEach items="${addresses}" var="item">
	        	<div class="addr_list">
	            	<div class="addr_num"><h3></h3></div>
	                <div class="addr_info">
	                <table>
	                	<tr>
	                    	<td>收&nbsp;货&nbsp;人：</td>
	                        <td>${item.receive_name}</td>
	                    </tr>
	                    <tr>
	                    	<td>省&nbsp;&nbsp;&nbsp;&nbsp;份：</td>
	                        <td>${item.province}</td>
	                    </tr>
	                    <tr>
	                    	<td>地&nbsp;&nbsp;&nbsp;&nbsp;址：</td>
	                        <td>${item.address}</td>
	                    </tr>
	                    <tr>
	                    	<td>邮&nbsp;&nbsp;&nbsp;&nbsp;编：</td>
	                        <td>${item.zipcode}</td>
	                    </tr>
	                    <tr>
	                    	<td>联系电话：</td>
	                        <td>${item.mobile}</td>
	                    </tr>
	                    <tr>
	                    	<td>手&nbsp;&nbsp;&nbsp;&nbsp;机：</td>
	                        <td>${item.telephone}</td>
	                    </tr>
	                    <tr>
	                    	<td>电子邮件：</td>
	                        <td>${item.email}</td>
	                    </tr>
	                    <tr>
	                    	<td></td>
	                        <td style="height:24px" align="center" ><input type="submit"onclick="show2()" value="修改"/>&nbsp;<input type="submit" onclick="remove(${item.reveive_address_id})" value="删除"/></td>
	                    </tr>
	                </table>
	                </div>
	            </div>
					<form action="updateAddress.do" method="post">
						<div id="addcontent2" >
							<h4>修改地址</h4><br>
							<p>收 货 人&nbsp;:&nbsp;<input type="text" name="receive_name" placeholder="${item.receive_name}"></p><br>
							<p>省&nbsp;&nbsp;份&nbsp;:&nbsp;<input type="text" name="province" placeholder="${item.province}"></p><br>
							<p>地&nbsp;&nbsp;址&nbsp;:&nbsp;<input type="text" name="address" placeholder="${item.address}"></p><br>
							<p>邮&nbsp;&nbsp;编&nbsp;:&nbsp;<input type="text" name="zipcode" placeholder="${item.zipcode}"></p><br>
							<p>联系电话&nbsp;:&nbsp;<input type="text" name="mobile" placeholder="${item.mobile}"></p><br>
							<p>手&nbsp;&nbsp;机&nbsp;:&nbsp;<input type="text" name="telephone" placeholder="${item.telephone}"></p><br>
							<p>电子邮件&nbsp;:&nbsp;<input type="text" name="email" placeholder="${item.email}"></p><<input
								type="hidden" value="${item.reveive_address_id}" name="id"><br>
							<p><button type="submit" >修改</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button onclick="reset_y()"><a href="addressList.do">取消</a></button></p>
						</div>
					</form>
				</c:forEach>
				<div class="clear" style="clear:both;"></div>
                <div id="addr_new">如果您有新地址，请<a href="javascript:"><span onclick="show()">添加新地址</span></a><a href="orderInfoSure.jsp">回到订单页面</a></div>
				<form action="address.do" method="post">
				<div id="addcontent" >
					<h4>添加地址</h4><br>
					<p>收 货 人&nbsp;:&nbsp;<input type="text" name="receive_name" ></p><br>
					<p>省&nbsp;&nbsp;份&nbsp;:&nbsp;<input type="text" name="province"></p><br>
					<p>地&nbsp;&nbsp;址&nbsp;:&nbsp;<input type="text" name="address"></p><br>
					<p>邮&nbsp;&nbsp;编&nbsp;:&nbsp;<input type="text" name="zipcode"></p><br>
					<p>联系电话&nbsp;:&nbsp;<input type="text" name="mobile"></p><br>
					<p>手&nbsp;&nbsp;机&nbsp;:&nbsp;<input type="text" name="telephone"></p><br>
					<p>电子邮件&nbsp;:&nbsp;<input type="text" name="email"></p><br>
					<p><button type="submit" >提交</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button onclick="reset_x()"><a href="addressList.do">取消</a></button></p>
				</div>
				</form>
				<%--<form action="updateAddress.do" method="post">
					<div id="addcontent2" >
						<h4>修改地址</h4><br>
						<p>收 货 人&nbsp;:&nbsp;<input type="text" name="receive_name"></p><br>
						<p>省&nbsp;&nbsp;份&nbsp;:&nbsp;<input type="text" name="province"></p><br>
						<p>地&nbsp;&nbsp;址&nbsp;:&nbsp;<input type="text" name="address"></p><br>
						<p>邮&nbsp;&nbsp;编&nbsp;:&nbsp;<input type="text" name="zipcode"></p><br>
						<p>联系电话&nbsp;:&nbsp;<input type="text" name="mobile"></p><br>
						<p>手&nbsp;&nbsp;机&nbsp;:&nbsp;<input type="text" name="telephone"></p><br>
						<p>电子邮件&nbsp;:&nbsp;<input type="text" name="email"></p><br>
						<p><button type="submit" >修改</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button onclick="reset_y()"><a href="addressList.do">取消</a></button></p>
					</div>
				</form>--%>
	    	</div>
		</div>
	    <div class="addr_m">
	    	<div class="addr_tit"><h3>地址维护</h3></div>
	        <div class="addr_c">
	        	<div id="addr_add">
	            	<table>
	                	<tr>
	                    	<td>收&nbsp;货&nbsp;人：</td>
	                        <td><input type="text"/><font color="#ff0000">*</font></td>
	                    </tr>
	                    <tr>
	                    	<td>省&nbsp;&nbsp;&nbsp;&nbsp;份：</td>
	                        <td>
	                        	<select>
	                            	<option>北京&nbsp;&nbsp;</option>
	                            </select>
	                            <select>
	                            	<option>海淀区&nbsp;&nbsp;</option>
	                            </select>
	                            <select>
	                            	<option>三环以内&nbsp;&nbsp;</option>
	                            </select>
	                        </td>
	                    </tr>
	                    <tr>
	                    	<td>地&nbsp;&nbsp;&nbsp;&nbsp;址：</td>
	                        <td><input type="text" size="32"/><font color="#ff0000">*</font></td>
	                    </tr>
	                    <tr>
	                    	<td>邮&nbsp;&nbsp;&nbsp;&nbsp;编：</td>
	                        <td><input type="text"/></td>
	                    </tr>
	                    <tr>
	                    	<td>联系电话：</td>
	                        <td><input type="text"/>如：6543788</td>
	                    </tr>
	                    <tr>
	                    	<td>手&nbsp;&nbsp;&nbsp;&nbsp;机：</td>
	                        <td><input type="text"/>我们会用免费短信通知你发货信息</td>
	                    </tr>
	                    <tr>
	                    	<td>电子邮件：</td>
	                        <td><input type="text"/></td>
	                    </tr>
	                    <tr>
	                    	<td></td>
	                        <td style="height:44px" ><input type="submit" value="提交地址"/></td>
	                    </tr>
	                </table>
	            </div>
	        </div>
	    </div>
	</div>
	</div>
</div>
<!--主体结束-->

<!--服务部分开始-->
<%@include file="footer.jsp"%>
</body>
</html>
