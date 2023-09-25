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
    private String cid;
    private Date startDate;
    private Date endDate;

    @Override
    public String toString() {
        return "Schedule{" + "scheduleid=" + scheduleid + ", iID=" + iID + ", gid=" + gid + ", cid=" + cid + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }

    public Schedule(String iID, String gid, String cid, Date startDate, Date endDate) {
        this.iID = iID;
        this.gid = gid;
        this.cid = cid;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Schedule(int scheduleid, String iID, String gid, String cid, Date startDate, Date endDate) {
        this.scheduleid = scheduleid;
        this.iID = iID;
        this.gid = gid;
        this.cid = cid;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
}
