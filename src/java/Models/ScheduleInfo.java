/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author myths
 */
import java.util.HashMap;
import java.util.List;

public class ScheduleInfo {

    private int maLichHoc;
    private String noiDungLichHoc;
    private String ngayHoc;
    private int slotHoc;
    private String trangThai;
    private String maSinhVien;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getLecturerComment() {
        return lecturerComment;
    }

    public ScheduleInfo(int maLichHoc, int slot, String room, String lecturer, String groupName, String attendanceStatus) {
        this.maLichHoc = maLichHoc;
        this.slot = slot;
        this.room = room;
        this.lecturer = lecturer;
        this.groupName = groupName;
        this.attendanceStatus = attendanceStatus;
       
    }

    public void setLecturerComment(String lecturerComment) {
        this.lecturerComment = lecturerComment;
    }
    private String date;
    private int slot;
    private String room;
    private String lecturer;
    private String groupName;
    private String attendanceStatus;
    private String lecturerComment;

    @Override
    public String toString() {
        return "ScheduleInfo{" + "maLichHoc=" + maLichHoc + ", noiDungLichHoc=" + noiDungLichHoc + ", ngayHoc=" + ngayHoc + ", slotHoc=" + slotHoc + ", trangThai=" + trangThai + ", maSinhVien=" + maSinhVien + ", date=" + date + ", slot=" + slot + ", room=" + room + ", lecturer=" + lecturer + ", groupName=" + groupName + ", attendanceStatus=" + attendanceStatus + '}';
    }


    public ScheduleInfo() {
    }

    public int getMaLichHoc() {
        return maLichHoc;
    }

    public void setMaLichHoc(int maLichHoc) {
        this.maLichHoc = maLichHoc;
    }

    public String getNoiDungLichHoc() {
        return noiDungLichHoc;
    }

    public void setNoiDungLichHoc(String noiDungLichHoc) {
        this.noiDungLichHoc = noiDungLichHoc;
    }

    public String getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(String ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public int getSlotHoc() {
        return slotHoc;
    }

    public void setSlotHoc(int slotHoc) {
        this.slotHoc = slotHoc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

}
