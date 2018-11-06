package com.xdl.controller;

import com.xdl.bean.XdlInterest;
import com.xdl.bean.XdlUser;
import com.xdl.service.XdlInterestService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/favorAdd.do")
public class XdlFavorAddController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int product_id = Integer.parseInt(request.getParameter("product_id"));
        XdlUser user = (XdlUser)request.getSession().getAttribute("user");
        int user_id = user.getUser_id();
        String bak = "空";
        XdlInterestService servive = new XdlInterestService();
        XdlInterest interest = new XdlInterest(user_id, product_id,bak);
        boolean rf = servive.setInterest(interest);
        System.out.println(rf);
        if(rf){
            String jsonStr = JSONArray.fromObject(interest).toString();
            PrintWriter pw = response.getWriter();
            pw.write(jsonStr);
            pw.close();
            request.setAttribute("msg","添加成功");
        }else{
            request.setAttribute("msg","添加失败");
        }

    }
}
