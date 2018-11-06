package com.xdl.controller;

import com.xdl.bean.XdlAddress;
import com.xdl.bean.XdlUser;
import com.xdl.service.XdlAddressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addressList.do")
public class XdlAddressListController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        XdlUser user = (XdlUser) request.getSession().getAttribute("user");
        int user_id = user.getUser_id();
/*        XdlAddress address1 = (XdlAddress)request.getSession().getAttribute("address1");
        *//*int user_id = address1.getUser_id();*//*
        int reveive_address_id = address1.getReveive_address_id();*/
//        System.out.println(reveive_address_id);
        XdlAddressService addressService = new XdlAddressService();
        List<XdlAddress> addresses = addressService.userById(user_id);
        request.getSession().setAttribute("addresses",addresses);
        request.getRequestDispatcher("dzgl.jsp").forward(request,response);
    }
}
