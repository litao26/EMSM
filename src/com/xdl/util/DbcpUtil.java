package com.xdl.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DbcpUtil {
    // dataSource  叫数据源对象  也叫连接池对象
    private  static  DataSource  dataSource;
    static{
        // 读取src 下的 db.properties   src 叫类加载路径 所以类加载器读取
        InputStream  inputStream =
                DbcpUtil.class.getClassLoader().getResourceAsStream("db.properties");
        // 构建一个Properties 对象 来使用InputStream 读取其中的值
        Properties  pro  = new  Properties();
        try {
            pro.load(inputStream);
            dataSource = BasicDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public  static  Connection  getConnection(){
        try {
            return  dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
    // 释放资源 的方法
    public  static  void  releaseResource(Connection  conn,Statement st,
                                          ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                rs = null;
            }
        }

        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                st = null;
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                conn = null;
            }
        }
    }
}
