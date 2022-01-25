package com.cdut.servlet;

import com.cdut.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/signServlet")
public class SignServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //获取数据
            String uname = request.getParameter("username");
            String pwd = request.getParameter("password");
            String pwdag = request.getParameter("passwordAgain");
            //注册
            UserService userService = new UserService();
            boolean flag = false;
            //若两次密码一致，注册；若两次不一致，提示重新输入密码
            if (pwd.equals(pwdag)) {
                flag = userService.sign(uname, pwd);
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
