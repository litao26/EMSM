package com.xdl.dao;

import com.xdl.bean.XdlUser;

public interface XdlUserDAO {
    int insertXdlUser(XdlUser user);
    XdlUser selectXdlUser(String login_name, String password);
    int updateXdlUser(XdlUser user);
    int updateXdlNickname(XdlUser user);
    int updateXdlRealname(XdlUser user);
    int updateXdlPcinfo(XdlUser user);
    int updateXdlContactInfo(XdlUser user);
    int updateXdlHobby(XdlUser user);
}
