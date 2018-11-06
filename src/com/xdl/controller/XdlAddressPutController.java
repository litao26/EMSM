package com.xdl.controller;

import com.xdl.bean.XdlAddress;
import com.xdl.service.XdlAddressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addressPut.do")
public class XdlAddressPutController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int reveive_address_id = Integer.parseInt(request.getParameter("id"));
        String  receive_name = request.getParameter("receive_name");
        String province = request.getParameter("province");
        String address = request.getParameter("address");
        String zipcode = request.getParameter("zipcode");
        String mobile =request.getParameter("mobile");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        XdlAddressService addressService = new XdlAddressService();
        XdlAddress address1 = new XdlAddress(receive_name,province,address,zipcode,mobile,telephone,email,reveive_address_id);
        boolean rf = addressService.updateAdddress(address1);
        if(rf){
            response.sendRedirect("addressList.do");
            request.setAttribute("mag", "修改成功");
        }else {
            request.setAttribute("mag", "修改失败");
        }
    }
}
