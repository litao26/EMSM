package com.xdl.servlet.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/validCode.do")
public class XdlValideCodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String number = (String) request.getSession().getAttribute("number");
        PrintWriter pw = response.getWriter();
        if(code.equals(number)){
            pw.write("true");
        }else{
            pw.write("false");
        }
        pw.close();
    }
}
