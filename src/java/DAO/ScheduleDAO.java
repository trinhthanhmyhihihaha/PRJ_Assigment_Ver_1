/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.*;
import Models.Group;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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

            // Truy vấn SQL để lấy thông tin sinh viên và trường cid từ bảng Course
            String sql = "DECLARE @StudentId NVARCHAR(50) = ?\n"
                    + "DECLARE @WeekStartDate DATE =?\n"
                    + "DECLARE @WeekEndDate DATE = ?;\n"
                    + "WITH CTE AS (\n"
                    + "    SELECT s.*, c.cid AS courseid, g.cid AS group_cid, st.status,\n"
                    + "           ROW_NUMBER() OVER (PARTITION BY s.scheduleid ORDER BY st.status) AS rn\n"
                    + "    FROM [dbo].[Schedule] s\n"
                    + "    JOIN [dbo].[Group] g ON s.gid = g.gid\n"
                    + "    JOIN [dbo].[Course] c ON g.cid = c.[cid]\n"
                    + "    LEFT JOIN [dbo].[Status] st ON s.scheduleid = st.scheduleid\n"
                    + "    WHERE s.[date] BETWEEN @WeekStartDate AND @WeekEndDate\n"
                    + "        AND s.[gid] IN (\n"
                    + "            SELECT gm.[gid]\n"
                    + "            FROM [dbo].[Group_member] gm\n"
                    + "            WHERE gm.[sid] = @StudentId and status IS NOT NULL\n"
                    + "        )\n"
                    + ")\n"
                    + "SELECT * FROM CTE WHERE rn = 1;";
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
                Date sqlDate = rs.getDate("date");
                LocalDate localDate = sqlDate.toLocalDate();
                s.setDate(localDate);
                s.setStatus(rs.getString("status"));
                s.setSlotNo(rs.getInt("slotNo"));
                s.setSlotTaken(rs.getBoolean("slotTaken"));
                // Lấy trường cid từ kết quả
                String cid = rs.getString("courseid");
                s.setCid(cid); // Đặt giá trị cid vào đối tượng Schedule
                scheduleList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return scheduleList;
    }

    public ArrayList<AttendanceRecord> getAttendanceData(String cid, String iid) {
        ArrayList<AttendanceRecord> attendanceData = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Viết câu lệnh SQL để truy vấn dữ liệu điểm danh
            String sql = "SELECT\n"
                    + "    S.sid AS StudentID,\n"
                    + "    S.sname AS StudentName,\n"
                    + "    C.cid AS CourseID,\n"
                    + "    C.cname AS CourseName,\n"
                    + "    St.status AS AttendanceStatus,\n"
                    + "    Sch.slotNo AS Slot,\n"
                    + "    Sch.date AS ClassDate\n"
                    + "FROM Student S\n"
                    + "INNER JOIN Status St ON S.sid = St.sid\n"
                    + "INNER JOIN Schedule Sch ON St.scheduleid = Sch.scheduleid\n"
                    + "INNER JOIN [Group] G ON Sch.gid = G.gid\n"
                    + "INNER JOIN Course C ON G.cid = C.cid\n"
                    + "INNER JOIN Instructor I ON Sch.iID = I.iID\n"
                    + "WHERE C.cid = ?\n"
                    + "  AND I.iID = ?; ";

            // Tạo PreparedStatement và thực hiện truy vấn SQL
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cid);
            stmt.setString(2, iid);
            rs = stmt.executeQuery();

            // Xử lý kết quả truy vấn và tạo đối tượng AttendanceRecord
            while (rs.next()) {
                AttendanceRecord a = new AttendanceRecord();
                String studentID = rs.getString("StudentID");
                String studentName = rs.getString("StudentName");
                Date date = rs.getDate("ClassDate");
                String courseId = rs.getString("CourseID");
                String attandancestatus = rs.getString("AttendanceStatus");
                String slotNo = rs.getString("Slot");
                a.setStudentName(studentName);
                a.setAttandanceStatus(attandancestatus);
                a.setClassDate(date);
                a.setCourseId(courseId);
                a.setStudentID(studentID);
                attendanceData.add(a);
            }
            return attendanceData;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return attendanceData;
    }

    public ArrayList<AttendanceRecord> getTimeData(String cid, String iid) {
        ArrayList<AttendanceRecord> attendanceData = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Viết câu lệnh SQL để truy vấn dữ liệu điểm danh
            String sql = "SELECT s.date as ClassDate\n"
                    + "FROM Schedule AS s\n"
                    + "INNER JOIN TimeSlots AS ts ON s.slotNo = ts.slotNo\n"
                    + "WHERE s.gid = (SELECT gid FROM [Group] WHERE cid = ?)\n"
                    + "  AND s.iID =? ; ";

            // Tạo PreparedStatement và thực hiện truy vấn SQL
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cid);
            stmt.setString(2, iid);
            rs = stmt.executeQuery();

            // Xử lý kết quả truy vấn và tạo đối tượng AttendanceRecord
            while (rs.next()) {
                AttendanceRecord a = new AttendanceRecord();
                a.setDate(rs.getDate("ClassDate"));
                attendanceData.add(a);
            }
            return attendanceData;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return attendanceData;
    }

    public ArrayList<AttendanceRecord> getStudentList(String cid, String iid) {
        ArrayList<AttendanceRecord> attendanceData = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Viết câu lệnh SQL để truy vấn dữ liệu điểm danh
            String sql = "SELECT DISTINCT\n"
                    + "    S.sid AS StudentID,\n"
                    + "    S.sname AS StudentName,\n"
                    + "    G.cid AS CourseID,\n"
                    + "    C.cname AS CourseName\n"
                    + "FROM Student S\n"
                    + "INNER JOIN Status St ON S.sid = St.sid\n"
                    + "INNER JOIN Schedule Sch ON St.scheduleid = Sch.scheduleid\n"
                    + "INNER JOIN [Group] G ON Sch.gid = G.gid\n"
                    + "INNER JOIN Course C ON G.cid = C.cid\n"
                    + "INNER JOIN Instructor I ON Sch.iID = I.iID\n"
                    + "WHERE C.cid =?\n"
                    + "  AND I.iID =?;";

            // Tạo PreparedStatement và thực hiện truy vấn SQL
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cid);
            stmt.setString(2, iid);
            rs = stmt.executeQuery();

            // Xử lý kết quả truy vấn và tạo đối tượng AttendanceRecord
            while (rs.next()) {
                AttendanceRecord a = new AttendanceRecord();
                String studentID = rs.getString("StudentID");
                String studentName = rs.getString("StudentName");

                String courseId = rs.getString("CourseID");
                a.setCourseId(courseId);
                a.setStudentID(studentID);
                a.setStudentName(studentName);
                attendanceData.add(a);
            }
            return attendanceData;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return attendanceData;
    }

    public ArrayList<Schedule> getScheduleByInstructorID(String instructorId, String startDate, String endDate) {
        ArrayList<Schedule> scheduleList = new ArrayList<>();
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin lịch học cho giảng viên
            String sql = "DECLARE @InstructorId NVARCHAR(50) = ?\n"
                    + "DECLARE @WeekStartDate DATE = ?\n"
                    + "DECLARE @WeekEndDate DATE = ?\n"
                    + "\n"
                    + "SELECT s.*\n"
                    + "FROM [dbo].[Schedule] s\n"
                    + "WHERE s.[date] BETWEEN @WeekStartDate AND @WeekEndDate\n"
                    + "    AND s.[iID] = @InstructorId;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, instructorId);
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
                s.setSlotNo(rs.getInt("SlotNo"));
                s.setSlotTaken(rs.getBoolean("slotTaken"));
                Date sqlDate = rs.getDate("date");
                LocalDate localDate = sqlDate.toLocalDate();
                s.setDate(localDate);
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
                    + "    S.slotNo,\n"
                    + " S.slotTaken,\n"
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
                Date sqlDate = rs.getDate("date");
                LocalDate localDate = sqlDate.toLocalDate();
                schedule.setDate(localDate);
                schedule.setContent(rs.getString("content"));
                schedule.setGid(rs.getString("gid"));
                schedule.setiID(rs.getString("iID"));
                schedule.setSlot(rs.getInt("slot"));
                schedule.setSlotNo(rs.getInt("slotNo"));
                schedule.setSlotTaken(rs.getBoolean("slotTaken"));
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

    public ArrayList<ScheduleInfo> getStudentInfo(String sid, String cid) {
        ArrayList<ScheduleInfo> scheduleInfoList = new ArrayList<>();

        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            String sql = "SELECT s.scheduleid AS MaLichHoc, c.cid AS MaKhoaHoc, s.date AS Date, ts.slotNo AS Slot, r.roomname AS Room, "
                    + "i.iname AS Lecturer, g.gname AS GroupName, st.status AS AttendanceStatus "
                    + "FROM Schedule s "
                    + "INNER JOIN TimeSlots ts ON s.slot = ts.slotNo "
                    + "INNER JOIN Room r ON s.roomid = r.roomid "
                    + "INNER JOIN Instructor i ON s.iID = i.iID "
                    + "INNER JOIN [Group] g ON s.gid = g.gid "
                    + "INNER JOIN Course c ON g.cid = c.cid "
                    + "LEFT JOIN Status st ON s.scheduleid = st.scheduleid "
                    + "WHERE st.sid = ? and c.cid =? ORDER BY s.slot";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sid);
            preparedStatement.setString(2, cid);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int scheduleId = resultSet.getInt("MaLichHoc");

                int slot = resultSet.getInt("Slot");
                String room = resultSet.getString("Room");
                String lecturer = resultSet.getString("Lecturer");
                String groupName = resultSet.getString("GroupName");
                String attendanceStatus = resultSet.getString("AttendanceStatus");

                ScheduleInfo scheduleInfo = new ScheduleInfo(scheduleId, slot, room, lecturer, groupName, attendanceStatus);
                scheduleInfoList.add(scheduleInfo);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return scheduleInfoList;
    }

    public ArrayList<ScheduleInfo> getScheduleInfo(String sid) {

        ArrayList<ScheduleInfo> scheduleInfoList = new ArrayList<>();

        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "SELECT s.scheduleid AS MaLichHoc, s.content AS NoiDungLichHoc, s.date AS NgayHoc, "
                    + "ts.slotNo AS SlotHoc, st.status AS TrangThai, st.sid AS MaSinhVien "
                    + "FROM Schedule s "
                    + "INNER JOIN TimeSlots ts ON s.slot = ts.slotNo "
                    + "LEFT JOIN Status st ON s.scheduleid = st.scheduleid "
                    + "INNER JOIN Student std ON st.sid = std.sid "
                    + "WHERE std.sid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sid);
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
        } catch (Exception ex) {
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
                    + "DECLARE @WeekEndDate DATE = ?;\n"
                    + "\n"
                    + "SELECT s.*, c.[cid] AS 'CourseID'\n"
                    + "FROM [dbo].[Schedule] s\n"
                    + "JOIN [dbo].[Group] g ON s.[gid] = g.[gid]\n"
                    + "JOIN [dbo].[Course] c ON g.[cid] = c.[cid]\n"
                    + "JOIN [dbo].[TimeSlots] ts ON s.slotNo = ts.[slotNo] \n"
                    + "WHERE s.[date] BETWEEN @WeekStartDate AND @WeekEndDate\n"
                    + "    AND s.[gid] IN (\n"
                    + "        SELECT gm.[gid]\n"
                    + "        FROM [dbo].[Group_member] gm\n"
                    + "        WHERE gm.[sid] = @StudentId\n"
                    + "    ) AND ts.[slotNo]=?";
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
                Date sqlDate = rs.getDate("date");
                LocalDate localDate = sqlDate.toLocalDate();
                s.setDate(localDate);
                s.setCourseid(rs.getString("CourseID"));
                s.setSlotNo(rs.getInt("slotNo"));
                s.setSlotTaken(rs.getBoolean("slotTaken"));
                scheduleList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return scheduleList;
    }

    public ArrayList<Schedule> getScheduleBySlotForInstructor(String id, String startDate, String endDate, int slot, boolean isStudent) {
        ArrayList<Schedule> scheduleList = new ArrayList<>();
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin lịch học
            String sql = "DECLARE @Id NVARCHAR(50) = ?\n"
                    + "DECLARE @WeekStartDate DATE = ?\n"
                    + "DECLARE @WeekEndDate DATE = ?\n"
                    + "\n"
                    + "SELECT s.*, c.[cid] AS 'CourseID'\n"
                    + "FROM [dbo].[Schedule] s\n"
                    + "JOIN [dbo].[Group] g ON s.[gid] = g.[gid]\n"
                    + "JOIN [dbo].[Course] c ON g.[cid] = c.[cid]\n";

            if (isStudent) {
                // Nếu là sinh viên, thêm điều kiện cho sinh viên
                sql += "WHERE s.[date] BETWEEN @WeekStartDate AND @WeekEndDate\n"
                        + "    AND s.[gid] IN (\n"
                        + "        SELECT gm.[gid]\n"
                        + "        FROM [dbo].[Group_member] gm\n"
                        + "        WHERE gm.[sid] = @Id and s.slot = ?\n"
                        + "    );";
            } else {
                // Nếu là giảng viên, thêm điều kiện cho giảng viên
                sql += "WHERE s.[date] BETWEEN @WeekStartDate AND @WeekEndDate\n"
                        + "    AND s.[iID] = @Id and s.slotNo = ?;";
            }

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
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
                Date sqlDate = rs.getDate("date");
                LocalDate localDate = sqlDate.toLocalDate();
                s.setDate(localDate);
                s.setCourseid(rs.getString("CourseID"));
                s.setSlotNo(rs.getInt("slotNo"));
                s.setSlotTaken(rs.getBoolean("slotTaken"));
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
        System.out.println(a.getTimeData("SWE201c", "sonnt5"));
    }
}
