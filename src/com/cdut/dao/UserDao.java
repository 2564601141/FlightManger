package com.cdut.dao;

import com.cdut.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    /**
     * 登录检测
     * @param username
     * @param password
     * @return true/false
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean login(String username, String password) throws SQLException, ClassNotFoundException {
        Connection conn= JdbcUtils.getConnection();
        String sql="select * from user where uname=? and password=?";
        PreparedStatement pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,username);
        pstmt.setString(2,password);
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
            return true;
        }
        JdbcUtils.res(conn,pstmt,rs);
        return false;
    }

    /**
     * 注册
     * @param uname
     * @param pwd
     * @return true/false
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean sign(String uname, String pwd) throws SQLException, ClassNotFoundException {
        Connection conn=JdbcUtils.getConnection();
        String sql="insert into user values(null,?,?) ";
        PreparedStatement pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,uname);
        pstmt.setString(2,pwd);
        //执行sql语句
        int num=pstmt.executeUpdate();
        if (num>0){
            return true;
        }
        JdbcUtils.res(conn,pstmt);
        return false;
    }
}
