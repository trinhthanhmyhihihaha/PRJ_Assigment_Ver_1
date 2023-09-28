/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Time.Week;
import Models.*;
import Time.Day;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author myths
 */
public class WeekDAO {

    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=Project_Prj_Ver1";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASSWORD = "123";

    public ArrayList<Week> getInYearWeek(String year) {
        ArrayList<Week> weekList = new ArrayList<>();
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "SELECT *\n"
                    + "FROM Weeks\n"
                    + "WHERE YEAR(WeekStartDate) IN (?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, year);
            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (rs.next()) {
                Week w = new Week();
                w.setStartWeek(rs.getDate("WeekStartDate"));
                w.setEndWeek(rs.getDate("WeekEndDate"));
                weekList.add(w);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return weekList;
    }

    public ArrayList<Week> getAllWeek() {
        ArrayList<Week> weekList = new ArrayList<>();
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "SELECT *"
                    + "FROM  Weeks;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (rs.next()) {
                Week w = new Week();
                w.setStartWeek(rs.getDate("WeekStartDate"));
                w.setEndWeek(rs.getDate("WeekEndDate"));
                weekList.add(w);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return weekList;
    }

     public ArrayList<Day> getAllDayInWeek(String start, String end) {
        ArrayList<Day> dayList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy các ngày/tháng/năm trong khoảng thời gian từ start đến end
            String sql = "DECLARE @WeekStartDate DATE = ?;\n"
                    + "DECLARE @WeekEndDate DATE = ?;\n"
                    + "\n"
                    + "WITH DateRange AS (\n"
                    + "    SELECT @WeekStartDate AS CurrentDate\n"
                    + "    UNION ALL\n"
                    + "    SELECT DATEADD(DAY, 1, CurrentDate)\n"
                    + "    FROM DateRange\n"
                    + "    WHERE CurrentDate < @WeekEndDate\n"
                    + ")\n"
                    + "\n"
                    + "SELECT\n"
                    + "    DAY(CurrentDate) AS Ngay,\n"
                    + "    MONTH(CurrentDate) AS Thang,\n"
                    + "    YEAR(CurrentDate) AS Nam\n"
                    + "FROM DateRange\n"
                    + "OPTION (MAXRECURSION 0);";
          
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, start);
            preparedStatement.setString(2, end);

            // Thực hiện truy vấn và lấy kết quả
            rs = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (rs.next()) {
                Day d = new Day();
                d.setDay(String.valueOf(rs.getInt("Ngay")));
                d.setMonth(String.valueOf(rs.getInt("Thang")));
                d.setYear(String.valueOf(rs.getInt("Nam")));
                dayList.add(d);
            }

            // In danh sách ngày trong khoảng thời gian
            System.out.println("List in week");
            System.out.println(dayList);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                // Đóng tất cả tài nguyên
                if (rs != null) {
                    rs.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return dayList;
    }

    public static void main(String[] args) {
        WeekDAO w = new WeekDAO();
        System.out.println(w.getAllDayInWeek("2023-03-10", "2023-03-30"));
    }
}
