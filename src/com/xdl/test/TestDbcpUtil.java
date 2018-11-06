package com.xdl.test;

import com.xdl.util.DbcpUtil;

import java.sql.Connection;

public class TestDbcpUtil {
    public static  void main(String [] agrs){
        Connection conn = DbcpUtil.getConnection();
        System.out.println(conn);
    }
}
