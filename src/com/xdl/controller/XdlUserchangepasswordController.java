package com.xdl.controller;

import com.xdl.bean.XdlUser;
import com.xdl.service.XdlUserService;
import com.xdl.util.Md5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changepassword.do")
public class XdlUserchangepasswordController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String password1 = request.getSession().getAttribute("password").toString();
        String pass= request.getParameter("password");
        String password = request.getParameter("new_password");
        String login_name = request.getSession().getAttribute("login_name").toString();
        XdlUserService userService = new XdlUserService();
        if(password1.equals(pass)) {
            XdlUser user = new XdlUser(login_name,password);
            boolean rf = userService.changepassword(user);
            System.out.println(rf);
            if (rf) {
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("mag", "修改失败");
                request.getRequestDispatcher("changepassword.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("mag", "修改失败");
            request.getRequestDispatcher("changepassword.jsp").forward(request, response);
        }
    }
}
