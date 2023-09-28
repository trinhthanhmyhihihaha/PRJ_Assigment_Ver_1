/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

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
import java.sql.Date;
import java.text.SimpleDateFormat;

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
        System.out.println(selectYear);
        WeekDAO wd = new WeekDAO();

        ArrayList<Week> weekList = wd.getInYearWeek(selectYear);
        String selectedWeek = request.getParameter("selectWeek");
        String[] splitedWeek = selectedWeek.split("\\--");
  
        ArrayList<Day> dayList = wd.getAllDayInWeek(splitedWeek[0], splitedWeek[1]);
        System.out.println(dayList+"daylist");
        System.out.println(selectedWeek + "selectedweek");
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
