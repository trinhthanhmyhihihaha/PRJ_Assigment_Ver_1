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
public class Status {
   private int sttid;
   private String sid;
   private Date check;
   private int slot;
   private String status;
   private String scheduleID;

    public Status(int sttid, String sid, Date check, int slot, String status, String scheduleID) {
        this.sttid = sttid;
        this.sid = sid;
        this.check = check;
        this.slot = slot;
        this.status = status;
        this.scheduleID = scheduleID;
    }

    @Override
    public String toString() {
        return "Status{" + "sttid=" + sttid + ", sid=" + sid + ", check=" + check + ", slot=" + slot + ", status=" + status + ", scheduleID=" + scheduleID + '}';
    }

    public int getSttid() {
        return sttid;
    }

    public void setSttid(int sttid) {
        this.sttid = sttid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Date getCheck() {
        return check;
    }

    public void setCheck(Date check) {
        this.check = check;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }
   
}
