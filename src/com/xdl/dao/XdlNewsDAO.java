package com.xdl.dao;

import com.xdl.bean.XdlCategory;
import com.xdl.bean.XdlNews;

import java.util.List;

public interface XdlNewsDAO {
    List<XdlNews> getXdlNewsListByParentId(String title);
}
