/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.ScheduleDAO;
import DAO.StatusDAO;
import Time.Week;
import DAO.WeekDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import Models.*;
import Time.Day;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author myths
 */
@WebServlet(name = "selectYearController", urlPatterns = {"/selectYear"})
public class selectYearController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet selectYearController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet selectYearController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String selectYear = "2023";
        HttpSession session = request.getSession();
        //String sid=(String)session.getAttribute("sid");
        String sid = "HE153132";

        System.out.println(selectYear);
        WeekDAO wd = new WeekDAO();
        ScheduleDAO sd = new ScheduleDAO();
        StatusDAO sttd=new StatusDAO();
        ArrayList<Week> weekList = wd.getInYearWeek(selectYear);

        String selectedWeek = request.getParameter("selectWeek");
        System.out.println("selectedWeek" + selectedWeek);
        String[] splitedWeek = selectedWeek.split("\\--");

            Map<Schedule,String> maplist=sd.getScheduleStatus();
        ArrayList<Status>sttlist=sttd.getScheduleBySlot(sid);
        ArrayList<Day> dayList = wd.getAllDayInWeek(splitedWeek[0], splitedWeek[1]);
        ArrayList<Schedule> scheduleList = sd.getScheduleBySID(sid, splitedWeek[0], splitedWeek[1]);
        ArrayList<Schedule> scheduleListslot1 = sd.getScheduleBySlot(sid, splitedWeek[0], splitedWeek[1], 1);
        ArrayList<Schedule> scheduleListslot2 = sd.getScheduleBySlot(sid, splitedWeek[0], splitedWeek[1], 2);
        ArrayList<Schedule> scheduleListslot3 = sd.getScheduleBySlot(sid, splitedWeek[0], splitedWeek[1], 3);
        ArrayList<Schedule> scheduleListslot4 = sd.getScheduleBySlot(sid, splitedWeek[0], splitedWeek[1], 4);

        System.out.println(splitedWeek[0]);
        System.out.println(splitedWeek[1]);
        System.out.println(scheduleList + "scueduleList");
        System.out.println(dayList + "daylist");
        System.out.println(selectedWeek + "selectedweek");
        System.out.println(sttlist+"sttlist");
        
        request.setAttribute("scheduleMap", maplist);
        request.setAttribute("sttlist", sttlist);
        request.setAttribute("schedulelist1", scheduleListslot1);
        request.setAttribute("schedulelist2", scheduleListslot2);
        request.setAttribute("schedulelist3", scheduleListslot3);
        request.setAttribute("schedulelist4", scheduleListslot4);
        request.setAttribute("schedulelist", scheduleList);
        request.setAttribute("selectYear", selectYear);
        request.setAttribute("daylist", dayList);
        request.setAttribute("weekList", weekList);
        request.getRequestDispatcher("Timeable.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
