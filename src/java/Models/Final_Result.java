/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author myths
 */
public class Final_Result {
   private int frID;
   private  int scoreID;
   private String status;

    @Override
    public String toString() {
        return "Final_Result{" + "frID=" + frID + ", scoreID=" + scoreID + ", status=" + status + '}';
    }

    public Final_Result(int scoreID, String status) {
        this.scoreID = scoreID;
        this.status = status;
    }

    public Final_Result(int frID, int scoreID, String status) {
        this.frID = frID;
        this.scoreID = scoreID;
        this.status = status;
    }

    public int getFrID() {
        return frID;
    }

    public void setFrID(int frID) {
        this.frID = frID;
    }

    public int getScoreID() {
        return scoreID;
    }

    public void setScoreID(int scoreID) {
        this.scoreID = scoreID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
}
