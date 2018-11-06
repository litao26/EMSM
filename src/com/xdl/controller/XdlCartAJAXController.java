package com.xdl.controller;

import com.xdl.bean.XdlCartItem;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/myCartAJAX.do")
public class XdlCartAJAXController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int product_id =  Integer.parseInt(request.getParameter("product_id")) ;
        // 从session 取得购物车对象
        List<XdlCartItem> cart  =
                (List<XdlCartItem>)request.getSession().getAttribute("cart");
        XdlCartItem removeItem = null;
        for(int i = 0;i<cart.size();i++) {
            XdlCartItem item=cart.get(i);
            if(item.getProduct_id()==product_id) {
                cart.remove(i);
                removeItem = item;
            }
        }
        String jsonStr = JSONObject.fromObject(removeItem).toString();
        response.getWriter().append(jsonStr);
    }
}
