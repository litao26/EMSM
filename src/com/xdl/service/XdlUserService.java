package com.xdl.service;

import com.xdl.bean.XdlUser;
import com.xdl.dao.XdlUserDAO;
import com.xdl.dao.imp.XdlUserDAOImp;
import com.xdl.factory.XdlUserDAOfactory;

public class XdlUserService {
    //真正完成数据库访问的对象
    private XdlUserDAO userDAO;
    public XdlUserService(){
        //给userDao赋值
        //userDAO = new XdlUserDAOImp();
        userDAO = XdlUserDAOfactory.getUserDAO();
    }
    //判断注册是否成功
    public boolean register(XdlUser user){
        return userDAO.insertXdlUser(user)==1?true:false;
    }
    //判断登陆是否成功
    public XdlUser login(String login_name,String password){
        return userDAO.selectXdlUser(login_name,password);
    }
    public boolean changepassword(XdlUser user){
        return userDAO.updateXdlUser(user)==1?true:false;
    }
    public boolean userInfoNickname(XdlUser user){
        return userDAO.updateXdlNickname(user)==1?true:false;
    }
    public boolean userInfoRealname(XdlUser user){
        return userDAO.updateXdlRealname(user)==1?true:false;
    }
    public boolean userPcInfo(XdlUser user){
        return userDAO.updateXdlPcinfo(user)==1?true:false;
    }
    public boolean userContactInfo(XdlUser user){
        return userDAO.updateXdlContactInfo(user)==1?true:false;
    }
    public boolean userHobbyInfo(XdlUser user){
        return  userDAO.updateXdlHobby(user)==1?true:false;
    }
}
