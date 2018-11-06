package com.xdl.controller;

import com.xdl.bean.XdlUser;
import com.xdl.service.XdlUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userContactInfo.do")
public class XdlUserContactInfoController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String phone = request.getParameter("phone");
        String msn = request.getParameter("msn");
        String  qq = request.getParameter("qq");
        String website = request.getParameter("website");
        String send_address = request.getParameter("send_address");
        String zipcode = request.getParameter("zipcode");
        XdlUser users = new XdlUser(email,mobile,phone,msn,qq,website,send_address,zipcode);
        XdlUserService userService = new XdlUserService();
        boolean rf = userService.userContactInfo(users);
        if(rf){
            request.getSession().setAttribute("users",users);
            response.sendRedirect("userInfo.jsp");
        }else{
            request.setAttribute("msg","修改失败");
        }
    }
}
