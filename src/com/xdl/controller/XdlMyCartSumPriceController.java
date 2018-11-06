package com.xdl.controller;

import com.xdl.bean.XdlCartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/myCartSumPrice.do")
public class XdlMyCartSumPriceController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 从session 取得购物车对象
        List<XdlCartItem> cart  =
                (List<XdlCartItem>)request.getSession().getAttribute("cart");
        int sumPrice = 0;
        for(XdlCartItem it:cart){
            sumPrice += (it.getLower_price() * it.getCount());
        }
        request.getSession().setAttribute("sumPrice", sumPrice);
        String str = "{\"sumPrice\":"+sumPrice+"}";
        response.getWriter().append(str);
    }
}
