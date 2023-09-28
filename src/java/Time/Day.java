/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Time;

import java.sql.Date;

/**
 *
 * @author myths
 */
public class Day {
    private String year;
    private String month;
    private String day;

    // Constructor của lớp Day
    public Day(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Getter cho năm
    public String getYear() {
        return year;
    }

    public Day() {
    }

    // Getter cho tháng
    public String getMonth() {
        return month;
    }

    // Getter cho ngày
    public String getDay() {
        return day;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
