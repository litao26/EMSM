package com.xdl.factory;

import com.xdl.dao.XdlCategoryDAO;
import com.xdl.dao.imp.XdlCategoryDAOImp;

public class XdlCategoryDAOfactory {
    public static XdlCategoryDAO getCategoryDAO(){
        return new XdlCategoryDAOImp();
    }
}
