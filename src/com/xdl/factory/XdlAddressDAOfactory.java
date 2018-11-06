package com.xdl.factory;

import com.xdl.dao.XdlAddressDAO;
import com.xdl.dao.imp.XdlAddressDAOImp;

public class XdlAddressDAOfactory {
    public static XdlAddressDAO getAddressDAO(){
        return new XdlAddressDAOImp();
    }
}
