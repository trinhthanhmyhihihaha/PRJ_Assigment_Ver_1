/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author myths
 */
public class Instructor {
    private String iID;
    private String iname;
    private String iusername;
    private String ipassword;
    private boolean istatus;
    private String email;

    @Override
    public String toString() {
        return "Instructor{" + "iID=" + iID + ", iname=" + iname + ", iusername=" + iusername + ", ipassword=" + ipassword + ", istatus=" + istatus + ", email=" + email + '}';
    }

    public Instructor() {
    }

    public Instructor(String iID, String iname, String iusername, String ipassword, boolean istatus, String email) {
        this.iID = iID;
        this.iname = iname;
        this.iusername = iusername;
        this.ipassword = ipassword;
        this.istatus = istatus;
        this.email = email;
    }

    public String getiID() {
        return iID;
    }

    public void setiID(String iID) {
        this.iID = iID;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getIusername() {
        return iusername;
    }

    public void setIusername(String iusername) {
        this.iusername = iusername;
    }

    public String getIpassword() {
        return ipassword;
    }

    public void setIpassword(String ipassword) {
        this.ipassword = ipassword;
    }

    public boolean isIstatus() {
        return istatus;
    }

    public void setIstatus(boolean istatus) {
        this.istatus = istatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
