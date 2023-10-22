/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Instructor;
import Models.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author myths
 */
public class InstructorDAO {
    
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=Project_Prj_Ver1";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASSWORD = "123";

    // Phương thức để lấy thông tin sinh viên từ cơ sở dữ liệu
    public Instructor getInstructorByUsernamePassword(String email, String password) throws ClassNotFoundException {
        Connection connection = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sqlQuery = "SELECT * FROM  Instructor WHERE email= ? and ipassword=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            // Thực hiện truy vấn và lấy kết quả
            ResultSet resultSet = preparedStatement.executeQuery();

            // Xử lý kết quả
            if (resultSet.next()) {
              Instructor in=new Instructor();
              in.setiID(resultSet.getString("iid"));
                in.setIname(resultSet.getString("iname"));
                in.setIusername(resultSet.getString("iusername"));
                in.setIpassword(resultSet.getString("ipassword"));
                in.setIstatus(resultSet.getBoolean("istatus"));
              in.setEmail(resultSet.getString("email"));
              return in;
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
    public static void main(String[] args) throws ClassNotFoundException {
        InstructorDAO a=new InstructorDAO();
        System.out.println(a.getInstructorByUsernamePassword("sonnt5@fpt.edu.vn","123"));
    }
}
