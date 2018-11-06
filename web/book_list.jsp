<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>京东商城 - 图书频道首页</title>
<link rel="stylesheet" type="text/css" href="css/book.css" />
<link rel="stylesheet" type="text/css" href="css/book_list.css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/HTML">
        <%--function money() {
            $.ajax({
               url:"orderBy.do",
                type:"post",
               success:function (objs) {
                   alert(1);
                   for(var i=0;i<objs.length;i++){
                        var obj = objs[i];
                        var divStr="<div class='pro_item'>" +
                                    " <div class='pro_picture'><a href='bookDetail.jsp'>" +
                                    "<img src='"+obj.picture+"'/></a></div>" +
                                    "<div class='pro_info'>" +
                                    "<div class='pro_up'>" +
                                    "<div class='bookName'>" +
                                    "<a href='bookDetail.jsp'>"+obj.name +"</a></div>" +
                                    "<div class='author'>作&nbsp;&nbsp;&nbsp;&nbsp;者：" +
                                    "<span>"+obj.author+"</span> 著，译<br />出&nbsp;版&nbsp;社：" +
                                    "<span>"+obj.publishing +"</span><br /></div>" +
                                    "</div>" +
                                    "<div class='pro_down'>" +
                                    "<div class='pro_left'>" +
                                    "出版时间："+obj.publish_time +"<br />" +
                                    "定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥"+obj.fixed_price +"</s>" +
                                    "</div>" +
                                    "<div class='pro_right'>" +
                                    "顾客评价：<span class='star'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>（<span>已有96人评价</span>）<br />" +
                                    "销量：<b><font>"+obj.print_number+"</font></b><span class='user_price'></span> 京东价：<b>￥"+obj.lower_price+"</b>（43折)" +
                                    "</div>" +
                                    "</div>" +
                                    "<div class='clear'></div>" +
                                    "<div class='book_btn'>" +
                                    "<a href='initCart.jsp' class='buy'></a><input type='button' value='收藏' class='favorite' />" +
                                    "</div>" +
                                    "</div>" +
                                    "</div>"
                       $(".product_list").append($(divStr));
                   }
               },
                data:{"category_id":1,"orderStd":"lower_price","orderType":"desc","pageSize":3,"pageNumber":1},
                dataType:"json"
            });

        }
        --%>
    </script>
    <script type="text/javascript">
        function favor(product_id) {
            $.ajax({
                url:"favorAdd.do",
                type:"post",
                success:function (rf) {
                    if(rf){
                        alert("收藏成功");
                    }else{
                        alert("收藏失败");
                    }
                },
                data:{"product_id":product_id},
                dataType:"json"
            });
        }
    </script>
</head>
<body id="book">
<!--快捷访问栏开始-->
<%@include file="head.jsp"%>
<!--头部导航结束-->
<div class="clear"></div>
<!--位置-->
<div id="position" class="page_width">
	<ul>
     	<li><a href="bookMain.do">首页</a></li>
        <li>&gt;</li>
     	<li><a href = "#">图书</a></li>
        <li>&gt;</li>
     	<li><a href="#">${pageContext.request.getParameter("name")}</a></li>
        <li>&gt;</li>
     	<li><a href="#">${pageContext.request.getParameter("name2")}</a></li>
     </ul>
</div>
<!--主体main部分开始-->
<div class="clear"></div>

