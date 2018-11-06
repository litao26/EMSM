package com.xdl.controller;

import com.xdl.bean.XdlCartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/myCartCookie.do")
public class XdlMyCartCookieController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从session 取得购物车对象
        List<XdlCartItem> cart  =
                (List<XdlCartItem>)request.getSession().getAttribute("cart");
        String cookieStr = "";
        for(XdlCartItem item: cart) {
            cookieStr = cookieStr+item.getProduct_id()+"#";
        }
        Cookie cookie = new Cookie("cookie",cookieStr);
        cookie.setMaxAge(10000);
        response.addCookie(cookie);
        response.sendRedirect("logout.jsp");
    }
}
