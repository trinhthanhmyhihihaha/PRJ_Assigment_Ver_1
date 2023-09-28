/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Time;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author myths
 */
public class Week {
    private Date startWeek;
    private Date endWeek;
private List<Day> days;

    // Constructor của lớp Week
    public Week(List<Day> days) {
        this.days = days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    // Getter cho danh sách các ngày trong tuần
    public List<Day> getDays() {
        return days;
    }

    public Week() {
    }

    @Override
    public String toString() {
        return "Week{" + "startWeek=" + startWeek + ", endWeek=" + endWeek + '}';
    }

    public Date getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(Date startWeek) {
        this.startWeek = startWeek;
    }

    public Date getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(Date endWeek) {
        this.endWeek = endWeek;
    }

    public Week(Date startWeek, Date endWeek) {
        this.startWeek = startWeek;
        this.endWeek = endWeek;
    }
    
}
