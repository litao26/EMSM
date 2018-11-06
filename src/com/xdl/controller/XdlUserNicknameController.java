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

@WebServlet("/userNickname.do")
public class XdlUserNicknameController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String nick_name = request.getParameter("nick_name");
        XdlUser user = new XdlUser(nick_name);
        XdlUserService userService = new XdlUserService();
        boolean rf = userService.userInfoNickname(user);
        System.out.println(rf);
        if(rf){
            request.getSession().setAttribute("nick_name",nick_name);
            response.sendRedirect("userInfo.jsp");
        }else{
            request.setAttribute("msg","修改失败");
        }
    }
}
