/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author myths
 */
public class Schedule {

    private int scheduleid;
    private String iID;
    private String gid;
    private String roomid;
    private String content;
    private int slot;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private String courseid;
    private LocalDate date; // Thay đổi kiểu dữ liệu

    private String dayOfWeek; // Thêm trường này

    @Override
    public String toString() {
        return "Schedule{" + "scheduleid=" + scheduleid + ", iID=" + iID + ", gid=" + gid + ", roomid=" + roomid + ", content=" + content + ", slot=" + slot + ", date=" + date + ", courseid=" + courseid + '}';
    }

    public Schedule(int scheduleid, String iID, String gid, String roomid, String content, int slot, String courseid, LocalDate date, String dayOfWeek) {
        this.scheduleid = scheduleid;
        this.iID = iID;
        this.gid = gid;
        this.roomid = roomid;
        this.content = content;
        this.slot = slot;
        this.courseid = courseid;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Schedule() {
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public int getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(int scheduleid) {
        this.scheduleid = scheduleid;
    }

    public String getiID() {
        return iID;
    }

    public void setiID(String iID) {
        this.iID = iID;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

}
