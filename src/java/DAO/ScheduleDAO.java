/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.*;
import Models.Group;
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
public class ScheduleDAO {

    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=Project_Prj_Ver1";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASSWORD = "123";
    public ArrayList<Schedule> getGroupByCourseID(String cid) {
        ArrayList<Schedule> scheduleList = new ArrayList<>();
        ArrayList<Group> groupList = new ArrayList<>();
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "SELECT * FROM [Group] g inner join Course c on g.cid=c.cid where g.cid=? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,cid);
            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (rs.next()) {
             Group grp=new Group();
                grp.setGid(rs.getString("gid"));
                grp.setGname(rs.getString("gname"));
                groupList.add(grp);
                Course courseF=new Course();
                courseF.setCid(rs.getString("cid"));
                courseF.setCname(rs.getString("cname"));
              courseF.setSemester(Integer.parseInt(rs.getString("semester")));
              courseF.setGroup(groupList);
              courseList.add(courseF);
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return groupList;
    }
}
