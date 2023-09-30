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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author myths
 */
public class ScheduleDAO {

    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=Project_Prj_Ver1";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASSWORD = "123";

    public ArrayList<Schedule> getScheduleBySID(String sid, String startDate, String endDate) {
        ArrayList<Schedule> scheduleList = new ArrayList<>();
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "DECLARE @StudentId NVARCHAR(50) =?\n"
                    + "DECLARE @WeekStartDate DATE = ?\n"
                    + "DECLARE @WeekEndDate DATE = ?\n"
                    + "\n"
                    + "SELECT s.*\n"
                    + "FROM [dbo].[Schedule] s\n"
                    + "WHERE s.[date] BETWEEN @WeekStartDate AND @WeekEndDate\n"
                    + "    AND s.[gid] IN (\n"
                    + "        SELECT gm.[gid]\n"
                    + "        FROM [dbo].[Group_member] gm\n"
                    + "        WHERE gm.[sid] = @StudentId\n"
                    + "    ); ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sid);
            preparedStatement.setString(2, startDate);
            preparedStatement.setString(3, endDate);

            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (rs.next()) {
                Schedule s = new Schedule();
                s.setScheduleid(rs.getInt("scheduleid"));
                s.setiID(rs.getString("iID"));
                s.setGid(rs.getString("gid"));
                s.setRoomid(rs.getString("roomid"));
                s.setContent(rs.getString("content"));
                s.setSlot(rs.getInt("slot"));
                s.setDate(rs.getDate("date"));
                scheduleList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return scheduleList;
    }

    public Map<Schedule, String> getScheduleStatus() {
        Map<Schedule, String> scheduleInfoMap = new HashMap<>();
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "SELECT\n"
                    + "    S.scheduleid,\n"
                    + "    S.iID ,\n"
                    + "    S.gid ,\n"
                    + "    S.roomid,\n"
                    + "    S.content,\n"
                    + "    S.slot,\n"
                    + "    S.date,\n"
                    + "    C.cid AS courseId,\n"
                    + "    ST.status\n"
                    + "FROM\n"
                    + "    Schedule S\n"
                    + "LEFT JOIN\n"
                    + "    [Status] ST ON S.scheduleid = ST.scheduleid\n"
                    + "LEFT JOIN\n"
                    + "    [Group] G ON S.gid = G.gid\n"
                    + "LEFT JOIN\n"
                    + "    Course C ON G.cid = C.cid;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setScheduleid(rs.getInt("scheduleId"));
                schedule.setCourseid(rs.getString("courseId"));
                schedule.setDate(rs.getDate("date"));
                schedule.setContent(rs.getString("content"));
                schedule.setGid(rs.getString("gid"));
                schedule.setiID(rs.getString("iID"));
                schedule.setSlot(rs.getInt("slot"));
                String courseStatus = rs.getString("status");
                scheduleInfoMap.put(schedule, courseStatus);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return scheduleInfoMap;
    }
public ArrayList<ScheduleInfo>getScheduleInfo(String sid) {
       
        ArrayList<ScheduleInfo> scheduleInfoList = new ArrayList<>();

        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
           String sql = "SELECT s.scheduleid AS MaLichHoc, s.content AS NoiDungLichHoc, s.date AS NgayHoc, " +
                    "ts.slotNo AS SlotHoc, st.status AS TrangThai, st.sid AS MaSinhVien " +
                    "FROM Schedule s " +
                    "INNER JOIN TimeSlots ts ON s.slot = ts.slotNo " +
                    "LEFT JOIN Status st ON s.scheduleid = st.scheduleid " +
                    "INNER JOIN Student std ON st.sid = std.sid " +
                    "WHERE std.sid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,sid);
            // Thực hiện truy vấn và lấy kết quả
          
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ScheduleInfo scheduleInfo = new ScheduleInfo();
                scheduleInfo.setMaLichHoc(resultSet.getInt("MaLichHoc"));
                scheduleInfo.setNoiDungLichHoc(resultSet.getString("NoiDungLichHoc"));
                scheduleInfo.setNgayHoc(resultSet.getString("NgayHoc"));
                scheduleInfo.setSlotHoc(resultSet.getInt("SlotHoc"));
                scheduleInfo.setTrangThai(resultSet.getString("TrangThai"));
                scheduleInfo.setMaSinhVien(resultSet.getString("MaSinhVien"));

                scheduleInfoList.add(scheduleInfo);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return scheduleInfoList;
    }
    public ArrayList<Schedule> getScheduleBySlot(String sid, String startDate, String endDate, int slot) {
        ArrayList<Schedule> scheduleList = new ArrayList<>();
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "DECLARE @StudentId NVARCHAR(50) = ?\n"
                    + "DECLARE @WeekStartDate DATE = ?\n"
                    + "DECLARE @WeekEndDate DATE = ?\n"
                    + "\n"
                    + "SELECT s.*, c.[cid] AS 'CourseID'\n"
                    + "FROM [dbo].[Schedule] s\n"
                    + "JOIN [dbo].[Group] g ON s.[gid] = g.[gid]\n"
                    + "JOIN [dbo].[Course] c ON g.[cid] = c.[cid]\n"
                    + "WHERE s.[date] BETWEEN @WeekStartDate AND @WeekEndDate\n"
                    + "    AND s.[gid] IN (\n"
                    + "        SELECT gm.[gid]\n"
                    + "        FROM [dbo].[Group_member] gm\n"
                    + "        WHERE gm.[sid] = @StudentId and slot=?\n"
                    + "    );";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sid);
            preparedStatement.setString(2, startDate);
            preparedStatement.setString(3, endDate);
            preparedStatement.setInt(4, slot);

            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (rs.next()) {
                Schedule s = new Schedule();
                s.setScheduleid(rs.getInt("scheduleid"));
                s.setiID(rs.getString("iID"));
                s.setGid(rs.getString("gid"));
                s.setRoomid(rs.getString("roomid"));
                s.setContent(rs.getString("content"));
                s.setSlot(rs.getInt("slot"));
                s.setDate(rs.getDate("date"));
                s.setCourseid(rs.getString("CourseID"));
                scheduleList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return scheduleList;
    }

    public static void main(String[] args) {
        ScheduleDAO a = new ScheduleDAO();
        System.out.println(a.getScheduleInfo("HE153132"));
    }
}
