package com.xdl.dao;

import com.xdl.bean.XdlCategory;

import java.util.List;

public interface XdlCategoryDAO {
    List<XdlCategory> getXdlCategoryListByParentId(int parent_id);
}
