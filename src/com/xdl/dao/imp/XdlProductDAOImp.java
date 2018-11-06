package com.xdl.dao.imp;

import com.xdl.bean.XdlProduct;
import com.xdl.dao.XdlProductDAO;
import com.xdl.util.DbcpUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XdlProductDAOImp implements XdlProductDAO {
    @Override
    public List<XdlProduct> getProductListByCategoryIdAndOrderStdOrderTypeAndPageSizePageNumber(int category_id, String orderStd, String orderType, int pageSize, int pageNumber) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<XdlProduct> products  = new ArrayList<>();
        //1.加载驱动 2.获取链接
        conn = DbcpUtil.getConnection();
        //3.定义sql 获取sql执行环境
        try {
            //最内层 负责排序
            String sql ="select p.* from xdl_product p,xdl_category_product cp where  " +
                    " p.product_id = cp.product_id and cp.category_id = ? " +
                    " order by "+orderStd+"  "+ orderType;
            //中间层 负责编号 起别名 部分过滤
            sql = "select rownum r,t.* from("+sql+")t where rownum<?";
            //最外层 负责使用别名 进行过滤
            sql = "select * from ("+sql+") where r > ?";
            ps = conn.prepareStatement(sql);
            //设置参数
            ps.setInt(1,category_id);
            ps.setInt(2,pageNumber* pageSize+1);
            ps.setInt(3,(pageNumber-1)*pageSize);
            //4.执行sql 获取结果集
            rs = ps.executeQuery();
            while(rs.next()){
                // 使用结果集数据构建 产品对象
                XdlProduct product = new XdlProduct();
                product.setProduct_id(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setPicture(rs.getString("picture"));
                product.setPublish_time(rs.getTimestamp("publish_time"));
                product.setFixed_price(rs.getDouble("fixed_price"));
                product.setLower_price(rs.getDouble("lower_price"));
                product.setAuthor(rs.getString("author"));
                product.setPublishing(rs.getString("publishing"));
                product.setPrint_number(rs.getInt("print_number"));
                product.setAdd_time(rs.getTimestamp("add_time"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbcpUtil.releaseResource(conn,ps,rs);
        }
        return products;
    }

    @Override
    public List<XdlProduct> getPublishingListByParentId() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<XdlProduct> products  = new ArrayList<>();
        //1.加载驱动 2.获取链接
        conn = DbcpUtil.getConnection();
        //3.定义sql 获取sql执行环境
        try {
            String sql = "select * from XDL_PRODUCT";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                XdlProduct product = new XdlProduct(rs.getString("publishing"),rs.getTimestamp("publish_time"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbcpUtil.releaseResource(conn,ps,rs);
        }
        return products;
    }

    @Override
    public XdlProduct getProductByProductId(int product_id) {
        Connection  conn = null;
        PreparedStatement  ps = null;
        ResultSet   rs  = null;
        //1.加载驱动  2.获取连接
        conn = DbcpUtil.getConnection();
        try {
            //3.定义sql  获取sql 执行环境
            String sql = "select * from xdl_product where product_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, product_id);
            //4.执行sql 获取结果集
            rs = ps.executeQuery();
            if(rs.next()){
                // 使用结果集数据构建 产品对象
                XdlProduct product = new XdlProduct();
                product.setProduct_id(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setPicture(rs.getString("picture"));
                product.setPublish_time(rs.getTimestamp("publish_time"));
                product.setFixed_price(rs.getDouble("fixed_price"));
                product.setLower_price(rs.getDouble("lower_price"));
                product.setAuthor(rs.getString("author"));
                product.setPublishing(rs.getString("publishing"));
                product.setPrint_number(rs.getInt("print_number"));
                return product;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //5.释放资源
            DbcpUtil.releaseResource(conn, ps, rs);
        }
        return   null;
    }
}
