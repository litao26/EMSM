package com.xdl.factory;

import com.xdl.dao.XdlUserDAO;
import com.xdl.dao.imp.XdlUserDAOImp;

public class XdlUserDAOfactory {
    //可以提供XdlUserDAO的实现类的对象
    public static XdlUserDAO getUserDAO(){
        return new XdlUserDAOImp();
    }
}
