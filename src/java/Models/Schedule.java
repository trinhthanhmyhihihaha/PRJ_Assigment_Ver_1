/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

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
   private Date date;

    public Schedule(int scheduleid, String iID, String gid, String roomid, String content, int slot, Date date) {
        this.scheduleid = scheduleid;
        this.iID = iID;
        this.gid = gid;
        this.roomid = roomid;
        this.content = content;
        this.slot = slot;
        this.date = date;
    }

    public Schedule() {
    }

    @Override
    public String toString() {
        return "Schedule{" + "scheduleid=" + scheduleid + ", iID=" + iID + ", gid=" + gid + ", roomid=" + roomid + ", content=" + content + ", slot=" + slot + ", date=" + date + '}';
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
