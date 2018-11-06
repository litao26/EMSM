package com.xdl.dao;

import com.xdl.bean.XdlInterest;

import java.util.List;

public interface XdlInterestDAO {
    int insertInterest(XdlInterest interest);
    List<XdlInterest> getInterest();
    int deleteInterest(XdlInterest interest);
}
