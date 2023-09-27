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
   private String comment;
   private String score_item;
   private float value;
   private float weight;
   private String cid;

    public Scores(int scoreID, String sid, String comment, String score_item, float value, float weight, String cid) {
        this.scoreID = scoreID;
        this.sid = sid;
        this.comment = comment;
        this.score_item = score_item;
        this.value = value;
        this.weight = weight;
        this.cid = cid;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getScore_item() {
        return score_item;
    }

    public void setScore_item(String score_item) {
        this.score_item = score_item;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
   

}