<div id="main" class="page_width">
<!--左侧开始-->
	<div id="left_list">
    	<div id="same_sort">
			<div class="book_tit" style="width:209px;"><h2>浏览同级分类<br /><span>Browse other categories</span></h2></div>
				<div class="book_content">
					<ul>
                        <c:forEach items="${categories}" var="category">
                        <li><a href='sameBook.do?parent_id=${category.parent_id}&category_id=${category.category_id}&name=${pageContext.request.getParameter("name")}&name2=${category.name}'>${category.name}</a></li>
                        </c:forEach>
					</ul>
                    <div class="clear"></div>
					<div class="extra"><a href="bookMain.do">返回上级分类&gt;&gt;</a></div>
				</div>
			</div>	
			
            <div class="books">
			<div class="book_title">
				<h2>新书推荐<br /><span>New Releases</span></h2>
			</div>
        <c:forEach  items="${products}" var="product">
			<div class="book_info">

                <div class="book_pic">
                    <div class=""><a href="bookDetail.jsp" target="_blank"><img src='${product.picture}'/></a></div>
                </div>
                <div class="book_text">
                    <div class="book_name"><a href="bookDetail.jsp" target="_blank"><font color="#FF0000">《${product.name }》（${product.author }）</font></a></div>
                    <div class="book_intr">　　《${product.name }》,讲述了.....</div>
                    <div class="book_more"><a href="#" target="_blank">深度了解&gt;&gt;</a></div>
                </div>
			</div>
        </c:forEach>
			</div>

            
		
			<div class="ad_left_list">
            	<div class=""><a href="#" target="_blank"><img src="img/book_61.jpg" /></a></div>
				<div class=""><a href="#" target="_blank"><img src="img/book_47.jpg"></a></div>
			</div>

    </div>
<!--左侧结束-->

