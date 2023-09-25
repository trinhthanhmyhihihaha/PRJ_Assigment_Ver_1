/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author myths
 */
public class Course {
    String cid;
    String cname;
    int semester;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Course(String cid, String cname, int semester) {
        this.cid = cid;
        this.cname = cname;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Course{" + "cid=" + cid + ", cname=" + cname + ", semester=" + semester + '}';
    }
    
}
