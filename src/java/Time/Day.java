/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Time;

import java.sql.Date;
import java.time.LocalDate;

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
//  public Date toDate() {
//        String dateString = year + "-" + month + "-" + day;
//        return Date.valueOf(dateString);
//    }
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

      public LocalDate toDate() {
        return LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
    }
    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
