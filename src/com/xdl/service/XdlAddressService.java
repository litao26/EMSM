package com.xdl.service;

import com.xdl.bean.XdlAddress;
import com.xdl.dao.XdlAddressDAO;
import com.xdl.factory.XdlAddressDAOfactory;

import java.util.List;

public class XdlAddressService {
    XdlAddressDAO addressDAO;
    public  XdlAddressService(){
        addressDAO = XdlAddressDAOfactory.getAddressDAO();
    }
    public boolean address(XdlAddress address){
        return addressDAO.insertXdlAddress(address)==1?true:false;
    }
    public List<XdlAddress> userById(int user_id){
        return addressDAO.getAddressById(user_id);
    }
    public boolean deleteAddress(XdlAddress address){
        return  addressDAO.deleteXdlAddress(address)==1?true:false;
    }
    public boolean updateAdddress(XdlAddress address){
        return  addressDAO.updateAddress(address)==1?true:false;
    }
}
