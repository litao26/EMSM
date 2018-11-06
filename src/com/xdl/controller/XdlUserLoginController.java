package com.xdl.controller;

import com.xdl.bean.XdlUser;
import com.xdl.service.XdlUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.do")
public class XdlUserLoginController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String login_name = request.getParameter("login_name");
        String password = request.getParameter("password");
        XdlUserService userService = new XdlUserService();
        XdlUser  user  = userService.login(login_name,password);
        if(user != null){
            request.getSession().setAttribute("login_name",login_name);
            request.getSession().setAttribute("password",password);
            request.getSession().setAttribute("user",user);
//            response.sendRedirect("book.jsp");
            response.sendRedirect("bookMain.do");
        }else{
            request.setAttribute("msg","登陆失败");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
