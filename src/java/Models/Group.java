/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author myths
 */
public class Group {
    private String gid;
    private String gname;

    @Override
    public String toString() {
        return "Group{" + "gid=" + gid + ", gname=" + gname + '}';
    }

    public Group(String gid, String gname) {
        this.gid = gid;
        this.gname = gname;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }
    
}
