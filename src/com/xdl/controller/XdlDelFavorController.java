package com.xdl.controller;

import com.xdl.bean.XdlInterest;
import com.xdl.service.XdlInterestService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/delFavor.do")
public class XdlDelFavorController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(request.getSession().getAttribute("id").toString());
        XdlInterestService interestService = new XdlInterestService();
        XdlInterest interest = new XdlInterest(id);
        boolean rf = interestService.delInterest(interest);
        if(rf){
            String jsonStr = JSONArray.fromObject(interest).toString();
            PrintWriter pw = response.getWriter();
            pw.write(jsonStr);
            pw.close();
            request.setAttribute("msg","删除成功");
        }else{
            request.setAttribute("msg","删除失败");
        }
    }
}
