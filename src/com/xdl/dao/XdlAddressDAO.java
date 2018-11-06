package com.xdl.dao;

import com.xdl.bean.XdlAddress;

import java.util.List;

public interface XdlAddressDAO {
    int insertXdlAddress(XdlAddress address);
    List<XdlAddress> getAddressById (int user_id);
    int deleteXdlAddress(XdlAddress address);
    int updateAddress(XdlAddress address);
}
