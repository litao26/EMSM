package com.xdl.controller;

import com.xdl.bean.XdlCategory;
import com.xdl.bean.XdlNews;
import com.xdl.bean.XdlProduct;
import com.xdl.service.XdlCategoryService;
import com.xdl.service.XdlNewsService;
import com.xdl.service.XdlProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookMain.do")
public class XdlBookMainController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        XdlCategoryService categoryService = new XdlCategoryService();
        List<XdlCategory> categories = categoryService.subCategories(0);
        XdlNewsService newsService = new XdlNewsService();
        request.setAttribute("categories",categories);
        List<XdlNews> news = newsService.subNews("xinwen");
        request.setAttribute("news",news);
        XdlProductService productService = new XdlProductService();
        List<XdlProduct> product =  productService.publishing();
        request.setAttribute("product",product);
        request.getRequestDispatcher("book.jsp").forward(request,response);
    }
}
