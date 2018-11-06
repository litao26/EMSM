package com.xdl.service;

import com.xdl.bean.XdlCartItem;
import com.xdl.bean.XdlProduct;
import com.xdl.dao.XdlProductDAO;
import com.xdl.factory.XdlProductDAOfactory;

import java.util.List;

public class XdlProductService {
    private XdlProductDAO productDao;
    public XdlProductService(){
        productDao = XdlProductDAOfactory.getProductDAO();
    }
    public List<XdlProduct> productList(
            int  category_id,String orderStd,String orderType,int  pageSize,
            int  pageNumber){
            return productDao.getProductListByCategoryIdAndOrderStdOrderTypeAndPageSizePageNumber(
                    category_id, orderStd, orderType, pageSize, pageNumber
            );
    }
    public  List<XdlProduct> publishing(){
        return  productDao.getPublishingListByParentId();
    }
    public  XdlProduct    productById(int product_id){
        return  productDao.getProductByProductId(product_id);
    }
    /** 根据商品id  最终获取一个购物车条目 */
    public XdlCartItem productChangeToCartItem(int product_id, int user_id){
        // 获取到商品信息
        XdlProduct   product  = productDao.getProductByProductId(product_id);
        // 根据 user_id 来计算这个商品对应的 返现 和 积分
        if(product != null ){
            XdlCartItem  item  =
                    new  XdlCartItem(product.getProduct_id(),
                            product.getPicture(), product.getName(),
                            product.getLower_price(), 0, 0, 1);
            return item;
        }else{
            return null;
        }
    }
}
