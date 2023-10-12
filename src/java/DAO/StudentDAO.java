/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author myths
 */
public class StudentDAO {

    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=Project_Prj_Ver1";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASSWORD = "123";

    // Phương thức để lấy thông tin sinh viên từ cơ sở dữ liệu
    public static Student getStudentByUsernamePassword(String username, String password) throws ClassNotFoundException {
        Connection connection = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sqlQuery = "SELECT * FROM Student WHERE susername= ? and spassword=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Thực hiện truy vấn và lấy kết quả
            ResultSet resultSet = preparedStatement.executeQuery();

            // Xử lý kết quả
            if (resultSet.next()) {
                Student student = new Student();
                student.setSid(resultSet.getString("sid"));
                student.setSname(resultSet.getString("sname"));
                student.setSusername(resultSet.getString("susername"));
                student.setPassword(resultSet.getString("spassword"));
                student.setStatus(resultSet.getBoolean("sstatus"));
                student.setImage(resultSet.getBytes("avatar"));
                student.setRole(resultSet.getInt("role"));
                student.setDob(resultSet.getDate("dob"));

                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối sau khi hoàn thành
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }

    public ArrayList<Student_Sub> getStudentInCourseAndGroup(String course, String group) {
        ArrayList<Student_Sub> studentList = new ArrayList<>();
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "SELECT\n"
                    + "    s.sid,s.sname,\n"
                    + "    MAX(s.sname) AS TenSinhVien,\n"
                    + "    MAX(st.status) AS TrangThai\n"
                    + "FROM \n"
                    + "    Student s\n"
                    + "INNER JOIN \n"
                    + "    Group_Member gm ON s.sid = gm.sid\n"
                    + "INNER JOIN \n"
                    + "    [Group] g ON gm.gid = g.gid\n"
                    + "LEFT JOIN \n"
                    + "    [Status] st ON s.sid = st.sid\n"
                    + "WHERE \n"
                    + "    g.gid =?\n"
                    + "    AND g.cid = ? AND st.status IS NOT NULL\n"
                    + "GROUP BY\n"
                    + "    s.sid,s.sname;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, group);
            preparedStatement.setString(2, course);
            // Thực hiện truy vấn và lấy kết quả
            ResultSet resultSet = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (resultSet.next()) {

                Student_Sub student = new Student_Sub();
                student.setSid(resultSet.getString("sid"));
                student.setSname(resultSet.getString("sname"));
                student.setSusername(resultSet.getString("TenSinhVien"));

                student.setCoursestatus(resultSet.getString("TrangThai"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return studentList;
    }

    public void updateAttendance(List<String> sidList, List<String> statusList, String scheduleid) {
        try {
            Connection connection = null;
            PreparedStatement statusPreparedStatement = null;
            PreparedStatement schedulePreparedStatement = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Xây dựng câu lệnh SQL cập nhật cho [Status]
            String updateStatusQuery = "UPDATE [Status] SET status = ? WHERE sid = ? and scheduleid = ?";
            statusPreparedStatement = connection.prepareStatement(updateStatusQuery);

            // Xây dựng câu lệnh SQL cập nhật cho [Schedule]
            String updateScheduleQuery = "UPDATE [Schedule] SET slotTaken = 1 WHERE scheduleid = ?";
            schedulePreparedStatement = connection.prepareStatement(updateScheduleQuery);
            System.out.println(sidList+"sid líst");
            // Iterate through the sidList and statusList to update rows in [Status]
            for (int i = 0; i < sidList.size(); i++) {
                String sid = sidList.get(i);
                String status = statusList.get(i);

                // Set the parameters for [Status]
                statusPreparedStatement.setString(1, status);
                statusPreparedStatement.setString(2, sid);
                statusPreparedStatement.setString(3, scheduleid);
                // Execute the update for the current sid and status in [Status]
                statusPreparedStatement.executeUpdate();
            }

            // Set the parameter for [Schedule]
            schedulePreparedStatement.setString(1, scheduleid);

            // Execute the update for [Schedule]
           
            int updatedRows = schedulePreparedStatement.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("Successfully updated Schedule.");
            } else {
                System.out.println("No rows updated in Schedule.");
            }

            System.out.println("Successfully updated");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Student_Sub> getStudentAndStatus(String course, String group) {
        ArrayList<Student_Sub> studentList = new ArrayList<>();
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "SELECT\n"
                    + "    s.sid,s.sname,\n"
                    + "    MAX(s.sname) AS TenSinhVien,\n"
                    + "    MAX(st.status) AS TrangThai\n"
                    + "FROM \n"
                    + "    Student s\n"
                    + "INNER JOIN \n"
                    + "    Group_Member gm ON s.sid = gm.sid\n"
                    + "INNER JOIN \n"
                    + "    [Group] g ON gm.gid = g.gid\n"
                    + "LEFT JOIN \n"
                    + "    [Status] st ON s.sid = st.sid\n"
                    + "WHERE \n"
                    + "    g.gid =? \n"
                    + "    AND g.cid = ? AND st.status IS NOT NULL\n"
                    + "GROUP BY\n"
                    + "    s.sid,s.sname;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, group);
            preparedStatement.setString(2, course);
            // Thực hiện truy vấn và lấy kết quả
            ResultSet resultSet = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (resultSet.next()) {

                Student_Sub student = new Student_Sub();
                student.setSid(resultSet.getString("sid"));
                student.setSname(resultSet.getString("sname"));
                student.setSusername(resultSet.getString("TenSinhVien"));

                student.setCoursestatus(resultSet.getString("TrangThai"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return studentList;
    }

    public static void main(String[] args) {
        StudentDAO s = new StudentDAO();
        System.out.println(s.getStudentInCourseAndGroup("PRN211", "SE1702"));
    }
}
