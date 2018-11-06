package com.xdl.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/upload.do")
public class XdlFileUploadController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 构建磁盘文件条目工厂类 对应的对象
        DiskFileItemFactory dfif = new DiskFileItemFactory();
        // 构建servlet 文件上传对象
        ServletFileUpload  sfu = new ServletFileUpload(dfif);
        // 使用servlet 文件上传对象 来解析 http 请求
        try {
            List<FileItem> items = sfu.parseRequest(request);
            for(FileItem  fi : items){
                if(fi.isFormField()){
                    // 这代表是普通字段
                    System.out.println(fi.getFieldName() + ":" + fi.getString());
                }else{
                    // 这代表是文件相关的字段
                    System.out.println(fi.getFieldName() + ":" + fi.getName()
                            + ":" + fi.getSize());
                    // 构建一个不重复的文件名
                    String  originName = fi.getName();
                    String  fileName = System.currentTimeMillis() +
                            originName.substring(originName.lastIndexOf("."));
                    //String  filePath = "D:/datas";
                    // 获取到 web服务器中 相对于WebContent下的文件路径即可
                    String  filePath = request.getServletContext().getRealPath("datas");
                    System.out.println("filePath="+filePath);
                    File  file  = new File(filePath+ "/" + fileName);
                    fi.write(file);
                    request.setAttribute("imgPath", "datas/" + fileName);
                    PrintWriter pw = response.getWriter();
                    pw.write(fileName);
                    pw.close();
                    // request.getRequestDispatcher("show.jsp").forward(request, response);
                }
            }
        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
