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
public class StatusDAO {

    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=Project_Prj_Ver1";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASSWORD = "123";

    public ArrayList<Status> getScheduleBySlot(String sid) {
        ArrayList<Status> statuslist = new ArrayList<>();
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "SELECT S.[sid],S.[slot],S.[sttid], S.[scheduleid],S.[check], S.[status]\n"
                    + "FROM [dbo].[Status] AS S\n"
                    + "INNER JOIN [dbo].[Schedule] AS Sch ON S.[scheduleid] = Sch.[scheduleid]\n"
                    + "INNER JOIN [dbo].[Group] AS G ON Sch.[gid] = G.[gid]\n"
                    + "WHERE S.[sid] = ?  ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sid);

            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (rs.next()) {
                Status s = new Status();
                s.setSid(rs.getString("sid"));
                s.setCheck(rs.getDate("check"));
                s.setScheduleID(rs.getInt("scheduleid"));
                s.setSlot(rs.getInt("slot"));
                s.setSttid(rs.getInt("sttid"));
                s.setStatus(rs.getString("status"));
                statuslist.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return statuslist;
    }

    public static void main(String[] args) {
        StatusDAO a = new StatusDAO();
        System.out.println(a.getScheduleBySlot("HE153132"));
    }

}
