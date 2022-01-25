package com.cdut.servlet;

import com.cdut.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            // 获取数据
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //创建service对象
            UserService userService = new UserService();
            //登陆检测
            boolean flag = userService.login(username, password);
            if (flag) {
                //登录成功，跳转到管理页面
                request.getRequestDispatcher("/main.jsp").forward(request, response);
            } else {
                //登录失败，提示再次输入信息
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
