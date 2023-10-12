/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import Models.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author myths
 */
public class GroupDAO {

    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=Project_Prj_Ver1";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASSWORD = "123";
  public ArrayList<Group> getGroupByCourseID(String cid) {
        ArrayList<Course> courseList = new ArrayList<>();
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
              courseF.setSemester(Integer.parseInt(rs.getString("semester_id")));
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
    public ArrayList<Group> getListStudentByGroup(String groupName) {
        ArrayList<Group> group = new ArrayList<>();
        ArrayList<Student> studentList = new ArrayList<>();
        try {
            Connection connection = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Truy vấn SQL để lấy thông tin sinh viên
            String sql = "SELECT  s.sid,s.sname,s.susername,s.avatar,s.sstatus,s.dob,gm.gid from Student s, Group_member gm where gm.sid=s.sid and gm.gid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, groupName);

            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = preparedStatement.executeQuery();

            // Xử lý kết quả
            while (rs.next()) {
                Student st = new Student();
                st.setSid(rs.getString("sid"));
                st.setSname(rs.getString("sname"));
                st.setSusername(rs.getString("susername"));
                st.setImage(rs.getBytes("avatar"));
                st.setStatus(rs.getBoolean("sstatus"));
                st.setDob(rs.getDate("dob"));
                studentList.add(st);
                Group gr = new Group();
                gr.setGid(rs.getString("gid"));
                gr.setStudent(studentList);
                group.add(gr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return group;
    }

    public static void main(String[] args) {
        GroupDAO a = new GroupDAO();
        System.out.println(a.getListStudentByGroup("SE1701"));
    }
}
