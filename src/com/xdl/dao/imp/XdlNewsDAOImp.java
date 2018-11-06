package com.xdl.dao.imp;

import com.xdl.bean.XdlCategory;
import com.xdl.bean.XdlNews;
import com.xdl.dao.XdlNewsDAO;
import com.xdl.util.DbcpUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XdlNewsDAOImp implements XdlNewsDAO {

    @Override
    public List<XdlNews> getXdlNewsListByParentId(String title) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<XdlNews> datas = new ArrayList<>();
        //加载驱动 获取连接
        conn = DbcpUtil.getConnection();
        try {
            String sql = "select * from xdl_news where title=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,title);
            rs = ps.executeQuery();
            while (rs.next()){
                XdlNews news = new XdlNews(rs.getInt("id"),
                        rs.getString("title"),rs.getString("content"),
                        rs.getTimestamp("release_time"),rs.getString("sticky"));
                datas.add(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbcpUtil.releaseResource(conn,ps,rs);
        }
        return datas;
    }
}
