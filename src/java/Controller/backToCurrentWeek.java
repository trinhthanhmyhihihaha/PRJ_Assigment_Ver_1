/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.ScheduleDAO;
import DAO.StatusDAO;
import DAO.WeekDAO;
import Models.Schedule;
import Models.Status;
import Time.Day;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import Time.Week;
import jakarta.servlet.http.HttpSession;
import java.util.Map;

/**
 *
 * @author myths
 */
@WebServlet(name = "backToCurrentWeek", urlPatterns = {"/backToCurrentWeek"})
public class backToCurrentWeek extends HttpServlet {

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
            out.println("<title>Servlet backToCurrentWeek</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet backToCurrentWeek at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        HttpSession session = request.getSession();
        String iid = (String) session.getAttribute("iid");
        String sid = (String) session.getAttribute("sid");
        if (iid == null ) {
            response.sendRedirect("Login.jsp");
        } else {

            Date currentDate = new Date(System.currentTimeMillis());
            String selectYear = "2023";
            System.out.println(currentDate + "Current Date");
            WeekDAO wd = new WeekDAO();
            ArrayList<Week> weekStorage = wd.getAllWeek();
            Week getWeek = null;
            java.sql.Date currentWeek = java.sql.Date.valueOf("2023-10-15"); // Đây là ngày hiện tại
            boolean isInWeek = false;

            for (Week week : weekStorage) {
                if (currentWeek.compareTo(week.getStartWeek()) >= 0 && currentWeek.compareTo(week.getEndWeek()) <= 0) {
                    // Ngày hiện tại nằm trong khoảng thời gian của tuần này
                    isInWeek = true;
                    getWeek = week;
                    break; // Thoát vòng lặp khi tìm thấy tuần hiện tại
                }
            }

            if (isInWeek) {
                // Ngày hiện tại nằm trong tuần nào đó trong danh sách weekList
                // Thực hiện các hành động cần thiết ở đây
                System.out.println("Ngày hiện tại nằm trong một tuần trong danh sách weekList.");
                System.out.println("getWeek" + getWeek);            //String sid=(String)session.getAttribute("sid");
                ScheduleDAO sd = new ScheduleDAO();
                StatusDAO sttd = new StatusDAO();
                ArrayList<Week> weekList = wd.getInYearWeek(selectYear);

                Map<Schedule, String> maplist = sd.getScheduleStatus();
                ArrayList<Status> sttlist = sttd.getScheduleBySlot(sid);
                ArrayList<Day> dayList = wd.getAllDayInWeek(getWeek.getStartWeek().toString(), getWeek.getEndWeek().toString());
                ArrayList<Schedule> scheduleList = sd.getScheduleByInstructorID(sid, getWeek.getStartWeek().toString(), getWeek.getEndWeek().toString());
                ArrayList<Schedule> scheduleListslot1 = sd.getScheduleBySlotForInstructor(sid, getWeek.getStartWeek().toString(), getWeek.getEndWeek().toString(), 1, false);
                ArrayList<Schedule> scheduleListslot2 = sd.getScheduleBySlotForInstructor(sid, getWeek.getStartWeek().toString(), getWeek.getEndWeek().toString(), 2, false);
                ArrayList<Schedule> scheduleListslot3 = sd.getScheduleBySlotForInstructor(sid, getWeek.getStartWeek().toString(), getWeek.getEndWeek().toString(), 3, false);
                ArrayList<Schedule> scheduleListslot4 = sd.getScheduleBySlotForInstructor(sid, getWeek.getStartWeek().toString(), getWeek.getEndWeek().toString(), 4, false);

                System.out.println(scheduleList + "scueduleList");
                System.out.println(dayList + "daylist");

                System.out.println(sttlist + "sttlist");

                request.setAttribute("scheduleMap", maplist);
                request.setAttribute("sttlist", sttlist);
                request.setAttribute("schedulelist1", scheduleListslot1);
                request.setAttribute("schedulelist2", scheduleListslot2);
                request.setAttribute("schedulelist3", scheduleListslot3);
                request.setAttribute("schedulelist4", scheduleListslot4);
                request.setAttribute("schedulelist", scheduleList);

                request.setAttribute("daylist", dayList);
                request.setAttribute("weekList", weekList);
                request.getRequestDispatcher("TimeableforInstructor.jsp").forward(request, response);
            } else {
                // Ngày hiện tại không nằm trong khoảng thời gian của bất kỳ tuần nào trong danh sách weekList
                System.out.println("Không tìm thấy tuần hiện tại.");
            }

        }
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
