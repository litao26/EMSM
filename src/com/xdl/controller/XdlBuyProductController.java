package com.xdl.controller;

import com.xdl.bean.XdlCartItem;
import com.xdl.bean.XdlProduct;
import com.xdl.service.XdlProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/buyProduct.do")
public class XdlBuyProductController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int   product_id  = Integer.parseInt(request.getParameter("product_id"));
        XdlProductService  productService  = new XdlProductService();
        XdlProduct  product = productService.productById(product_id);
        List<XdlCartItem> cart = null;
        // 根据商品信息 构建一个购物车条目对象
        if(product != null) {
            XdlCartItem cartItem = new XdlCartItem(product.getProduct_id(),
                    product.getPicture(), product.getName(),
                    product.getLower_price(), 0.0, 0, 1);
            // 从session 中获取购物车
            cart =(List<XdlCartItem>)request.getSession()
                    .getAttribute("cart");
            if(cart == null){
                cart  = new ArrayList<>();
                request.getSession().setAttribute("cart", cart);
            }
            // 判断购物车中是否存在这个购物车条目
            if(cart.contains(cartItem)){
                for(XdlCartItem  ct : cart){
                    if(ct.equals(cartItem)){
                        ct.setCount(ct.getCount() + 1);
                        break;
                    }
                }
            }else{
                cart.add(cartItem);
            }
        }
        // 计算买了几个商品  以及总金额
        int  sumCount = 0;
        double  sumPrice = 0;
        double lower_price = 0;
        String picture = "";
        String name = "";
        for(XdlCartItem  item:cart){
            picture = item.getPicture();
            lower_price = item.getLower_price();
            name = item.getName();
            sumCount += item.getCount();
            sumPrice += (item.getLower_price() * item.getCount());
        }
        request.setAttribute("picture",picture);
        request.setAttribute("lower_price",lower_price);
        request.setAttribute("name",name);
        request.setAttribute("sumCount", sumCount);
        request.getSession().setAttribute("sumPrice", sumPrice);
        request.getRequestDispatcher("initCart.jsp").forward(request, response);
    }
}
