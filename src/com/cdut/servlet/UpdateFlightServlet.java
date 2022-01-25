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

@WebServlet("/updateFlightServlet")
public class UpdateFlightServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println("进入updateFlightServlet");
        response.setContentType ( "text/html;charset=utf-8" );
        request.setCharacterEncoding ( "utf-8" );//防止乱码
        String strfid = request.getParameter ( "fid" );
        String flightNo= request.getParameter ( "flightNo" );
        String departureCity = request.getParameter ( "departureCity" );
        String arrivalCity = request.getParameter ( "arrivalCity" );
        String departureTime = request.getParameter ( "departureTime" );
        String arrivalTime = request.getParameter ( "arrivalTime" );
        int fid=Integer.valueOf ( strfid );
        Flight flt= new Flight(fid,flightNo,departureCity,arrivalCity,departureTime,arrivalTime);
        FlightService fs=new FlightService ();
            fs.UpdateFlight(flt);
        //页面跳转到FindAllFlight
        request.getRequestDispatcher ("findServlet").forward ( request,response );
        } catch (SQLException e) {
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
