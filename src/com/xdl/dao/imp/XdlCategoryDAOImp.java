package com.xdl.dao.imp;

import com.xdl.bean.XdlCategory;
import com.xdl.dao.XdlCategoryDAO;
import com.xdl.util.DbcpUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XdlCategoryDAOImp implements XdlCategoryDAO {
    @Override
    public List<XdlCategory> getXdlCategoryListByParentId(int parent_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<XdlCategory> datas = new ArrayList<>();
        //加载驱动 获取连接
        conn = DbcpUtil.getConnection();
        try {
            // 定义sql 获取sql执行环境
            String sql = "select * from xdl_category where parent_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,parent_id);
            rs = ps.executeQuery();
            while (rs.next()){
                XdlCategory category = new XdlCategory(rs.getInt("category_id"),
                        rs.getString("name"),rs.getInt("turn"),
                        rs.getString("description"),rs.getInt("parent_id"));
                    datas.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbcpUtil.releaseResource(conn,ps,rs);
        }
        return datas;
    }
}
