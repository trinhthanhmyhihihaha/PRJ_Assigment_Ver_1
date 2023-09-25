/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author myths
 */
public class Scores {
    private int scoreID;
    private String sid;
    private String gid;
    private float pt1_score;
    private float pt2_score;
    private float pt3_score;
    private float pe;
    private float fe;
    private float total_score;

    @Override
    public String toString() {
        return "Scores{" + "scoreID=" + scoreID + ", sid=" + sid + ", gid=" + gid + ", pt1_score=" + pt1_score + ", pt2_score=" + pt2_score + ", pt3_score=" + pt3_score + ", pe=" + pe + ", fe=" + fe + ", total_score=" + total_score + '}';
    }

    public int getScoreID() {
        return scoreID;
    }

    public void setScoreID(int scoreID) {
        this.scoreID = scoreID;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public float getPt1_score() {
        return pt1_score;
    }

    public void setPt1_score(float pt1_score) {
        this.pt1_score = pt1_score;
    }

    public float getPt2_score() {
        return pt2_score;
    }

    public void setPt2_score(float pt2_score) {
        this.pt2_score = pt2_score;
    }

    public float getPt3_score() {
        return pt3_score;
    }

    public void setPt3_score(float pt3_score) {
        this.pt3_score = pt3_score;
    }

    public float getPe() {
        return pe;
    }

    public void setPe(float pe) {
        this.pe = pe;
    }

    public float getFe() {
        return fe;
    }

    public void setFe(float fe) {
        this.fe = fe;
    }

    public float getTotal_score() {
        return total_score;
    }

    public void setTotal_score(float total_score) {
        this.total_score = total_score;
    }

    public Scores(String sid, String gid, float pt1_score, float pt2_score, float pt3_score, float pe, float fe, float total_score) {
        this.sid = sid;
        this.gid = gid;
        this.pt1_score = pt1_score;
        this.pt2_score = pt2_score;
        this.pt3_score = pt3_score;
        this.pe = pe;
        this.fe = fe;
        this.total_score = total_score;
    }

    public Scores(int scoreID, String sid, String gid, float pt1_score, float pt2_score, float pt3_score, float pe, float fe, float total_score) {
        this.scoreID = scoreID;
        this.sid = sid;
        this.gid = gid;
        this.pt1_score = pt1_score;
        this.pt2_score = pt2_score;
        this.pt3_score = pt3_score;
        this.pe = pe;
        this.fe = fe;
        this.total_score = total_score;
    }
    
}
