package com.xdl.controller;

import com.xdl.bean.XdlCartItem;
import com.xdl.service.XdlProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/myCartLoadCookie.do")
public class XdlMyCartLoadCookieController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        XdlProductService productService = new  XdlProductService();

        List<XdlCartItem> cart  =
                (List<XdlCartItem>)request.getSession().getAttribute("cart");
        if(cart == null){
            cart = new ArrayList<>();
            //取得cookie对象 存放的product_id 按照 # 拆分   放入购物车
            Cookie[] cookies = request.getCookies();
            Cookie cookie = null;
            for(int i = 0;i<cookies.length;i++) {
                if("cookie".equals(cookies[i].getName())) {
                    cookie = cookies[i];
                }
            }
            //如果cookie存在 则取
            if(cookie != null) {
                System.out.println("开始取得cookie了啊");
                String[] strs = cookie.getValue().split("#");
                int[] is  = new int[strs.length];
                for (int i = 0; i < strs.length; i++) {
                    int cookie_product_id=Integer.parseInt(strs[i]);
                    XdlCartItem cookieItem =
                            productService.productChangeToCartItem(cookie_product_id, 0);
                    cart.add(cookieItem);
                }
                cookie.setMaxAge(0);
            }
            request.getSession().setAttribute("cart", cart);
        }
    }
}
