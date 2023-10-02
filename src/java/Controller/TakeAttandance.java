/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;
    
import Models.*;
import DAO.CourseDAO;
import DAO.GroupDAO;
import DAO.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author myths
 */
@WebServlet(name = "TakeAttandance", urlPatterns = {"/TakeAttandance"})
public class TakeAttandance extends HttpServlet {

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
            out.println("<title>Servlet AttandanceController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AttandanceController at " + request.getContextPath() + "</h1>");
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
        HttpSession session =request.getSession();
       //    String cid=(String) session.getAttribute("cid");
      String cid = (String) request.getParameter("cid");
        System.out.println(cid);
        String gid = (String) request.getParameter("gid");
        System.out.println(gid);

        CourseDAO cd = new CourseDAO();
        StudentDAO sd = new StudentDAO();
        GroupDAO gd = new GroupDAO();
        ArrayList<Course> listAll = cd.getCourse();
        ArrayList<Group> listGroup = gd.getGroupByCourseID(cid);
       ArrayList<Student_Sub> listStudent=sd.getStudentAndStatus(cid,gid);
        System.out.println(listStudent);
        int totalCourse = cd.getTotalCourse();
        if(listStudent==null){
            request.setAttribute("listStudent", "Not found any student");
        }
        request.setAttribute("listStudent", listStudent);
        request.setAttribute("listGroup", listGroup);
        request.setAttribute("total", totalCourse);
        request.setAttribute("courselist", listAll);

        request.getRequestDispatcher("TakeAttandance.jsp").forward(request, response);
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
        processRequest(request, response);
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
