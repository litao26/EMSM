package com.xdl.controller;

import com.xdl.bean.XdlProduct;
import com.xdl.service.XdlProductService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/productListAJAX.do")
public class XdlProductListAJAX extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        XdlProductService productService = new XdlProductService();
        List<XdlProduct> product = productService.publishing();
        String jsonStr  = JSONArray.fromObject(product).toString();
        PrintWriter pw = response.getWriter();
        pw.write(jsonStr);
        pw.close();
    }
}
