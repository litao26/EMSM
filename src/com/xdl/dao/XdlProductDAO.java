package com.xdl.dao;

import com.xdl.bean.XdlProduct;

import java.util.List;

public interface XdlProductDAO {
    /**
     * 根据分类的编号 按照某个排序标准 排序方式 一页显示多少条 以第几页 来
     * 查询对应的产品列表
     */
    List<XdlProduct>  getProductListByCategoryIdAndOrderStdOrderTypeAndPageSizePageNumber(
            int category_id,String orderStd, String orderType,int pageSize,int pageNumber
    );
    List<XdlProduct>  getPublishingListByParentId();
    /** 提供一个根据id 获取商品信息的方法*/
    XdlProduct   getProductByProductId(int  product_id);

}
