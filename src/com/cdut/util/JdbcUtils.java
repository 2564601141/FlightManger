package com.cdut.util;

import java.sql.*;

/**
 * JDBC连接工具类
 */
public class JdbcUtils {
    private final static String driver="com.mysql.jdbc.Driver";
    private final static String url="jdbc:mysql://localhost:3306/fm";
    private final static String user="root";
    private final static String password="123456";
    /**
     * 加载驱动
     * @throws ClassNotFoundException
     */
    public static void loadDriver() throws ClassNotFoundException {
        Class.forName(driver);
    }

    /**
     * 获取连接
     * @return 连接的数据库
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        loadDriver();
        Connection conn= DriverManager.getConnection(url,user,password);
        return conn;
    }

    /**
     * 关闭连接
     * @param conn
     * @param stmt
     * @param rs
     */
    public static void res(Connection conn , Statement stmt, ResultSet rs){
        try {
            conn.close();
            stmt.close();
            rs.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
    public static void res(Connection conn , Statement stmt){
        try {
            conn.close();
            stmt.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
