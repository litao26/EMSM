package com.xdl.test;

import com.xdl.bean.XdlUser;
import com.xdl.dao.XdlUserDAO;
import com.xdl.dao.imp.XdlUserDAOImp;
import com.xdl.service.XdlUserService;

import java.sql.Timestamp;

public class XdlUserServiceTest {
    public static void main(String [] args){
        Timestamp ts = new Timestamp(System.currentTimeMillis());

        String str = "1999-10-1 10:10:10";

        try{

           ts = ts.valueOf(str);

        }catch (Exception e){
            e.printStackTrace();
        }
        XdlUserDAO userDAO = new XdlUserDAOImp();
        XdlUser user = new XdlUser("liweijie","123456","男",ts,"北京","XDl","xdl","123456");
        System.out.println(userDAO.updateXdlPcinfo(user));
    }
}
