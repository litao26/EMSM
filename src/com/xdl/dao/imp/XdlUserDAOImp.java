package com.xdl.dao.imp;

import com.xdl.bean.XdlUser;
import com.xdl.dao.XdlUserDAO;
import com.xdl.util.DbcpUtil;
import com.xdl.util.Md5Util;

import java.sql.*;

public class XdlUserDAOImp implements XdlUserDAO {
    @Override
    public int insertXdlUser(XdlUser user) {
        //获取链接对象
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DbcpUtil.getConnection();
        try {
            String sql = "insert into xdl_user(user_id,login_name,password,email,recommender) values(xdl_user_user_id_seq.nextval,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1,user.getLogin_name());
            ps.setString(2, Md5Util.md5StrAndSalt(user.getPassword(),
                    user.getLogin_name()));
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getRecommender());
            //4.执行sql处理返回值
            int rows = ps.executeUpdate();
            return  rows;
        }catch (Exception e){
            e.printStackTrace();;
        }finally {
            //5.释放资源
            DbcpUtil.releaseResource(conn,ps,null);
        }
        return 0;
    }

    @Override
    public XdlUser  selectXdlUser(String login_name, String password) {
        Connection  conn = null;
        PreparedStatement  ps = null;
        ResultSet  rs  = null;
        //1.加载驱动  2.获取连接
        conn = DbcpUtil.getConnection();
        try {
            //3.定义sql  获取sql执行环境
            String sql = "select * from xdl_user where  login_name = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, login_name);
            ps.setString(2, Md5Util.md5StrAndSalt(password,
                    login_name));
            //4.获取返回值  处理结果集
            rs = ps.executeQuery();
            if(rs.next()){
                XdlUser  user = new XdlUser();
                user.setUser_id(rs.getInt("user_id"));
                user.setLogin_name(rs.getString("login_name"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //5.释放资源
            DbcpUtil.releaseResource(conn, ps, rs);
        }
        return null;
    }

    @Override
    public int updateXdlUser(XdlUser user) {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DbcpUtil.getConnection();
        try {
            String sql = "update xdl_user set password = ? where login_name=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,Md5Util.md5StrAndSalt(user.getPassword(),
                    user.getLogin_name()));
            ps.setString(2,user.getLogin_name());
            int rows = ps.executeUpdate();
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbcpUtil.releaseResource(conn,ps,null);
        }
        return 0;
    }

    @Override
    public int updateXdlNickname(XdlUser user) {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DbcpUtil.getConnection();
        try {
            String sql = "update xdl_user set nick_name = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getNick_name());
            int rows = ps.executeUpdate();
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbcpUtil.releaseResource(conn,ps,null);
        }
        return 0;
    }

    @Override
    public int updateXdlRealname(XdlUser user) {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DbcpUtil.getConnection();
        try {
            String sql = "update xdl_user set real_name = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getReal_name());
            int rows = ps.executeUpdate();
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbcpUtil.releaseResource(conn,ps,null);
        }
        return 0;
    }
    @Override
    public int updateXdlPcinfo(XdlUser user) {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DbcpUtil.getConnection();
        try {
            String sql = "update xdl_user set sex=?,birth=?,location=?,school=?,company=?,card_number=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getSex());
            ps.setTimestamp(2,user.getBirth());
            ps.setString(3,user.getLocation());
            ps.setString(4,user.getSchool());
            ps.setString(5,user.getCompany());
            ps.setString(6,user.getCard_number());
            int rows = ps.executeUpdate();
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbcpUtil.releaseResource(conn,ps,null);
        }
        return 0;
    }

    @Override
    public int updateXdlContactInfo(XdlUser user) {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DbcpUtil.getConnection();
        try {
            String sql = "update xdl_user set email=?,mobile=?,phone=?,msn=?,qq=?,website=?,send_address=?,zipcode=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getEmail());
            ps.setString(2,user.getMobile());
            ps.setString(3,user.getPhone());
            ps.setString(4,user.getMsn());
            ps.setString(5,user.getQq());
            ps.setString(6,user.getWebsite());
            ps.setString(7,user.getSend_address());
            ps.setString(8,user.getZipcode());
            int rows = ps.executeUpdate();
            return rows;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbcpUtil.releaseResource(conn,ps,null);
        }
        return 0;
    }

    @Override
    public int updateXdlHobby(XdlUser user) {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DbcpUtil.getConnection();
        try {
            String sql = "update xdl_user set hobby=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getHobby());
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
