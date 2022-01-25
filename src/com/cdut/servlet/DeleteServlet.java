package com.cdut.servlet;

import com.cdut.service.FlightService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入deleteServlet");
        String strfid = request.getParameter("fid");
        FlightService service = new FlightService();
        System.out.println(strfid);
        int fid=Integer.valueOf(strfid);
        service.delete(fid);//空指针
        request.getRequestDispatcher("findServlet").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
