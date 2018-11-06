package com.xdl.controller;

import com.xdl.bean.XdlCategory;
import com.xdl.service.XdlCategoryService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/categoryListAJAX.do")
public class XdlCategoryListAJAX extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        XdlCategoryService categoryService = new XdlCategoryService();
        List<XdlCategory> categories = categoryService.subCategories(0);
        //把列表转换成JSON字符串
        String jsonStr = JSONArray.fromObject(categories).toString();
        PrintWriter pw = response.getWriter();
        pw.write(jsonStr);
        pw.close();
    }
}
