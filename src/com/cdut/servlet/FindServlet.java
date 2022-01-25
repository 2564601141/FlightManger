package com.cdut.servlet;

import com.cdut.domain.Flight;
import com.cdut.service.FlightService;
import com.cdut.dao.FlightDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/findServlet")
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html,charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String movecid1=null;
        String movecid2=null;
        String movecid3=null;
        String movecid4=null;
        String id=null;
        try {
        FlightService find=new FlightService ();

            ArrayList<Flight> flights = find.find(id, movecid1, movecid2, movecid3, movecid4);

            movecid1 = request.getParameter("movecid1");
            movecid2 = request.getParameter("movecid2");
            movecid3 = request.getParameter("movecid3");
            movecid4 = request.getParameter("movecid4");
            id = request.getParameter("keywords");

            flights=find.find(id, movecid3, movecid4, movecid1, movecid2);

            if (flights!= null) {
                request.setAttribute("list",flights);
                request.getRequestDispatcher("/list.jsp").forward(request, response);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
