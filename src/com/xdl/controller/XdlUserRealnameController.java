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

@WebServlet("/userRealname.do")
public class XdlUserRealnameController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String real_name = request.getParameter("real_name");
        XdlUser user = new XdlUser(real_name);
        XdlUserService userService = new XdlUserService();
        boolean rf = userService.userInfoRealname(user);
        PrintWriter pw = response.getWriter();
        if(rf){
            request.getSession().setAttribute("real_name",real_name);
            response.sendRedirect("userInfo.jsp");
        }else{
            request.setAttribute("msg","修改失败");
        }
        pw.close();
    }
}
