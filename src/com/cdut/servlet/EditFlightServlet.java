package com.cdut.servlet;

import com.cdut.domain.Flight;
import com.cdut.service.FlightService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet( "/editFlightServlet")
public class EditFlightServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println("进入editFlightServlet");
            response.setContentType ( "text/html;charset=utf-8" );
            request.setCharacterEncoding ( "utf-8" );//防止乱码
            String strfid = request.getParameter ( "fid" );//获取航班id
            System.out.println(strfid);
            int fid = Integer.valueOf ( strfid );
            //创建一个FlightService对象  调用EditFlight方法
            FlightService fs = new FlightService ();
            Flight flt = fs.EditFlight ( fid );
            //页面跳转到修改页面
            request.setAttribute ( "flt1", flt );
            request.getRequestDispatcher ( "/edit.jsp" ).forward ( request, response );

        } catch (SQLException e) {
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost ( request,response );
    }
}
