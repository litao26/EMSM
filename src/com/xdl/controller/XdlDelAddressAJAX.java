package com.xdl.controller;

import com.xdl.bean.XdlAddress;
import com.xdl.bean.XdlCartItem;
import com.xdl.bean.XdlNews;
import com.xdl.bean.XdlUser;
import com.xdl.service.XdlAddressService;
import com.xdl.service.XdlNewsService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/delAddressAJAX.do")
public class XdlDelAddressAJAX extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int reveive_address_id = Integer.parseInt(request.getParameter("reveive_address_id"));
        XdlAddressService addressService = new XdlAddressService();
        List<XdlAddress>  addresses  = (List<XdlAddress>)request.getSession().getAttribute("addresses");
        XdlAddress address = new XdlAddress(reveive_address_id);
        boolean rf = addressService.deleteAddress(address);
        if(rf) {
            XdlAddress removeItem = null;
            for (int i = 0; i < addresses.size(); i++) {
                XdlAddress item = addresses.get(i);
                if (item.getReveive_address_id() == reveive_address_id) {
                    addresses.remove(i);
                    removeItem = item;
                }
            }
            //把列表转换成JSON字符串
            String jsonStr = JSONArray.fromObject(removeItem).toString();
            PrintWriter pw = response.getWriter();
            pw.write(jsonStr);
            pw.close();
        }else{
            request.setAttribute("msg","删除失败");
        }
    }
}
