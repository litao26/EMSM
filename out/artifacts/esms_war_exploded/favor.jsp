<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的收藏夹</title>

<link rel="stylesheet" type="text/css" href="css/userOther.css" />
<link rel="stylesheet" type="text/css" href="css/fav_message.css" />
<link type="text/css" rel="stylesheet" href="css/delete_order_style.css"/>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">

$(function(){
	$.ajax({
		url:"favor.do",
		type:"post",
		success:function(datas){
			for(var i = 0;i<datas.length;i++){
				var obj = datas[i];
				// 把obj 这个json对象转换成页面上的一个显示单元对应的字符串
				var divTd ='<tr align="center" bgcolor="#FBF7EE">'
                    +'<td width="5%"></td>'
                    +'<td width="20%">商品图片</td>'
                    +'<td width="32%">商品名称</td>'
                    +'<td width="10%">价格</td>'
                    +'<td width="11%">库存</td>'
                    +'<td>操作</td></tr>'
                    +'<tr><td align="center"><input type="checkbox" style="border:1px solid #CCCCCC;" /></td>'
	                +'<td align="center"><a href="#"><img src="'+obj.picture+'" style="height: 50px"/></a></td>'
	                +'<td style="padding-left:5px;">'
	                +'<a href="#" style="font-size:14px;font-weight:bold;width: 200px">'+obj.name+' '
	                +'</a><br/>'
	                +'<span  id ="favor_time" style="color:#999999;">收藏时间：2018-09-7</span></td>'
	                +'<td align="center"><b>￥'+obj.lower_price+'</b></td>'
	                +'<td align="center">现货</td>'
	                +'<td align="right" style="padding-right:8px;border-right:none;">'
	                /* 这一行显示两个图 */
	                +'<a href="buyProduct.do?product_id='+obj.product_id+'"><img src="images/btn_07.gif" /></a><br />'
	                +' <a href="javascript:location.reload();"><img src="images/btn_13.gif" onclick="deleteOne('+obj.product_id+')" style="margin-top:4px;" /></a>'
	                +'</td><tr>';
                $("#fav_product").append($(divTd));
			}
		},
		dataType:"json"
	});
});
</script>
<script type="text/javascript">
function deleteOne(){
    $.ajax({
        url:"delFavor.do",
        type:"post",
        success:function(rf){
            var trobj = "#fav_product";
            $(trobj).remove();
            if(rf){
                window.location.reload();
            }
        },
        dataType:"json"
    });
	
};


</script>
</head>
<body>
<!--头部导航开始-->
<%@include file="head.jsp"%>

<div id="bodyPart">
	<div class="w">
		<div class="crumb">
			 <a href="bookMain.do">首页</a>
			 &nbsp;&gt;&nbsp;
			 <a href="#">我的京东</a>
			 &nbsp;&gt;&nbsp;
			 <a href="favor.jsp" >我的收藏夹</a>
        </div>
	</div>
	<div class="main">
		<!-- 左侧栏目 -->
		<%@include file="left.jsp"%>
		<!--右侧-->
<div id="right_order">
	<div id="trade">
	<table width="100%" id="trade_record" cellpadding="0" cellspacing="0">
    	<tr bgcolor="#FBF7EE">
        	<th align="left" colspan="6">&nbsp;收藏夹</th>
        </tr>
        <tr style="line-height:35px;">
        	<!-- 这一行添加全部的商品进入购物车 -->
            <td colspan="6"><a href="favorAllAddCart.do"><img src="images/btn_03.gif" /></a></td>
        </tr>
        <tr><td colspan="6">
        <table width="100%" id="fav_product" cellpadding="0" cellspacing="0">
            <%--<tr align="center" bgcolor="#FBF7EE">
                <td width="5%"></td>
                <td width="20%">商品图片</td>
                <td width="32%">商品名称</td>
                <td width="10%">价格</td>
                <td width="11%">库存</td>
                <td>操作</td>
            </tr>
            
            <tr id="fovor_show">--%>
        <%--  <td align="center"><input type="checkbox" style="border:1px solid #CCCCCC;" /></td>
                <td align="center"><a href="#"><img src="img/fav_01.jpg" /></a></td>
                <td style="padding-left:5px;">
                <a href="#" style="font-size:14px;font-weight:bold;">${obj.name }	
</a><br />
<span  id ="favor_time" style="color:#999999;">收藏时间：2011-03-18</span></td>
                <td align="center"><b>￥5199:00</b></td>
                <td align="center">现货</td>
                <td align="right" style="padding-right:8px;border-right:none;">
                	<a href="initCart.jsp"><img src="images/btn_07.gif" /></a><br />
                    <a href="#"><img src="images/btn_13.gif" style="margin-top:4px;" /></a>
                </td> --%>
            </tr>
     
        </table>
        </td></tr>
        <tr>
        	<td colspan="5" style="marign-top:15px;border-right:none;">
            <div style="float:left;padding-top:6px;">&nbsp;<input type="checkbox" />全选</div>
            <div style="float:left;padding-top:6px;margin-left:6px;"">       	
                <a href="initCart.jsp"><img src="images/btn_07.gif"/></a>
            </div>
            </td>
        	<td align="right"><div id="page"><a href="#">1</a></div></td>
        </tr>
    </table>
    	
    
	</div>
</div>
</div>
</div>
<!--主体结束-->

<!-- 底部栏目 -->
	<%@include file="footer.jsp"%>
</div>
</body>
</html>
