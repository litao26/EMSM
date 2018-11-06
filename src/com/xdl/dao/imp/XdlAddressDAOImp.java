package com.xdl.dao.imp;

import com.xdl.bean.XdlAddress;
import com.xdl.bean.XdlProduct;
import com.xdl.dao.XdlAddressDAO;
import com.xdl.util.DbcpUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XdlAddressDAOImp implements XdlAddressDAO {
    @Override
    public int insertXdlAddress(XdlAddress address) {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DbcpUtil.getConnection();
        try {
            String sql = "insert into xdl_receive_address(reveive_address_id,user_id,receive_name,province,address,zipcode,mobile,telephone,email) values(xdl_receive_address_id_seq.nextval,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,address.getUser_id());
            ps.setString(2,address.getReceive_name());
            ps.setString(3,address.getProvince());
            ps.setString(4,address.getAddress());
            ps.setString(5,address.getZipcode());
            ps.setString(6,address.getMobile());
            ps.setString(7,address.getTelephone());
            ps.setString(8,address.getEmail());
            int rows = ps.executeUpdate();
            return  rows;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbcpUtil.releaseResource(conn,ps,null);
        }
        return 0;
    }

    @Override
    public List<XdlAddress> getAddressById(int user_id) {
        Connection  conn = null;
        PreparedStatement  ps = null;
        ResultSet rs  = null;
        List<XdlAddress> datas= new ArrayList<>();
        //1.加载驱动  2.获取连接
        conn = DbcpUtil.getConnection();
        try {
            //3.定义sql  获取sql 执行环境
            String sql = "select * from XDL_RECEIVE_ADDRESS where user_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,user_id);
            //4.执行sql 获取结果集
            rs = ps.executeQuery();
            while (rs.next()){
                // 使用结果集数据构建 产品对象
               XdlAddress address1 = new XdlAddress();
               address1.setReveive_address_id(rs.getInt("reveive_address_id"));
               address1.setUser_id(rs.getInt("user_id"));
               address1.setReceive_name(rs.getString("receive_name"));
               address1.setProvince(rs.getString("province"));
                address1.setAddress(rs.getString("address"));
                address1.setZipcode(rs.getString("zipcode"));
                address1.setMobile(rs.getString("mobile"));
                address1.setTelephone(rs.getString("telephone"));
                address1.setEmail(rs.getString("email"));
                datas.add(address1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //5.释放资源
            DbcpUtil.releaseResource(conn, ps, rs);
        }
        return datas;
    }

    @Override
    public int deleteXdlAddress(XdlAddress address) {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DbcpUtil.getConnection();
        try {
            String sql = "delete from XDL_RECEIVE_ADDRESS where reveive_address_id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,address.getReveive_address_id());
            int rows = ps.executeUpdate();
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbcpUtil.releaseResource(conn,ps,null);
        }
        return 0;
    }

    @Override
    public int updateAddress(XdlAddress address) {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DbcpUtil.getConnection();
        try {
            String sql = "update XDL_RECEIVE_ADDRESS set receive_name=?,province=?,address=?,zipcode=?,mobile=?,telephone=?,email=? where reveive_address_id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,address.getReceive_name());
            ps.setString(2,address.getProvince());
            ps.setString(3,address.getAddress());
            ps.setString(4,address.getZipcode());
            ps.setString(5,address.getMobile());
            ps.setString(6,address.getTelephone());
            ps.setString(7,address.getEmail());
            ps.setInt(8,address.getReveive_address_id());
            int rows = ps.executeUpdate();
            return  rows;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbcpUtil.releaseResource(conn,ps,null);
        }
        return 0;
    }
}
