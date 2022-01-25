package com.cdut.dao;

import com.cdut.domain.Flight;
import com.cdut.util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;

public class FlightDao {
    //获取航班id 匹配相应的航班信息
    public Flight EditFlight(int fid) throws SQLException, ClassNotFoundException {
        Connection conn = JdbcUtils.getConnection();//加载驱动，连接数据库
        String sql = "select * from flight  where fid=?";//编写sql语句
        PreparedStatement pstmt = conn.prepareStatement(sql);//预编译
        pstmt.setInt(1, fid);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            int fid2 = rs.getInt("fid");
            String flightNo = rs.getString("flightNo");
            String departureCity = rs.getString("departureCity");
            String arrivalCity = rs.getString("arrivalCity");
            String departureTime = rs.getString("departureTime");
            String arrivalTime = rs.getString("arrivalTime");
            Flight flt = new Flight(fid, flightNo, departureCity, arrivalCity, departureTime, arrivalTime);
            System.out.println("EditFlight");
            return flt;
        }
        return null;
    }

    //修改航班信息
    public void UpdateFlight(Flight flt) throws SQLException, ClassNotFoundException {
        System.out.println("进入UpdateFlightDao");
        Connection conn = JdbcUtils.getConnection();
        String sql = "update flight set flightNo=?,departureCity=?,arrivalCity=?,departureTime=?,arrivalTime=? where fid=?";//编写sql语句
        PreparedStatement pstmt = conn.prepareStatement(sql);//预编译
        //获取传递的具体值
        pstmt.setString(1, flt.getFlightNo());
        pstmt.setString(2, flt.getDepartureCity());
        pstmt.setString(3, flt.getArrivalCity());
        pstmt.setString(4, flt.getDepartureTime());
        pstmt.setString(5, flt.getArrivalTime());
        pstmt.setInt(6, flt.getFid());
        int num = pstmt.executeUpdate();
        if (num > 0) {
            System.out.println("ok");
        }
    }

    //查询所有航班信息
    public ArrayList<Flight> FindAll(String id, String dct, String act, String dti, String ati) throws SQLException, ClassNotFoundException {
        ArrayList<Flight> flights = new ArrayList<>();
        Connection conn = JdbcUtils.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "select * from flight ";
        String sql1 = Sql(id, dct, act, dti, ati);
        sql = sql + sql1;

        ResultSet set = stmt.executeQuery(sql);
        while (set.next()) {
            int fid = set.getInt("fid");
            String flightNo = set.getString("flightNo");
            String departureCity = set.getString("departureCity");
            String arrivalCity = set.getString("arrivalCity");
            String departureTime = set.getString("departureTime");
            String arrivalTime = set.getString("arrivalTime");

            Flight flight = new Flight(fid, flightNo, departureCity, arrivalCity, departureTime, arrivalTime);
            flights.add(flight);

        }
        return flights;
    }

    public String Sql(String id, String dct, String act, String dti, String ati) {
        String str = "";
        boolean b = true;
        if (id != "") {
            b = false;
            str = str + "where flightNo=" + '"' + id + '"';
        }
        if (dct != "") {
            if (b) {
                str = str + "where";
            } else {
                str = str + "and";
                b = false;
            }
            str = str + " departureCity =" + '"' + dct + '"';
        }
        if (act != "") {
            if (b) {
                str = str + "where";
            } else {
                str = str + "and";
                b = false;
            }
            str = str + " arrivalCity =" + '"' + act + '"';
        }
        if (dti != "") {
            if (b) {
                str = str + "where";
            } else {
                str = str + "and";
                b = false;
            }
            str = str + " departureTime>=" + '"' + dti + '"';
        }
        if (ati != "") {
            if (b) {
                str = str + "where";
            } else {
                str = str + "and";
                b = false;
            }
            str = str + " arrivalTime<=" + '"' + ati + '"';
        }
        System.out.println(str);
        return str;
    }

    /**
     * 添加
     * @param fh
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void addflight(Flight fh) throws SQLException, ClassNotFoundException {
        System.out.println("dao");
        Connection conn = JdbcUtils.getConnection();
        String sql = "insert into flight values(null,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        System.out.println(fh);
//        pstmt.setInt(1,fh.getFid());
        pstmt.setString(1, fh.getFlightNo());
        pstmt.setString(2, fh.getDepartureCity());
        pstmt.setString(3, fh.getArrivalCity());
        pstmt.setString(4, fh.getDepartureTime());
        pstmt.setString(5, fh.getArrivalTime());
        int num = pstmt.executeUpdate();
        if (num > 0) {
            System.out.println("添加成功");

        }
    }

    /**
     * 删除
     * @param fid
     * @return
     */
    public boolean delete(int fid) {
        System.out.println("进入删除deletedao");
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JdbcUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "delete from flight where fid=" + fid;
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.res(conn, stmt);
        }
        return false;
    }

}
