package com.xdl.dao.imp;

import com.xdl.bean.XdlInterest;
import com.xdl.dao.XdlInterestDAO;
import com.xdl.util.DbcpUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XdlInterestDAOImp implements XdlInterestDAO {
    @Override
    public int insertInterest(XdlInterest interest) {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DbcpUtil.getConnection();
        try {
            String sql = "insert into xdl_interest values(xdl_interest_interest_id_seq.nextval,?,?,sysdate,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, interest.getUser_id());
            ps.setInt(2, interest.getProduct_id());
            ps.setString(3, interest.getBak());
            int rows = ps.executeUpdate();
            return rows;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            DbcpUtil.releaseResource(conn, ps, null);
        }
        return 0;
    }

    @Override
    public List<XdlInterest> getInterest() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<XdlInterest> datas = new ArrayList<XdlInterest>();
        String sql = "select * from xdl_interest";
        conn = DbcpUtil.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                XdlInterest interest = new XdlInterest();
                interest.setId(rs.getInt("id"));
                interest.setUser_id(rs.getInt("user_id"));
                interest.setProduct_id(rs.getInt("product_id"));
                interest.setCollect_time(rs.getTimestamp("collect_time"));
                interest.setBak(rs.getString("bak"));
                datas.add(interest);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DbcpUtil.releaseResource(conn, ps, rs);
        }
        return datas;
    }

    @Override
    public int deleteInterest(XdlInterest interest) {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DbcpUtil.getConnection();
        try {
            String sql= "delete from xdl_interest where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,interest.getId());
            int rows = ps.executeUpdate();
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbcpUtil.releaseResource(conn,ps,null);
        }
        return 0;
    }
}
