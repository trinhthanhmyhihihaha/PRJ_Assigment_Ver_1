/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author myths
 */
import java.util.List;

public class AttendanceRecord {

    private String studentID;
    private String studentName;
    private double attendancePercentage;
    private List<String> attendanceList;
    private String courseId;
    private Date date;
    private String attandanceStatus;
    private Date classDate;

    public String getAttandanceStatus() {
        return attandanceStatus;
    }

    public void setAttandanceStatus(String attandanceStatus) {
        this.attandanceStatus = attandanceStatus;
    }

    public Date getClassDate() {
        return classDate;
    }

    public String getFormattedClassDate() {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM");
            return dateFormat.format(date);
        } else {
            return "";
        }
    }

    public void setClassDate(Date classDate) {
        this.classDate = classDate;
    }

    public AttendanceRecord(String studentID, String studentName, double attendancePercentage, List<String> attendanceList, String courseId, Date date) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.attendancePercentage = attendancePercentage;
        this.attendanceList = attendanceList;
        this.courseId = courseId;
        this.date = date;
    }

    public AttendanceRecord() {
    }

    @Override
    public String toString() {
        return "AttendanceRecord{" + "studentID=" + studentID + ", studentName=" + studentName + ", attendancePercentage=" + attendancePercentage + ", attendanceList=" + attendanceList + ", courseId=" + courseId + ", date=" + date + ", attandanceStatus=" + attandanceStatus + ", classDate=" + classDate + '}';
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getAttendancePercentage() {
        return attendancePercentage;
    }

    public void setAttendancePercentage(double attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    }

    public List<String> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<String> attendanceList) {
        this.attendanceList = attendanceList;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
