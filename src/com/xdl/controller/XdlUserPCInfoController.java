package com.xdl.controller;

import com.xdl.bean.XdlUser;
import com.xdl.service.XdlUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/userPcInfo.do")
public class XdlUserPCInfoController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String sex = request.getParameter("sex");
        String str = request.getParameter("birth");
        try {
            java.util.Date date = sdf.parse(str);
            String str1 = sdf.format(date);
            Timestamp birth = ts.valueOf(str1);
            String location = request.getParameter("location");
            String school = request.getParameter("school");
            String company = request.getParameter("company");
            String card_number = request.getParameter("card_number");
            XdlUser user = new XdlUser(sex,birth,location,school,company,card_number);
            XdlUserService userService = new XdlUserService();
            boolean rf = userService.userPcInfo(user);
            if(rf){
                request.getSession().setAttribute("user",user);
                response.sendRedirect("userInfo.jsp");
            }else{
                request.setAttribute("msg","修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
