package com.xdl.controller;

import com.xdl.bean.XdlCategory;
import com.xdl.bean.XdlProduct;
import com.xdl.service.XdlCategoryService;
import com.xdl.service.XdlProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookList.do")
public class XdlBookListController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        int parent_id = Integer.parseInt(request.getParameter("parent_id"));
        String orderStd = " ";
        String orderType = " ";
        String j = request.getParameter("j");
        if("lower_price".equals(j)){
            orderStd = "lower_price";
            orderType = "asc";
        }else if("add_time".equals(j)){
            orderStd = "add_time";
            orderType = "desc";
        }else if("publish_time".equals(j)){
            orderStd = "publish_time";
            orderType = "desc";
        }else{
            orderStd = "print_number";
            orderType = "desc";
        }
        String b = request.getParameter("b");
        int pageNumber = 0;
        if("1".equals(b)){
            pageNumber=2;
        }else{
            pageNumber=1;
        }
        //构建service对象 获取对应的子分类列表
        XdlCategoryService categoryService = new XdlCategoryService();
        List<XdlCategory> categories = categoryService.subCategories(parent_id);
        request.setAttribute("categories",categories);
        // 取得第一子分类 对象
        XdlCategory category = categories.isEmpty() ? null : categories.get(0);
        int category_id = -1;
        if (category != null) {
            category_id = category.getCategory_id();
        }
        // 根据产品的服务对象 获取 产品列表
        XdlProductService productService = new XdlProductService();
        List<XdlProduct> products = productService.productList(category_id, orderStd, orderType, 3, pageNumber);
        request.setAttribute("products", products);
        request.getRequestDispatcher("book_list.jsp").forward(request,response);
    }
}
