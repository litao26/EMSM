package com.xdl.service;

import com.xdl.bean.XdlInterest;
import com.xdl.dao.XdlInterestDAO;
import com.xdl.factory.XdlInterestDAOfactory;

import java.util.List;

public class XdlInterestService {
    private XdlInterestDAO interestDao;
    public XdlInterestService(){
        interestDao = XdlInterestDAOfactory.setInterest();
    }
    public boolean setInterest(XdlInterest interest){
        return interestDao.insertInterest(interest)==1?true:false;
    }
    public List<XdlInterest> getInterest(){
        return interestDao.getInterest();
    }
    public  boolean delInterest(XdlInterest interest){
        return interestDao.deleteInterest(interest)==1?true:false;
    }
}
