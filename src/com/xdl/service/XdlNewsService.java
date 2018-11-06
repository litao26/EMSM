package com.xdl.service;

import com.xdl.bean.XdlNews;
import com.xdl.dao.XdlNewsDAO;
import com.xdl.factory.XdlNewsDAOfactory;

import java.util.List;

public class XdlNewsService {
    private XdlNewsDAO newsDAO;
    public XdlNewsService(){
        newsDAO = XdlNewsDAOfactory.getNewsDAO();
    }
    public List<XdlNews>  subNews(String title){
        return  newsDAO.getXdlNewsListByParentId(title);
    }
}
