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

    @Override
    public String toString() {
        return "ScheduleInfo{" + "maLichHoc=" + maLichHoc + ", noiDungLichHoc=" + noiDungLichHoc + ", ngayHoc=" + ngayHoc + ", slotHoc=" + slotHoc + ", trangThai=" + trangThai + ", maSinhVien=" + maSinhVien + '}';
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
