package com.xdl.factory;

import com.xdl.bean.XdlNews;
import com.xdl.dao.XdlNewsDAO;
import com.xdl.dao.imp.XdlNewsDAOImp;

public class XdlNewsDAOfactory {
    public static XdlNewsDAO getNewsDAO(){
        return new XdlNewsDAOImp();
    }
}
