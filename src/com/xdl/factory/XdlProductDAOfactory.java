package com.xdl.factory;

import com.xdl.dao.XdlProductDAO;
import com.xdl.dao.imp.XdlProductDAOImp;

public class XdlProductDAOfactory {
    public static XdlProductDAO getProductDAO(){
        return new XdlProductDAOImp();
    }
}
