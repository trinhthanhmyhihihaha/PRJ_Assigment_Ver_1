/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author myths
 */
import java.util.HashMap;
import java.util.List;

public class ScheduleInfo {

    private Schedule schedule;
    private String courseStatus;

    public ScheduleInfo(Schedule schedule, String courseStatus) {
        this.schedule = schedule;
        this.courseStatus = courseStatus;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public ScheduleInfo() {
    }

    @Override
    public String toString() {
        return "ScheduleInfo{" + "schedule=" + schedule + ", courseStatus=" + courseStatus + '}';
    }
    
}
