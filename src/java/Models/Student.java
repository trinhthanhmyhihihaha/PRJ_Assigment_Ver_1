/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author myths
 */
public class Student {
    private String sid;
    private String sname;
    private String susername;
    private String password;
    private boolean status;
    private byte[] image;
    private int role;
    private Date dob;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Student() {
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
        return "Student{" + "sid=" + sid + ", sname=" + sname + ", susername=" + susername + ", password=" + password + ", status=" + status + ", image=" + image + ", role=" + role + ", dob=" + dob + '}';
    }

    public Student(String sid, String sname, String susername, String password, boolean status, byte[] image, int role, Date dob) {
        this.sid = sid;
        this.sname = sname;
        this.susername = susername;
        this.password = password;
        this.status = status;
        this.image = image;
        this.role = role;
        this.dob = dob;
    }
    
}
