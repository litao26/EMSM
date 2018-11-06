package com.xdl.controller;

import com.xdl.bean.XdlUser;
import com.xdl.service.XdlUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register.do")
public class XdlUserRegisterController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    String login_name = request.getParameter("login_name");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    String recommender = request.getParameter("recommender");
        XdlUser user = new XdlUser(login_name,password,email,recommender);
        XdlUserService userService = new XdlUserService();
        boolean rf = userService.register(user);
        if(rf){
            response.sendRedirect("registerOk.jsp");
        }else {
            request.setAttribute("msg","注册失败");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }
}
