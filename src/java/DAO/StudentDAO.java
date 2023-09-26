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
import java.util.ArrayList;

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
     public ArrayList<Student> getStudentInCourseAndGroup(String course,String group) {
        ArrayList<Student> studentList= new ArrayList<>();
             try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "SELECT *\n" +
"FROM Student s\n" +
"INNER JOIN Group_member gm ON s.sid = gm.sid\n" +
"INNER JOIN [Group] g ON gm.gid = g.gid\n" +
"INNER JOIN Schedule sc ON g.gid = sc.gid\n" +
"INNER JOIN Course c ON sc.cid = c.cid\n" +
"WHERE c.cid = ?\n" +
"  AND g.gname = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
preparedStatement.setString(1,course);
preparedStatement.setString(2,group);
            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (rs.next()) {
             Student s=new Student();
             s.setSid(rs.getString("sid"));
             s.setSname(rs.getString("sname"));
             s.setImage(rs.getBytes("avatar"));
            studentList.add(s);
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
        System.out.println(s.getStudentInCourseAndGroup("LAB211", "SE1702"));
    }
}
