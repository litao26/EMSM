package com.xdl.controller;

import com.xdl.bean.XdlUser;
import com.xdl.service.XdlUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userHobby.do")
public class XdlUserHobbyController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String hobby = request.getParameter("hobby");
        XdlUser user = new XdlUser(hobby);
        XdlUserService userService = new XdlUserService();
        boolean rf = userService.userHobbyInfo(user);
        if(rf){
            request.getSession().setAttribute("hobby",hobby);
            response.sendRedirect("userInfo.jsp");
        }else{
            request.setAttribute("msg","修改失败");
        }
    }
}
