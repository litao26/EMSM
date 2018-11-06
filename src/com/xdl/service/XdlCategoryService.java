package com.xdl.service;

import com.xdl.bean.XdlCategory;
import com.xdl.dao.XdlCategoryDAO;
import com.xdl.factory.XdlCategoryDAOfactory;

import java.util.List;

public class XdlCategoryService {
    private XdlCategoryDAO categoryDAO;
    public XdlCategoryService(){
        categoryDAO = XdlCategoryDAOfactory.getCategoryDAO();
    }
    public List<XdlCategory> subCategories(int parent_id){
        return categoryDAO.getXdlCategoryListByParentId(parent_id);
    }
}
