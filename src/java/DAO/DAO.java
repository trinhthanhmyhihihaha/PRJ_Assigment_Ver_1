/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author myths
 */
public class DAO {
      public static void performDatabaseOperations() {
        // Thông tin kết nối đến cơ sở dữ liệu SQL Server
        String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=Project_Prj_Ver1";
        String username = "sa";
        String password = "123";

          Connection connection = null;

        try {
            // Kết nối đến cơ sở dữ liệu
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Thực hiện truy vấn SQL
            String sqlQuery = "SELECT * FROM Student";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            // Thực hiện truy vấn và lấy kết quả
            ResultSet resultSet = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (resultSet.next()) {
               
                String name = resultSet.getString("susername");
                // Xử lý các cột khác tương tự

                System.out.println(" Name: " + name);
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
            }
        }
    }
      public static void main(String[] args) {
        DAO a =new DAO();
        a.performDatabaseOperations();
    }
}
