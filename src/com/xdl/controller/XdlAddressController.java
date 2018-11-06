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

@WebServlet("/address.do")
public class XdlAddressController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        XdlUser user = (XdlUser) request.getSession().getAttribute("user");
        int user_id = user.getUser_id();
        String receive_name = request.getParameter("receive_name");
        String province = request.getParameter("province");
        String address = request.getParameter("address");
        String zipcode = request.getParameter("zipcode");
        String mobile = request.getParameter("mobile");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        XdlAddress address1 = new XdlAddress(user_id,receive_name,province,address,zipcode,mobile,telephone,email);
        XdlAddressService addressService = new XdlAddressService();
        boolean rf = addressService.address(address1);
        if(rf){
            request.getSession().setAttribute("reveive_address_id",address1.getReveive_address_id());
            request.getSession().setAttribute("receive_name",receive_name);
            request.getSession().setAttribute("province",province);
            request.getSession().setAttribute("address",address);
            request.getSession().setAttribute("zipcode",zipcode);
            request.getSession().setAttribute("mobile",mobile);
            request.getSession().setAttribute("telephone",telephone);
            request.getSession().setAttribute("email",email);
            request.getSession().setAttribute("address1",address1);
            response.sendRedirect("addressList.do");
        }else{
            request.setAttribute("msg","增加失败");
        }
    }
}
