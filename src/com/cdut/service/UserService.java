package com.cdut.service;

import com.cdut.dao.UserDao;

import java.sql.SQLException;

public class UserService {
    UserDao userDao=new UserDao();
    public boolean login(String username, String password) throws SQLException, ClassNotFoundException {
        return userDao.login(username,password);
    }
    public boolean sign(String uname, String pwd) throws SQLException, ClassNotFoundException {
        return userDao.sign(uname,pwd);
    }
}
