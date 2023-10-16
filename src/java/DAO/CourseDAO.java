/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.*;
import Models.Student;
import java.sql.Connection;
import java.sql.Date;
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
public class CourseDAO {

    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=Project_Prj_Ver1";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASSWORD = "123";

    public ArrayList<Course> getCourse() {
        ArrayList<Course> courseList = new ArrayList<>();
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "SELECT DISTINCT cid\n"
                    + "FROM Course;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (rs.next()) {
                Course c = new Course();
                c.setCid(rs.getString("cid"));
                courseList.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return courseList;
    }
      public ArrayList<Course> getCourseByIID(String iid) {
        ArrayList<Course> courseList = new ArrayList<>();
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "SELECT Course.*\n" +
"FROM Course\n" +
"WHERE cid IN (\n" +
"    SELECT cid\n" +
"    FROM [Group]\n" +
"    WHERE gid IN (\n" +
"        SELECT gid\n" +
"        FROM Schedule\n" +
"        WHERE iID = ?\n" +
"    )\n" +
");";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,iid);
            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (rs.next()) {
                Course c = new Course();
                c.setCid(rs.getString("cid"));
           
                courseList.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return courseList;
    }


    public int getTotalCourse() {
        int count = 0;
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "SELECT COUNT(DISTINCT cid) as total \n"
                    + "FROM Course;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (rs.next()) {
                count = rs.getInt("total");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return count;
    }

    public ArrayList<Course> getAllCourse() {
        ArrayList<Course> courseList = new ArrayList<>();
        ArrayList<Group> groupList = new ArrayList<>();
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "SELECT *\n"
                    + "FROM [Group] G\n"
                    + "INNER JOIN Schedule S ON G.gid = S.gid\n"
                    + "INNER JOIN Course C ON S.cid = C.cid ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (rs.next()) {
                Group grp = new Group();
                grp.setGid(rs.getString("gid"));
                grp.setGname(rs.getString("gname"));
                groupList.add(grp);
                Course courseF = new Course();
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

        return courseList;
    }

    public ArrayList<Course> getCourseByID(String cid) {
        ArrayList<Course> courseList = new ArrayList<>();
        ArrayList<Group> groupList = new ArrayList<>();
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "SELECT *\n"
                    + "FROM [Group] G\n"
                    + "INNER JOIN Schedule S ON G.gid = S.gid\n"
                    + "INNER JOIN Course C ON S.cid = C.cid where c.cid=? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cid);
            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (rs.next()) {
                Group grp = new Group();
                grp.setGid(rs.getString("gid"));
                grp.setGname(rs.getString("gname"));
                groupList.add(grp);
                Course courseF = new Course();
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

        return courseList;
    }

    public List<Map<String, Object>> getAllCourseOfStudent(String sid) {
        List<Map<String, Object>> courseList = new ArrayList<>();

        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "WITH RankedCourses AS (\n"
                    + "    SELECT\n"
                    + "        c.cid AS MaKhoaHoc,\n"
                    + "        c.cname AS TenKhoaHoc,\n"
                    + "        g.gid AS MaLop,\n"
                    + "        s.scheduleid AS MaLichHoc,\n"
                    + "        s.slot AS SLOT,\n"
                    + "        s.date AS NgayHoc,\n"
                    + "        ROW_NUMBER() OVER (PARTITION BY c.cid ORDER BY s.date) AS RowNum\n"
                    + "    FROM Course c\n"
                    + "    INNER JOIN [Group] g ON c.cid = g.cid\n"
                    + "    INNER JOIN Schedule s ON g.gid = s.gid\n"
                    + "    INNER JOIN Group_member gm ON g.gid = gm.gid\n"
                    + "    INNER JOIN Student st ON gm.sid = st.sid\n"
                    + "    WHERE st.sid = ?\n"
                    + ")\n"
                    + "SELECT\n"
                    + "    MaKhoaHoc,\n"
                    + "    TenKhoaHoc,\n"
                    + "    MaLop,\n"
                    + "    MaLichHoc,\n"
                    + "    SLOT,\n"
                    + "    NgayHoc\n"
                    + "FROM RankedCourses\n"
                    + "WHERE RowNum = 1;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sid);

            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Xử lý kết quả và thêm vào danh sách
            while (rs.next()) {
                Map<String, Object> courseInfo = new HashMap<>();
                courseInfo.put("MaKhoaHoc", rs.getString("MaKhoaHoc"));
                courseInfo.put("TenKhoaHoc", rs.getString("TenKhoaHoc"));
                courseInfo.put("MaLop", rs.getString("MaLop"));
                courseInfo.put("MaLichHoc", rs.getInt("MaLichHoc")); // Thêm cột MaLichHoc
                courseInfo.put("NgayHoc", rs.getDate("NgayHoc"));

                courseList.add(courseInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return courseList;
    }

    public Date getStartDateCourse(String sid) {
        String date = "";
        Group group = new Group();
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "SELECT TOP 1 c.cid AS MaKhoaHoc, c.cname AS TenKhoaHoc, g.gid AS MaLop, s.scheduleid AS MaLichHoc, s.date AS NgayHoc\n"
                    + "FROM Course c\n"
                    + "INNER JOIN [Group] g ON c.cid = g.cid\n"
                    + "INNER JOIN Schedule s ON g.gid = s.gid\n"
                    + "INNER JOIN Group_member gm ON g.gid = gm.gid\n"
                    + "INNER JOIN Student st ON gm.sid = st.sid\n"
                    + "WHERE st.sid =? Order by s.date asc;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sid);
            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (rs.next()) {
                date = String.valueOf(rs.getDate("NgayHoc"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return Date.valueOf(date);
    }

    public static void main(String[] args) {
        CourseDAO a = new CourseDAO();
        System.out.println(a.getCourseByIID("hailt"));
    }
}
