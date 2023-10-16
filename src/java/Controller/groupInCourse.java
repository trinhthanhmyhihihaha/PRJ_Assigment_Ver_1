/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CourseDAO;
import DAO.GroupDAO;
import DAO.StudentDAO;
import Models.*;
import Models.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author myths
 */
@WebServlet(name = "groupInCourse", urlPatterns = {"/groupInCourse"})
public class groupInCourse extends HttpServlet {

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
            out.println("<title>Servlet groupInCourse</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet groupInCourse at " + request.getContextPath() + "</h1>");
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
          String cid=(String) request.getParameter("cid");
          String iid="sonnt5";
            System.out.println(cid);
        CourseDAO cd = new CourseDAO();
        StudentDAO sd= new StudentDAO();
        GroupDAO gd=new GroupDAO();
        ArrayList<Course> listAll = cd.getCourseByIID(iid);
        ArrayList<Group>listGroup=gd.getGroupByCourseIDAndIID(cid, iid);
        ArrayList<Student_Sub>listStudent=sd.getStudentInCourseAndGroup(cid, cid);
        int totalCourse = cd.getTotalCourse();
        HttpSession session= request.getSession();
        System.out.println("listALl"+listAll);
        session.setAttribute("cid",cid);
        request.setAttribute("listGroup", listGroup);
        request.setAttribute("total", totalCourse);
        request.setAttribute("courselist", listAll);
        request.setAttribute("cid",cid);
        request.getRequestDispatcher("GroupInCourse.jsp").forward(request, response);
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
