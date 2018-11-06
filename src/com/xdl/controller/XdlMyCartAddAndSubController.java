package com.xdl.controller;

import com.xdl.bean.XdlCartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/myCartAddAndSub.do")
public class XdlMyCartAddAndSubController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int product_id = Integer.parseInt(request.getParameter("product_id"));
        int tag =Integer.parseInt(request.getParameter("tag"));
        // 从session 取得购物车对象
        List<XdlCartItem> cart  =
                (List<XdlCartItem>)request.getSession().getAttribute("cart");
        if(tag>0) {
            for(int i = 0;i<cart.size();i++) {
                XdlCartItem item=cart.get(i);
                if(item.getProduct_id()==product_id) {
                    item.setCount(item.getCount()+1);
                }
            }
        }else {
            for(int i = 0;i<cart.size();i++) {
                XdlCartItem item=cart.get(i);
                if(item.getProduct_id()==product_id) {
                    item.setCount(item.getCount()-1);
                }
            }
        }
    }
}
