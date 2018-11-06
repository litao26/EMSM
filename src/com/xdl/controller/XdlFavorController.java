package com.xdl.controller;

import com.xdl.bean.XdlCartItem;
import com.xdl.bean.XdlInterest;
import com.xdl.bean.XdlUser;
import com.xdl.service.XdlInterestService;
import com.xdl.service.XdlProductService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/favor.do")
public class XdlFavorController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取当前登录账号的id
        XdlUser user = (XdlUser) request.getSession().getAttribute("user");
        int user_id = user.getUser_id();
        //用来展示收藏内容
        XdlInterestService interestService = new XdlInterestService();
        List<XdlInterest> interest_time = interestService.getInterest();
        List<XdlCartItem> itemFavors = new ArrayList<>();
        XdlProductService productService = new XdlProductService();
        for(XdlInterest interest :interest_time){
            int product_id = interest.getProduct_id();
            int id = interest.getId();
            request.getSession().setAttribute("id",id);
            XdlCartItem item = productService.productChangeToCartItem(product_id, user_id);
            itemFavors.add(item);
        }

        request.getSession().setAttribute("interest_time", interest_time);
        request.getSession().setAttribute("itemFavors", itemFavors);
        System.out.println("拿到收藏列表对应的对象了");
        System.out.println("itemFavors="+itemFavors);
        String jsonStr = JSONArray.fromObject(itemFavors).toString();
        PrintWriter pw = response.getWriter();
        pw.write(jsonStr);
        pw.close();
    }
}
