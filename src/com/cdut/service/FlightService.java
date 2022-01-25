package com.cdut.service;

import com.cdut.dao.FlightDao;
import com.cdut.domain.Flight;

import java.sql.SQLException;
import java.util.ArrayList;

public class FlightService {
    FlightDao dao = new FlightDao();
    ////获取航班id 匹配相应的航班信息
    public Flight EditFlight(int fid) throws SQLException, ClassNotFoundException {
         return dao.EditFlight(fid);
    }
    //修改航班信息
    public void UpdateFlight(Flight flt) throws SQLException, ClassNotFoundException {
        dao.UpdateFlight(flt);
        System.out.println("进入UpdateFlight SERVICE");
    }
    //查询所有航班信息
    public ArrayList<Flight> find(String id, String dct, String act, String dti, String ati) throws SQLException, ClassNotFoundException {
        ArrayList<Flight> flights = dao.FindAll(id, dct, act, dti, ati);
        return flights;
    }

    /**
     * 添加
     * @param fh
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void addflight(Flight fh) throws SQLException, ClassNotFoundException {
        System.out.println("service");
        dao.addflight(fh);
        System.out.println("service");
    }

    /**
     * 删除
     * @param fid
     */
    public void delete(int fid) {
        System.out.println("进入deleteService");
        dao.delete(fid);
    }

}