<!--右侧开始-->    
    <div id="right_list">
    
		<div id="filter">
			<div class="fore item">排序：</div>
			<ul class="item tab">
                <li id='filter-curr' class='down'><b></b><a href='sameBook.do?parent_id=${pageContext.request.getParameter("parent_id")}&j=0&category_id=${pageContext.request.getParameter("category_id")}&name=${pageContext.request.getParameter("name")}&name2=${pageContext.request.getParameter("name2")}'>销售排行</a><span></span></li>
                <li class='up price'><b></b><a href='sameBook.do?parent_id=${pageContext.request.getParameter("parent_id")}&j=lower_price&category_id=${pageContext.request.getParameter("category_id")}&name=${pageContext.request.getParameter("name")}&name2=${pageContext.request.getParameter("name2")}'>价格</a><span></span></li>
                <li  class="up discount"><b></b><a href='sameBook.do?parent_id=${pageContext.request.getParameter("parent_id")}&j=fixed_price&category_id=${pageContext.request.getParameter("category_id")}&name=${pageContext.request.getParameter("name")}&name2=${pageContext.request.getParameter("name2")}'>折扣</a><span></span></li>
                <li class="down"><b></b><a href='sameBook.do?parent_id=${pageContext.request.getParameter("parent_id")}&j=0&category_id=${pageContext.request.getParameter("category_id")}&name=${pageContext.request.getParameter("name")}&name2=${pageContext.request.getParameter("name2")}'>好评度</a><span></span></li>
                <li  class='down'><b></b><a href='sameBook.do?parent_id=${pageContext.request.getParameter("parent_id")}&j=add_time&category_id=${pageContext.request.getParameter("category_id")}&name=${pageContext.request.getParameter("name")}&name2=${pageContext.request.getParameter("name2")}'>上架时间</a><span></span></li>
                <li  class="down"><b></b><a href='sameBook.do?parent_id=${pageContext.request.getParameter("parent_id")}&j=publish_time&category_id=${pageContext.request.getParameter("category_id")}&name=${pageContext.request.getParameter("name")}&name2=${pageContext.request.getParameter("name2")}'>出版时间</a><span></span></li>
			</ul>
			<span class="clear"></span>
		</div>
        
        <div class="page">
            <%--<img src="images/page.jpeg" />--%>
            <a href='sameBook.do?parent_id=${pageContext.request.getParameter("parent_id")}&j=0&category_id=${pageContext.request.getParameter("category_id")}&name=${pageContext.request.getParameter("name")}&name2=${pageContext.request.getParameter("name2")}&b=-1'><input type="button" value="上一页"/></a>
            <a href='sameBook.do?parent_id=${pageContext.request.getParameter("parent_id")}&j=0&category_id=${pageContext.request.getParameter("category_id")}&name=${pageContext.request.getParameter("name")}&name2=${pageContext.request.getParameter("name2")}&b=-1'><input type="button" value=" 1 "/></a>
            <a href='sameBook.do?parent_id=${pageContext.request.getParameter("parent_id")}&j=0&category_id=${pageContext.request.getParameter("category_id")}&name=${pageContext.request.getParameter("name")}&name2=${pageContext.request.getParameter("name2")}&b=1'><input type="button" value=" 2 "/></a>
            <a href='sameBook.do?parent_id=${pageContext.request.getParameter("parent_id")}&j=0&category_id=${pageContext.request.getParameter("category_id")}&name=${pageContext.request.getParameter("name")}&name2=${pageContext.request.getParameter("name2")}&b=1'><input type="button" value="下一页"/></a>
           <%-- <a href='fictionBooks.do?parent_id=${pageContext.request.getParameter("parent_id")}&b=-1&category_id=${pageContext.request.getParameter("category_id")}'><input type="button" value="上一页"/></a>
            <a href='fictionBooks.do?parent_id=${pageContext.request.getParameter("parent_id")}&j=-1&category_id=${pageContext.request.getParameter("category_id")}'><input type="button" value=" 1 "/></a>
            <a href='fictionBooks.do?parent_id=${pageContext.request.getParameter("parent_id")}&j=1&category_id=${pageContext.request.getParameter("category_id")}'><input type="button" value=" 2 "/></a>
            <a href='fictionBooks.do?parent_id=${pageContext.request.getParameter("parent_id")}&j=1&category_id=${pageContext.request.getParameter("category_id")}'><input type="button" value="下一页"/></a>--%>
		</div>
        
        <div class="clear"></div>
        
        <div class="product_list">
            <c:forEach  items="${products}" var="product">
                <div class='pro_item'>
                    <div class='pro_picture'><a href='bookDetail.jsp'>
                        <img src='${product.picture}'/></a></div>
                    <div class='pro_info'>
                        <div class='pro_up'>
                            <div class='bookName'>
                                <a href='bookDetail.jsp'>${product.name }</a></div>
                            <div class='author'>作&nbsp;&nbsp;&nbsp;&nbsp;者：
                                <span>${product.author }</span> 著，译<br />出&nbsp;版&nbsp;社：
                                <span>${product.publishing }</span><br /></div>
                        </div>
                        <div class='pro_down'>
                            <div class='pro_left'>
                                出版时间：${product.publish_time }<br />
                                定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥${product.fixed_price }</s>
                            </div>
                            <div class='pro_right'>
                                顾客评价：<span class='star'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>（<span>已有96人评价</span>）<br />
                                销量：<b><font>${product.print_number}</font></b><span class='user_price'></span> 京东价：<b>￥${product.lower_price}</b>（43折)
                            </div>
                        </div>
                        <div class='clear'></div>
                        <div class='book_btn'>
                            <a href='buyProduct.do?product_id=${product.product_id}' class='buy'></a><input type='button' value='收藏' class='favorite' onclick="favor(${product.product_id})"/>
                        </div>
                    </div>
                </div>
            </c:forEach>
            

              
        </div><!--列表结束-->
        
        <div class="page">
            <a href='sameBook.do?parent_id=${pageContext.request.getParameter("parent_id")}&j=0&category_id=${pageContext.request.getParameter("category_id")}&name=${pageContext.request.getParameter("name")}&name2=${pageContext.request.getParameter("name2")}&b=-1'><input type="button" value="上一页"/></a>
            <a href='sameBook.do?parent_id=${pageContext.request.getParameter("parent_id")}&j=0&category_id=${pageContext.request.getParameter("category_id")}&name=${pageContext.request.getParameter("name")}&name2=${pageContext.request.getParameter("name2")}&b=-1'><input type="button" value=" 1 "/></a>
            <a href='sameBook.do?parent_id=${pageContext.request.getParameter("parent_id")}&j=0&category_id=${pageContext.request.getParameter("category_id")}&name=${pageContext.request.getParameter("name")}&name2=${pageContext.request.getParameter("name2")}&b=1'><input type="button" value=" 2 "/></a>
            <a href='sameBook.do?parent_id=${pageContext.request.getParameter("parent_id")}&j=0&category_id=${pageContext.request.getParameter("category_id")}&name=${pageContext.request.getParameter("name")}&name2=${pageContext.request.getParameter("name2")}&b=1'><input type="button" value="下一页"/></a>
		</div>
          
    </div>
<!--右侧结束-->
</div>

<div class="clear"></div>
<!--服务部分开始-->
<%@include file="footer.jsp"%>
</body>
</html>
