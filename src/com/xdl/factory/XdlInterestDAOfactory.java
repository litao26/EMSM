package com.xdl.factory;

import com.xdl.dao.XdlInterestDAO;
import com.xdl.dao.imp.XdlInterestDAOImp;

public class XdlInterestDAOfactory {
    public static XdlInterestDAO setInterest(){
        return new XdlInterestDAOImp();
    }
}
