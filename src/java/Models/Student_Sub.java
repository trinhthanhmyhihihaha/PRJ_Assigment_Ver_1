/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author myths
 */
public class Student_Sub {
    private String sid;
    private String sname;
    private String susername;
    private String password;
    private boolean status;
    private byte[] image;
    private int role;
    private Date dob;
    private String coursestatus;
    private ArrayList<Group> group=new ArrayList<>();
    public String getSid() {
        return sid;
    }

    public String getCoursestatus() {
        return coursestatus;
    }

    public void setCoursestatus(String coursestatus) {
        this.coursestatus = coursestatus;
    }

    public ArrayList<Group> getGroup() {
        return group;
    }

    public void setGroup(ArrayList<Group> group) {
        this.group = group;
    }

    public Student_Sub(String sid, String sname, String susername, String password, boolean status, byte[] image, int role, Date dob, String coursestatus) {
        this.sid = sid;
        this.sname = sname;
        this.susername = susername;
        this.password = password;
        this.status = status;
        this.image = image;
        this.role = role;
        this.dob = dob;
        this.coursestatus = coursestatus;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Student_Sub() {
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSusername() {
        return susername;
    }

    public void setSusername(String susername) {
        this.susername = susername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student_Sub{" + "sid=" + sid + ", sname=" + sname + ", coursestatus=" + coursestatus + '}';
    }


}
